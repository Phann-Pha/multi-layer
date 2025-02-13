package com.domain.acleda.data.common.helper

import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class SingleUseCase
{
    protected var lastDisposable: Disposable? = null
    protected val compositeDisposable = CompositeDisposable()
    
    fun onDisposeLast()
    {
        lastDisposable?.let {
            if (!it.isDisposed)
            {
                it.dispose()
            }
        }
    }
    
    fun onDispose()
    {
        compositeDisposable.clear()
    }
}