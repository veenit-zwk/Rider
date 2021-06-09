package com.zworthkey.rider2.utils;

import com.zworthkey.rider2.utils.pojoClasses.PojoExample;

import java.util.ArrayList;

public interface RetrofitResponseListener {
    public void onSuccess();


    public void onFailure(String message);

    void onSuccessResult(ArrayList<PojoExample> responseData);
}
