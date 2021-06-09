package com.zworthkey.rider2.ui.shipping;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.zworthkey.rider2.utils.pojoClasses.PojoExample;

import java.util.ArrayList;
import java.util.List;

public class ShippingViewModel extends AndroidViewModel {

    // TODO: Implement the ViewModel

    private  ShippingRepository shippingRepository;
    static ArrayList<PojoExample> deliveryArrayList;

    public ShippingViewModel(Application application) {
        super(application);
        shippingRepository= new ShippingRepository(application);

        // call your Rest API in init method

    }

    public MutableLiveData<List<PojoExample>> getUserMutableLiveData() {
        if(shippingRepository.getCompleteDataFromServer()!=null) {
            return shippingRepository.getCompleteDataFromServer();
        }
        else{
            return new MutableLiveData<>();
        }
    }

}
