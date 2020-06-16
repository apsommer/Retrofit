package com.sommerengineering.retrofit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ViewModelUI extends ViewModel {

    // reference to repo and livedata observable it contains
    private Repository repository;
    private MutableLiveData<List<Location>> mutableLiveData;

    // pass repo in constructor for dependency injection
    public ViewModelUI() {
        repository = new Repository();
    }

    // called by the view to access observable in the repo (abstraction layer)
    public LiveData<List<Location>> getLocations() {
        if (mutableLiveData == null) {
            mutableLiveData = repository.requestLocations();
        }
        return mutableLiveData;
    }
}