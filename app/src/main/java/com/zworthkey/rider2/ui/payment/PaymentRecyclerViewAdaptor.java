package com.zworthkey.rider2.ui.payment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zworthkey.rider2.R;

import org.jetbrains.annotations.NotNull;


public class PaymentRecyclerViewAdaptor extends RecyclerView.Adapter<PaymentRecyclerViewHolder> {

    @NonNull
    @NotNull
    @Override
    public PaymentRecyclerViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false);
        return new PaymentRecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PaymentRecyclerViewHolder holder, int position) {

        holder.getTvPaymentSN().setText(position+"");
        holder.getTvPaymentID().setText("TXN12000"+position);
        holder.getTvCustomerID().setText("C_ID001221"+position);
        holder.getTvPaymentStatus().setText(position%2==0?"Pending":"confirmed");
        holder.getTvTransAmount().setText((position%24+1)*200+"");
        holder.getTvVendorID().setText("V_ID0012121"+position);

    }

    @Override
    public int getItemCount() {
        return 100;
    }

    @Override
    public int getItemViewType(int position) {
      /*  return super.getItemViewType(position);*/
        return R.layout.rv_item_payment;
    }
}
