package com.zworthkey.rider2.ui.payment;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zworthkey.rider2.R;

import org.jetbrains.annotations.NotNull;

public class PaymentRecyclerViewHolder extends RecyclerView.ViewHolder {

    TextView tvSN;
    TextView tvPaymentID;
    TextView tvCustomerID;
    TextView tvVendorID;
    TextView tvTransAmount;
    TextView tvPaymentStatus;

    public PaymentRecyclerViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);

        tvSN = itemView.findViewById(R.id.tv_sn);
        tvPaymentID = itemView.findViewById(R.id.tv_payment_id);
        tvCustomerID = itemView.findViewById(R.id.tv_customer_id);
        tvVendorID = itemView.findViewById(R.id.tv_vendor_id);
        tvTransAmount = itemView.findViewById(R.id.tv_transaction_amount);
        tvPaymentStatus = itemView.findViewById(R.id.tv_payment_status);
    }
    public TextView getTvPaymentSN() {
        return tvSN;
    }

    public TextView getTvCustomerID() {
        return tvCustomerID;
    }

    public TextView getTvPaymentID() {
        return tvPaymentID;
    }

    public TextView getTvPaymentStatus() {
        return tvPaymentStatus;
    }

    public TextView getTvTransAmount() {
        return tvTransAmount;
    }

    public TextView getTvVendorID() {
        return tvVendorID;
    }

}
