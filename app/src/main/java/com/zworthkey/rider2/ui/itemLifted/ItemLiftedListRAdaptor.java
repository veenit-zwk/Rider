package com.zworthkey.rider2.ui.itemLifted;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zworthkey.rider2.R;

import org.jetbrains.annotations.NotNull;

public class ItemLiftedListRAdaptor extends RecyclerView.Adapter<ItemLiftedRHolder> {
    @NonNull
    @NotNull
    @Override
    public ItemLiftedRHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
       /* return null;*/
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false);
        return new ItemLiftedRHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ItemLiftedRHolder holder, int position) {
        holder.getTvSN().setText(""+position);
        holder.getTvProductId().setText("P_ID_0012"+(position%5));
        holder.getTvProductDeliveredCount().setText(position+5+"");
        holder.getTvQuantity().setText((position+1)*5+"");
        holder.getTvVendorId().setText("V_ID_00012"+position);
        holder.getTvProductType().setText(position%2==0?"Milk":"Butter");
        holder.getTvProductVariant().setText("1");


    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public int getItemViewType(int position) {
       /* return super.getItemViewType(position);*/
        return R.layout.rv_item_lifted_singlet;
    }
}
