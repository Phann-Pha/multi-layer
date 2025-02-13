package com.domain.acleda.data.common.helper

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class BuildSingleUseCase<T : Any> : SingleUseCase()
{
    internal abstract fun buildSingleUseCase(): Single<T>
    
    fun execute(success: (T) -> Unit, error: (Throwable) -> Unit, terminate: () -> Unit = {})
    {
        onDisposeLast()
        lastDisposable = buildSingleUseCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterTerminate(terminate)
            .subscribe(success, error)
        
        lastDisposable?.let { value ->
            compositeDisposable.add(value)
        }
    }
}