package com.zworthkey.rider2.utils.pojoClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


    public class PojoPayment {

        @SerializedName("payment_url")
        @Expose
        private String paymentUrl;
        @SerializedName("payment_method")
        @Expose
        private String paymentMethod;
        @SerializedName("payment_method_title")
        @Expose
        private String paymentMethodTitle;
        @SerializedName("paid")
        @Expose
        private Object paid;

        public String getPaymentUrl() {
            return paymentUrl;
        }

        public void setPaymentUrl(String paymentUrl) {
            this.paymentUrl = paymentUrl;
        }

        public PojoPayment withPaymentUrl(String paymentUrl) {
            this.paymentUrl = paymentUrl;
            return this;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public PojoPayment withPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public String getPaymentMethodTitle() {
            return paymentMethodTitle;
        }

        public void setPaymentMethodTitle(String paymentMethodTitle) {
            this.paymentMethodTitle = paymentMethodTitle;
        }

        public PojoPayment withPaymentMethodTitle(String paymentMethodTitle) {
            this.paymentMethodTitle = paymentMethodTitle;
            return this;
        }

        public Object getPaid() {
            return paid;
        }

        public void setPaid(String paid) {
            this.paid = paid;
        }

        public PojoPayment withPaid(String paid) {
            this.paid = paid;
            return this;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(PojoPayment.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
            sb.append("paymentUrl");
            sb.append('=');
            sb.append(((this.paymentUrl == null)?"<null>":this.paymentUrl));
            sb.append(',');
            sb.append("paymentMethod");
            sb.append('=');
            sb.append(((this.paymentMethod == null)?"<null>":this.paymentMethod));
            sb.append(',');
            sb.append("paymentMethodTitle");
            sb.append('=');
            sb.append(((this.paymentMethodTitle == null)?"<null>":this.paymentMethodTitle));
            sb.append(',');
            sb.append("paid");
            sb.append('=');
            sb.append(((this.paid == null)?"<null>":this.paid));
            sb.append(',');
            if (sb.charAt((sb.length()- 1)) == ',') {
                sb.setCharAt((sb.length()- 1), ']');
            } else {
                sb.append(']');
            }
            return sb.toString();
        }

    }

