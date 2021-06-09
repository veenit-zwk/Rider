package com.zworthkey.rider2.data;

import android.util.Log;

import com.zworthkey.rider2.data.model.LoggedInUser;
import com.zworthkey.rider2.utils.Config;
import com.zworthkey.rider2.utils.RestroAPI;
import com.zworthkey.rider2.utils.RetrofitInitialization;
import com.zworthkey.rider2.utils.RetrofitResponseListener;
import com.zworthkey.rider2.utils.pojoClasses.PojoUserData;
import com.zworthkey.rider2.utils.pojoClasses.PojoUserResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {
    private PojoUserData pojoUserData = null;


    public Result<LoggedInUser> login(String username, String password, RetrofitResponseListener retrofitResponseListener) {

        try {


            Config config =new Config();
         Retrofit retrofit =  RetrofitInitialization.builder(config.getBaseUrl(),config.getToken());
            RestroAPI restroAPI = retrofit.create(RestroAPI.class);
            Call<PojoUserResponse> call = restroAPI.getUserLoginResponse(username,password);
            call.enqueue(new Callback<PojoUserResponse>() {
                @Override
                public void onResponse(Call<PojoUserResponse> call, Response<PojoUserResponse> response) {
                    PojoUserResponse pojoUserResponse =response.body();
                    if(pojoUserResponse==null)
                    {
                        retrofitResponseListener.onFailure("Server is Not Responding!!");
                        return;
                    }
                    pojoUserData = pojoUserResponse.getUserData();
                    if(pojoUserData.getLoginStatus().equals("success"))
                    {

                        new LoggedInUser(pojoUserData);
                        config.setRiderUsername(username);
                        config.setRiderUserPassword(password);
                        retrofitResponseListener.onSuccess();

                    }
                   else
                    {
                         retrofitResponseListener.onFailure(pojoUserResponse.getErrorMessage());
                    }

                    }


                @Override
                public void onFailure(Call<PojoUserResponse> call, Throwable t) {
                    Log.d("loginDataSource", "onFailure: "+t.getLocalizedMessage());
                    retrofitResponseListener.onFailure(t.getMessage());
                }
            });

            return new Result.Success<>(new LoggedInUser());


        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }

    }

    public void logout() {
        // TODO: revoke authentication
    }
}