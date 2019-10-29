package com.bravedroid.tabexperiment;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private int mCurrentTabPosition = 0;

    public int getCurrentTabPosition() {
        return mCurrentTabPosition;
    }

    public void setCurrentTabPosition(int currentTabPosition) {
        mCurrentTabPosition = currentTabPosition;
    }
}
