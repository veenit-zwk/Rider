package com.zworthkey.rider2.ui.payment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zworthkey.rider2.R;

public class PaymentFragment extends Fragment {

    private PaymentViewModel mViewModel;

    public static PaymentFragment newInstance() {
        return new PaymentFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_payment,container,false);
        /*return inflater.inflate(R.layout.shippings_fragment, container, false);*/
       RecyclerView recyclerView = view.findViewById(R.id.rv_payments_list_table);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new PaymentRecyclerViewAdaptor());

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

}