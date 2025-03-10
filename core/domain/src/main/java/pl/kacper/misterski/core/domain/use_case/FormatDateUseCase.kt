package pl.kacper.misterski.core.domain.use_case

import kotlinx.coroutines.flow.flow
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class FormatDateUseCase {

    operator fun invoke(date: OffsetDateTime) = flow {

       val result = runCatching {
            val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
            date.format(formatter)
        }

       if(result.isSuccess){
           result.getOrNull()?.let { formattedDate ->
               emit(pl.kacper.misterski.common.util.result.Result.Success(formattedDate))
           } ?: kotlin.run {
               emit(pl.kacper.misterski.common.util.result.Result.Failure(Exception("formatted date is null")))
           }
       }else {
           emit(pl.kacper.misterski.common.util.result.Result.Failure(result.exceptionOrNull() ?: Exception("format date exception")))

       }
    }

}