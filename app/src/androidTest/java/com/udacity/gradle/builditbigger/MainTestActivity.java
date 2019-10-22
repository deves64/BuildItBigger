package com.udacity.gradle.builditbigger;

public class MainTestActivity extends MainActivity {
    private GetJokeTestCallback mCallback;

    public void setGetJokeCallback(GetJokeTestCallback getJokeTestCallbackCallback){
        mCallback = getJokeTestCallbackCallback;
    }

    public interface GetJokeTestCallback {
        void onHandleResponseCalled(String result);
    }

    @Override
    public void handleGetJokeResponse(String result) {
        mCallback.onHandleResponseCalled(result);
    }
}
