package com.zworthkey.rider2.ui.shipping;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zworthkey.rider2.R;

import org.jetbrains.annotations.NotNull;

public class ShippingRecycleViewHolder extends RecyclerView.ViewHolder {
    private final TextView tvShippingId;

    private final TextView tvShippingAddress;
    private final TextView tvShippingStatus;
    private final TextView tvShippingEmptyBottles;
    private final TextView tvShippingReceiverName;
    private final TextView tvShippingOrderedItem;
    private final TextView tvShippingSN;

    public ShippingRecycleViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);


        tvShippingId = itemView.findViewById(R.id.tv_shipping_id);
        tvShippingAddress = itemView.findViewById(R.id.tv_shipping_address);
        tvShippingStatus =itemView.findViewById(R.id.tv_shipping_status);
        tvShippingEmptyBottles=itemView.findViewById(R.id.tv_shipping_empty_bottles);
        tvShippingReceiverName = itemView.findViewById(R.id.tv_shipping_receiver_name);
        tvShippingOrderedItem = itemView.findViewById(R.id.tv_shipping_ordered_items);
        tvShippingSN    = itemView.findViewById(R.id.tv_sn);


    }
    public TextView getTvShippingId(){
        return tvShippingId;
    }

    public TextView getTvShippingOrderedItem() {
        return tvShippingOrderedItem;
    }

    public TextView getTvShippingReceiverName() {
        return tvShippingReceiverName;
    }

    public TextView getTvShippingSN() {
        return tvShippingSN;
    }


    public TextView getTvShippingAddress(){
        return tvShippingAddress;
    }
    public TextView getTvShippingStatus(){
        return tvShippingStatus;
    }

    public TextView getTvShippingEmptyBottles() {
        return tvShippingEmptyBottles;
    }

}
