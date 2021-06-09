package com.zworthkey.rider2.utils.pojoClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PojoExample {


    @SerializedName("shipping_add")
    @Expose
    private PojoShippingAddress shippingAdd;
    @SerializedName("delivery")
    @Expose
    private PojoDelivery delivery;
    @SerializedName("payment")
    @Expose
    private PojoPayment payment;

    public PojoShippingAddress getShippingAddress() {
        return shippingAdd;
    }

    public void setShippingAdd(PojoShippingAddress shippingAdd) {
        this.shippingAdd = shippingAdd;
    }

    public PojoExample withShippingAdd(PojoShippingAddress shippingAdd) {
        this.shippingAdd = shippingAdd;
        return this;
    }

    public PojoDelivery getDelivery() {
        return delivery;
    }

    public void setDelivery(PojoDelivery delivery) {
        this.delivery = delivery;
    }

    public PojoExample withDelivery(PojoDelivery delivery) {
        this.delivery = delivery;
        return this;
    }

    public PojoPayment getPayment() {
        return payment;
    }

    public void setPayment(PojoPayment payment) {
        this.payment = payment;
    }

    public PojoExample withPayment(PojoPayment payment) {
        this.payment = payment;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PojoExample.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("shippingAdd");
        sb.append('=');
        sb.append(((this.shippingAdd == null)?"<null>":this.shippingAdd));
        sb.append(',');
        sb.append("delivery");
        sb.append('=');
        sb.append(((this.delivery == null)?"<null>":this.delivery));
        sb.append(',');
        sb.append("payment");
        sb.append('=');
        sb.append(((this.payment == null)?"<null>":this.payment));
        sb.append("         string for payment start\n"+getDelivery().toString());
        sb.append("         string for payment start\n"+getPayment().toString());
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
