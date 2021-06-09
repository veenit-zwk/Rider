package com.zworthkey.rider2.ui.refund;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zworthkey.rider2.R;

import org.jetbrains.annotations.NotNull;

public class RefundRecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView tvSN;
    TextView tvRefundID;
    TextView tvCustomerID;
    TextView tvVendorID;
    TextView tvTransAmount;
    TextView tvRefundStatus;
    public RefundRecyclerViewHolder(@NonNull @NotNull View itemView) {
        super(itemView);

        tvSN = itemView.findViewById(R.id.tv_sn);
        tvCustomerID=  itemView.findViewById(R.id.tv_customer_id);
        tvRefundID = itemView.findViewById(R.id.tv_refund_id);
        tvVendorID= itemView.findViewById(R.id.tv_vendor_id);
        tvTransAmount =itemView.findViewById(R.id.tv_transaction_amount);
        tvRefundStatus=itemView.findViewById(R.id.tv_refund_status);
    }

    public TextView getTvRefundID() {
        return tvRefundID;
    }

    public TextView getTvVendorID() {
        return tvVendorID;
    }

    public TextView getTvTransAmount() {
        return tvTransAmount;
    }

    public TextView getTvCustomerID() {
        return tvCustomerID;
    }

    public TextView getTvRefundStatus() {
        return tvRefundStatus;
    }

    public TextView getTvSN() {
        return tvSN;
    }


}
