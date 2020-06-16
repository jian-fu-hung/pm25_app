package com.jerryHong.mypm25app.main;

import com.jerryHong.mypm25app.RepoAdapter;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public interface MainContract {
    interface view{

    }
    interface Presenter{

        void setAdapter(RepoAdapter adapter);

        void setSwipeRefreshLayout(SwipeRefreshLayout swipeRefreshLayout);

        void searchRepoRX();
    }

}
