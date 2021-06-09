package com.zworthkey.rider2.ui.home;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.zworthkey.rider2.data.model.LoggedInUser;
import com.zworthkey.rider2.utils.pojoClasses.PojoExample;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<String> userName;
    private HomeRepository homeRepository;
    static ArrayList<PojoExample> homeAnalyticsData;

    public HomeViewModel(Application application) {
        super(application);
        mText = new MutableLiveData<>();
        Calendar calendar = Calendar.getInstance();
        int hour          = calendar.get(Calendar.HOUR);
        int am_pm = calendar.get(Calendar.AM_PM);
        if(am_pm == Calendar.PM ) {
            if (hour >= 4) {
                mText.setValue("Good Evening!");
            } else mText.setValue("Good Afternoon!");
        }
        else{
            mText.setValue("Good Morning!");
        }

        userName  =new MutableLiveData<>();
        userName.setValue(LoggedInUser.getDisplayName());
        homeRepository= new HomeRepository(application);

    }
    public MutableLiveData<List<PojoExample>> getUserMutableLiveData() {
        if(homeRepository.getCompleteDataFromServer()!=null) {
            return homeRepository.getCompleteDataFromServer();
        }
        else{
            return new MutableLiveData<>();
        }
    }


    public LiveData<String> getGreetingText() {
        return mText;
    }
    public LiveData<String> getUserName() {
        return userName;
    }

    public  void setText( String text) {
         mText.setValue(text);
    }
}




