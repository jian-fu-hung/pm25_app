package com.jerryHong.mypm25app.base;

import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseViewModel extends ViewModel {
    //建立Rxjava
    private CompositeDisposable disposable = new CompositeDisposable();

    protected void addDisposable(Disposable d){
        disposable.add(d);
    }

    protected void deleteDisposable(Disposable d){
        disposable.delete(d);
    }

    @Override
    protected void onCleared() {
        //當viewmodel生命週期到clear關閉rxjava
        disposable.clear();
        super.onCleared();
    }
}
