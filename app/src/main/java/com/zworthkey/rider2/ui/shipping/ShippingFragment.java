package com.zworthkey.rider2.ui.shipping;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zworthkey.rider2.R;
import com.zworthkey.rider2.utils.pojoClasses.PojoExample;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ShippingFragment extends Fragment implements LifecycleOwner {

    @Nullable
    private Bundle savedInstanceState;
    ShippingFragment context;
    ShippingViewModel viewModel;
    RecyclerView recyclerView;
    ShippingListAdaptor recyclerViewAdapter;
    List<PojoExample> listPojoExample;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        context =this;


        View view=inflater.inflate(R.layout.shippings_fragment, container, false);
        recyclerView = view.findViewById(R.id.rv_shipping_table);
        recyclerView.setHasFixedSize(true);
        Log.d("oldData-mapping", "onCreateView: "+viewModel);
        Log.d("oldData-mapping", "onCreateView: "+ShippingViewModel.deliveryArrayList);


        if(viewModel==null) {
            viewModel = new ViewModelProvider(this).get(ShippingViewModel.class);
            listPojoExample =viewModel.getUserMutableLiveData().getValue();

        }
        if(ShippingViewModel.deliveryArrayList!=null)
        {
            listPojoExample =ShippingViewModel.deliveryArrayList;
        }


        recyclerViewAdapter =new ShippingListAdaptor(this,listPojoExample);
        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;




}

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        viewModel = new ViewModelProvider(this).get(ShippingViewModel.class);

        final Observer<List<PojoExample>> pojoExampleObserver = new Observer<List<PojoExample>>() {
            @Override
            public void onChanged(@Nullable final List<PojoExample> updatedList) {

                Toast.makeText(getContext(), updatedList.size() + "", Toast.LENGTH_LONG).show();
                ShippingViewModel.deliveryArrayList =(ArrayList<PojoExample>) updatedList;


                if (listPojoExample == null) {
                    listPojoExample = updatedList;
                    recyclerViewAdapter =new ShippingListAdaptor(context,listPojoExample);
                    recyclerView.setAdapter(recyclerViewAdapter);
                } else {


                    DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {

                        @Override
                        public int getOldListSize() {
                            return listPojoExample.size();
                        }

                        @Override
                        public int getNewListSize() {
                            return updatedList.size();
                        }

                        @Override
                        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                            return listPojoExample.get(oldItemPosition).getDelivery().getId() ==
                                    updatedList.get(newItemPosition).getDelivery().getId();
                        }

                        @Override
                        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                            PojoExample oldPojoExample = listPojoExample.get(oldItemPosition);
                            PojoExample newPojoExample = updatedList.get(newItemPosition);
                            return oldPojoExample.equals(newPojoExample);
                        }
                    });
                    result.dispatchUpdatesTo(recyclerViewAdapter);
                    listPojoExample = updatedList;

                }

            }

        };

        viewModel.getUserMutableLiveData().observeForever(pojoExampleObserver);

    }

}






   /* @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        // TODO: Use the ViewModel
        //Todo : Data returned by custome api is only for 3 static order IDs, The data returned by API should be based on current Date.
    }*/


