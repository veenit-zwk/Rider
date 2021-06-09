package com.zworthkey.rider2.ui.home;

import android.app.Application;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.zworthkey.rider2.utils.Config;
import com.zworthkey.rider2.utils.RestroAPI;
import com.zworthkey.rider2.utils.RetrofitInitialization;
import com.zworthkey.rider2.utils.pojoClasses.PojoExample;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomeRepository {
  private   MutableLiveData<List<PojoExample>> completeDataFromServer =new MutableLiveData<>();
  private   ArrayList<PojoExample> pojoExampleArrayList;
  private Application application;

    HomeRepository(Application application){
        this.application=application;
        Config config =new Config();
        Retrofit retrofit = RetrofitInitialization.builder(config.getBaseUrl(),config.getToken());
        RestroAPI api = retrofit.create(RestroAPI.class);
        Call <ArrayList<PojoExample>> call =api.getAnalyticsData(config.getRiderUsername(), config.getRiderUserPassword());
         call.enqueue(new Callback<ArrayList<PojoExample>>() {
             @Override
             public void onResponse(Call<ArrayList<PojoExample>> call, Response<ArrayList<PojoExample>> response) {
                 if (response.isSuccessful())
                 {
                     pojoExampleArrayList = response.body();
                     if(pojoExampleArrayList!=null){
                         completeDataFromServer.setValue(pojoExampleArrayList);
                         Toast.makeText(application.getApplicationContext(), "Data Fetched!",Toast.LENGTH_LONG).show();

                     }
                 }
                 else{
                     Toast.makeText(application.getApplicationContext(), "some Error",Toast.LENGTH_LONG).show();
                 }
             }

             @Override
             public void onFailure(Call<ArrayList<PojoExample>> call, Throwable t) {
                 Toast.makeText(application.getApplicationContext(), t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                    t.printStackTrace();
             }
         });
    }

    public MutableLiveData<List<PojoExample>> getCompleteDataFromServer() {
        return completeDataFromServer;
    }
}
