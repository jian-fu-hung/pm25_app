package com.jerryHong.mypm25app.data.model;

public class RepoAQIHeaderResponse<T> {
    private T records;

    public T getRecords() {
        return records;
    }

    public void setRecords(T records) {
        this.records = records;
    }
}
