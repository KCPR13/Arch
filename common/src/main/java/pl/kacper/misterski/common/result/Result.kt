package pl.kacper.misterski.common.result

sealed class Result<out T> {
    data class Success<T>(val data: T) : Result<T>()
    data class Failure(val error: Throwable) : Result<Nothing>()
}

fun <T> Result<T>.getDataOrNull(): T? = (this as? Result.Success)?.data
