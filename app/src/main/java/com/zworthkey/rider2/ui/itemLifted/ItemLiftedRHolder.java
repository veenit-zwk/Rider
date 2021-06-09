package com.zworthkey.rider2.ui.itemLifted;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zworthkey.rider2.R;

import org.jetbrains.annotations.NotNull;

public class ItemLiftedRHolder extends RecyclerView.ViewHolder {
    TextView tvSN;
    TextView tvProductId;
    TextView tvVendorId;
    TextView tvProductType;
    TextView tvProductVariant;
    TextView tvProductDeliveredCount;
    TextView tvQuantity;


    public ItemLiftedRHolder(@NonNull @NotNull View itemView) {
        super(itemView);
        tvSN = itemView.findViewById(R.id.tv_sn);
        tvProductDeliveredCount= itemView.findViewById(R.id.tv_delivered);
        tvProductId =itemView.findViewById(R.id.tv_product_id);
        tvProductType=itemView.findViewById(R.id.tv_product_type);
        tvProductVariant = itemView.findViewById(R.id.tv_product_variant);
        tvVendorId= itemView.findViewById(R.id.tv_vendor_id);
        tvQuantity = itemView.findViewById(R.id.tv_quantity);

    }

    public TextView getTvSN() {
        return tvSN;
    }

    public TextView getTvProductDeliveredCount() {
        return tvProductDeliveredCount;
    }

    public TextView getTvProductId() {
        return tvProductId;
    }

    public TextView getTvProductType() {
        return tvProductType;
    }

    public TextView getTvProductVariant() {
        return tvProductVariant;
    }

    public TextView getTvQuantity() {
        return tvQuantity;
    }

    public TextView getTvVendorId() {
        return tvVendorId;
    }

}
