package com.zworthkey.rider2.ui.itemLifted;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zworthkey.rider2.R;

public class ItemsLiftedFragment extends Fragment {

    private ItemsLiftedViewModel mViewModel;

    public static ItemsLiftedFragment newInstance() {
        return new ItemsLiftedFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.items_lifted_fragment, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_items_lifted_table);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new ItemLiftedListRAdaptor());
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ItemsLiftedViewModel.class);
        // TODO: Use the ViewModel
    }

}