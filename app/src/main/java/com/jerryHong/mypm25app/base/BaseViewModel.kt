package com.jerryHong.mypm25app.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class BaseViewModel : ViewModel() {
    val isLoading = MutableLiveData<Boolean>()

    //建立Rxjava
    private val disposable = CompositeDisposable()
    protected fun addDisposable(d: Disposable) {
        disposable.add(d)
    }

    protected fun deleteDisposable(d: Disposable) {
        disposable.delete(d)
    }

    override fun onCleared() {
        //當viewmodel生命週期到clear關閉rxjava
        disposable.clear()
        super.onCleared()
    }
}