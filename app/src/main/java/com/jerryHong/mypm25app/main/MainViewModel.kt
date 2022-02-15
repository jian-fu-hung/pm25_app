package com.jerryHong.mypm25app.main

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.*
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.jerryHong.mypm25app.RepoAdapter
import com.jerryHong.mypm25app.base.BaseViewModel
import com.jerryHong.mypm25app.data.DataModel
import com.jerryHong.mypm25app.data.model.RepoAQIHeaderResponse
import com.jerryHong.mypm25app.data.model.RepoAQIResponse
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.SchedulerSupport.IO
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import java.lang.ClassCastException
import java.lang.Exception
import java.util.*

class MainViewModel(private val dataModel: DataModel) : BaseViewModel() {

    private val repos = MutableLiveData<List<RepoAQIResponse>>()
    private val repoAQIResponses: List<RepoAQIResponse> = ArrayList()
    val repo: LiveData<List<RepoAQIResponse>>
        get() = repos


    val repoList = MutableLiveData<List<RepoAQIResponse>>()

    fun searchRepoRX(){
        addDisposable(dataModel.searchRepoRX()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<RepoAQIHeaderResponse<List<RepoAQIResponse>>>(){
                    override fun onSuccess(list: RepoAQIHeaderResponse<List<RepoAQIResponse>>) {
                        isLoading.postValue(false)
                        repoList.postValue(list.records)
                    }

                    override fun onError(e: Throwable) {
                        isLoading.postValue(false)
                    }

                }))
    }



    class MainViewModelFactory(private val dataModel: DataModel): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(MainViewModel::class.java)){
                return MainViewModel(dataModel) as T
            } else{
                throw ClassCastException("class error")
            }
        }
    }
}