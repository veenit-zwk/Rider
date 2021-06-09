package com.zworthkey.rider2.ui.shipping;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.zworthkey.rider2.R;
import com.zworthkey.rider2.utils.pojoClasses.PojoExample;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class ShippingListAdaptor extends RecyclerView.Adapter<ShippingRecycleViewHolder> {
     ArrayList<PojoExample> pojoExamples ;
     Fragment context;


    public ShippingListAdaptor(Fragment context, List<PojoExample> pojoExamples) {
        this.context=context;
        this.pojoExamples=(ArrayList<PojoExample>) pojoExamples;

    }




    @NonNull
    @NotNull
    @Override

    public ShippingRecycleViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

       /* return null;*/
        View view = LayoutInflater.from(context.getContext()).inflate(viewType,parent,false);


         /*   view.setOnClickListener(v -> {
            FragmentShippingSingle fragmentShippingSingle =new FragmentShippingSingle();
            MainActivity activity =(MainActivity) v.getContext();

            activity.getSupportFragmentManager().beginTransaction().addToBackStack("ShippingTableToday").add(R.id.nav_host_fragment_content_main, fragmentShippingSingle  ,"ShippingSingle").commit();

           *//* Toast.makeText(view.getContext(), "Hello from RV",Toast.LENGTH_SHORT).show();*//*
        });*/
        return new ShippingRecycleViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull @NotNull ShippingRecycleViewHolder holder, int position) {



                            PojoExample singleData = pojoExamples.get(position);
                            holder.getTvShippingId().setText(singleData.getDelivery().getId().toString());
                            holder.getTvShippingAddress().setText(singleData.getShippingAddress().getAddress1() + "\n" + singleData.getShippingAddress().getAddress2());
                            holder.getTvShippingStatus().setText(singleData.getDelivery().getOrderStatus());



                            holder.getTvShippingEmptyBottles().setText(singleData.getDelivery().getEmptyBottles().toString());
                            holder.getTvShippingOrderedItem().setText(singleData.getDelivery().getOrderId() + "");
                            holder.getTvShippingReceiverName().setText(singleData.getShippingAddress().getFirstName() + " " + singleData.getShippingAddress().getFirstName());
                            holder.getTvShippingSN().setText(position + 1 + "");

                            holder.itemView.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(context.getContext(), singleData.getDelivery().getId().toString(),Toast.LENGTH_LONG).show();
                            context.getParentFragmentManager().beginTransaction().addToBackStack("home").replace(R.id.nav_host_fragment_content_main,new FragmentShippingSingle(position),"ShippingFragment").commit();


                                }
                            });






    }

    @Override
    public int getItemCount() {
       if(pojoExamples!=null)
  return pojoExamples.size();
       else return 0;
    }

    @Override
    public int getItemViewType(int position) {
     /*   return super.getItemViewType(position);*/
        return R.layout.rv_item_shipping;

    }

}
