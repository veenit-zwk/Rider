package com.zworthkey.rider2.ui.refund;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zworthkey.rider2.R;

import org.jetbrains.annotations.NotNull;

public class RefundRecyclerViewAdaptor extends RecyclerView.Adapter<RefundRecyclerViewHolder> {

    @NonNull
    @NotNull
    @Override
    public RefundRecyclerViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false);
        return new RefundRecyclerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RefundRecyclerViewHolder holder, int position) {

        holder.getTvSN().setText(position+"");
        holder.getTvRefundID().setText("TXN19000"+position);
        holder.getTvCustomerID().setText("C_ID001221"+position);
        holder.getTvRefundStatus().setText(position%2==0?"Pending":"confirmed");
        holder.getTvTransAmount().setText((position%24+1)*10+"");
        holder.getTvVendorID().setText("V_ID0012121"+position);

    }

    @Override
    public int getItemCount() {
        return 100;
    }

    @Override
    public int getItemViewType(int position) {
        /*return super.getItemViewType(position);*/
        return R.layout.rv_item_refund;
    }
}
