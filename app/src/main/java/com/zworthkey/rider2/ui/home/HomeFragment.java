package com.zworthkey.rider2.ui.home;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.zworthkey.rider2.R;
import com.zworthkey.rider2.databinding.FragmentHomeBinding;
import com.zworthkey.rider2.ui.itemLifted.ItemsLiftedFragment;
import com.zworthkey.rider2.ui.payment.PaymentFragment;
import com.zworthkey.rider2.ui.refund.RefundFragment;
import com.zworthkey.rider2.ui.shipping.ShippingFragment;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        /*TODO Change orientation leads to crash this app*/
        try {
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        }catch (Exception e)
        {
            Toast.makeText(getContext(),"Null Exception Found",Toast.LENGTH_SHORT).show();
        }
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textViewGreeting = binding.textHome;
        final TextView textViewUserName = binding.textUsername;

        /*Onclick Operation on shipping CardVIew*/

        CardView cardViewShipping = binding.cardShipping;
        cardViewShipping.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().addToBackStack("home").replace(R.id.nav_host_fragment_content_main, new ShippingFragment(), "ShippingFragment").commit();
        });

        /*Onclick Operation ON Bottles CardVIew*/ /*This Should Be Same As shipping*/
        CardView cardViewBottles = binding.cardBottles;
        cardViewBottles.setOnClickListener(v -> getParentFragmentManager().beginTransaction().addToBackStack("home").replace(R.id.nav_host_fragment_content_main,new ShippingFragment(),"ShippingFragment").commit());

        /*Onclick Operation ON Payments CardVIew*/
        /*TODO Change the Required UI Fragments on Click of CardViews at Home*/
        CardView cardViewPayments = binding.cardPaymentHome;
        cardViewPayments.setOnClickListener(v -> getParentFragmentManager().beginTransaction().addToBackStack("home").replace(R.id.nav_host_fragment_content_main,new PaymentFragment(),"PaymentFragment").commit());

        /*Onclick Operation ON Refunds CardVIew*/
        /*TODO Change the Required UI Fragments on Click of CardViews at Home*/
        CardView cardViewRefunds = binding.cardRefundHome;
        cardViewRefunds.setOnClickListener(v -> getParentFragmentManager().beginTransaction().addToBackStack("home").replace(R.id.nav_host_fragment_content_main,new RefundFragment(),"RefundFragment").commit());

        /*Onclick Operation ON Items for supply CardVIew*/
        /*TODO Change the Required UI Fragments on Click of CardViews at Home*/
        CardView cardViewItemLifted = binding.cardProductTypesAndQuantity;
        cardViewItemLifted.setOnClickListener(v -> getParentFragmentManager().beginTransaction().addToBackStack("home").replace(R.id.nav_host_fragment_content_main,new ItemsLiftedFragment(),"ItemsLiftedFragment").commit());

        homeViewModel.getGreetingText().observe(getViewLifecycleOwner(), textViewGreeting::setText);
        homeViewModel.getUserName().observe(getViewLifecycleOwner(), textViewUserName::setText);
        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}