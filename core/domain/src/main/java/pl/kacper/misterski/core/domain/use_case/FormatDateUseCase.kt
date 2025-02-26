package pl.kacper.misterski.core.domain.use_case

import kotlinx.coroutines.flow.flow
import pl.kacper.misterski.common.result.Result
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

// TODO K przykład use case używany w wielu feacherach
class FormatDateUseCase {

    operator fun invoke(date: OffsetDateTime) = flow {

       val result = runCatching {
            val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
            date.format(formatter)
        }

       if(result.isSuccess){
           result.getOrNull()?.let { formattedDate ->
               emit(Result.Success(formattedDate))
           } ?: kotlin.run {
               emit(Result.Failure(Exception("formatted date is null")))
           }
       }else {
           emit(Result.Failure(result.exceptionOrNull() ?: Exception("format date exception")))

       }
    }

}