package nekit.corporation.domain.usecases

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import nekit.corporation.yurtify.domain.Result

abstract class UseCase<
        I : UseCase.Request,
        O : UseCase.Response,
        >(private val configuration: Configuration) {

    fun execute(request: I) = process(request).map {

        Result.Success(it) as Result<O>
    }.flowOn(configuration.dispatcher).catch {
        emit(Result.Error(it.message.toString()))
    }


    internal abstract fun process(request: I): Flow<O>
    class Configuration(
        val dispatcher: CoroutineDispatcher,
    )

    interface Request
    interface Response
}