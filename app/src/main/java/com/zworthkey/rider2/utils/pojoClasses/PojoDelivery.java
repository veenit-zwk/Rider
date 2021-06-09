package com.zworthkey.rider2.utils.pojoClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;




public class PojoDelivery {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("order_type")
    @Expose
    private String orderType;
    @SerializedName("order_item_id")
    @Expose
    private Object orderItemId;
    @SerializedName("ord_id")
    @Expose
    private String ordId;
    @SerializedName("total_delivery")
    @Expose
    private String totalDelivery;
    @SerializedName("remain_delivery")
    @Expose
    private String remainDelivery;
    @SerializedName("order_date")
    @Expose
    private String orderDate;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("delivery_interval")
    @Expose
    private String deliveryInterval;
    @SerializedName("days")
    @Expose
    private String days;
    @SerializedName("next_delivery")
    @Expose
    private String nextDelivery;
    @SerializedName("empty_bottles_total")
    @Expose
    private String emptyBottlesTotal;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("customer_id")
    @Expose
    private Object customerId;
    @SerializedName("renew_date")
    @Expose
    private String renewDate;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("osubscription_id")
    @Expose
    private String osubscriptionId;
    @SerializedName("schedule_date")
    @Expose
    private String scheduleDate;
    @SerializedName("delivery_date")
    @Expose
    private Object deliveryDate;
    @SerializedName("driver_id")
    @Expose
    private Object driverId;
    @SerializedName("receiver_name")
    @Expose
    private String receiverName;
    @SerializedName("received_bottles")
    @Expose
    private String receivedBottles;
    @SerializedName("empty_bottles")
    @Expose
    private String emptyBottles;
    @SerializedName("delivery_note")
    @Expose
    private String deliveryNote;
    @SerializedName("order_id")
    @Expose
    private Object orderId;
    @SerializedName("product_id")
    @Expose
    private Object productId;
    @SerializedName("variation_id")
    @Expose
    private Object variationId;
    @SerializedName("date_created")
    @Expose
    private Object dateCreated;
    @SerializedName("product_qty")
    @Expose
    private Object productQty;
    @SerializedName("product_net_revenue")
    @Expose
    private Object productNetRevenue;
    @SerializedName("product_gross_revenue")
    @Expose
    private Object productGrossRevenue;
    @SerializedName("coupon_amount")
    @Expose
    private Object couponAmount;
    @SerializedName("tax_amount")
    @Expose
    private Object taxAmount;
    @SerializedName("shipping_amount")
    @Expose
    private Object shippingAmount;
    @SerializedName("shipping_tax_amount")
    @Expose
    private Object shippingTaxAmount;
    @SerializedName("subs_status")
    @Expose
    private String subsStatus;
    @SerializedName("order_status")
    @Expose
    private String orderStatus;
    @SerializedName("subscription_id")
    @Expose
    private String subscriptionId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PojoDelivery withId(String id) {
        this.id = id;
        return this;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public PojoDelivery withOrderType(String orderType) {
        this.orderType = orderType;
        return this;
    }

    public Object getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Object orderItemId) {
        this.orderItemId = orderItemId;
    }

    public PojoDelivery withOrderItemId(Object orderItemId) {
        this.orderItemId = orderItemId;
        return this;
    }

    public String getOrdId() {
        return ordId;
    }

    public void setOrdId(String ordId) {
        this.ordId = ordId;
    }

    public PojoDelivery withOrdId(String ordId) {
        this.ordId = ordId;
        return this;
    }

    public String getTotalDelivery() {
        return totalDelivery;
    }

    public void setTotalDelivery(String totalDelivery) {
        this.totalDelivery = totalDelivery;
    }

    public PojoDelivery withTotalDelivery(String totalDelivery) {
        this.totalDelivery = totalDelivery;
        return this;
    }

    public String getRemainDelivery() {
        return remainDelivery;
    }

    public void setRemainDelivery(String remainDelivery) {
        this.remainDelivery = remainDelivery;
    }

    public PojoDelivery withRemainDelivery(String remainDelivery) {
        this.remainDelivery = remainDelivery;
        return this;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public PojoDelivery withOrderDate(String orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public PojoDelivery withStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getDeliveryInterval() {
        return deliveryInterval;
    }

    public void setDeliveryInterval(String deliveryInterval) {
        this.deliveryInterval = deliveryInterval;
    }

    public PojoDelivery withDeliveryInterval(String deliveryInterval) {
        this.deliveryInterval = deliveryInterval;
        return this;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public PojoDelivery withDays(String days) {
        this.days = days;
        return this;
    }

    public String getNextDelivery() {
        return nextDelivery;
    }

    public void setNextDelivery(String nextDelivery) {
        this.nextDelivery = nextDelivery;
    }

    public PojoDelivery withNextDelivery(String nextDelivery) {

        this.nextDelivery = nextDelivery;
        return this;
    }

    public String getEmptyBottlesTotal() {
        return emptyBottlesTotal;
    }

    public void setEmptyBottlesTotal(String emptyBottlesTotal) {
        this.emptyBottlesTotal = emptyBottlesTotal;
    }

    public PojoDelivery withEmptyBottlesTotal(String emptyBottlesTotal) {
        this.emptyBottlesTotal = emptyBottlesTotal;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PojoDelivery withStatus(String status) {
        this.status = status;
        return this;
    }

    public Object getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Object customerId) {
        this.customerId = customerId;
    }

    public PojoDelivery  withCustomerId(Object customerId) {
        this.customerId = customerId;
        return this;
    }

    public String getRenewDate() {
        return renewDate;
    }

    public void setRenewDate(String renewDate) {
        this.renewDate = renewDate;
    }

    public PojoDelivery withRenewDate(String renewDate) {
        this.renewDate = renewDate;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public PojoDelivery withCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public PojoDelivery withUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getOsubscriptionId() {
        return osubscriptionId;
    }

    public void setOsubscriptionId(String osubscriptionId) {
        this.osubscriptionId = osubscriptionId;
    }

    public PojoDelivery withOsubscriptionId(String osubscriptionId) {
        this.osubscriptionId = osubscriptionId;
        return this;
    }

    public String getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public PojoDelivery withScheduleDate(String scheduleDate) {
        this.scheduleDate = scheduleDate;
        return this;
    }

    public Object getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Object deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public PojoDelivery withDeliveryDate(Object deliveryDate) {
        this.deliveryDate = deliveryDate;
        return this;
    }

    public Object getDriverId() {
        return driverId;
    }

    public void setDriverId(Object driverId) {
        this.driverId = driverId;
    }

    public PojoDelivery withDriverId(Object driverId) {
        this.driverId = driverId;
        return this;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public PojoDelivery withReceiverName(String receiverName) {
        this.receiverName = receiverName;
        return this;
    }

    public String getReceivedBottles() {
        return receivedBottles;
    }

    public void setReceivedBottles(String receivedBottles) {
        this.receivedBottles = receivedBottles;
    }

    public PojoDelivery withReceivedBottles(String receivedBottles) {
        this.receivedBottles = receivedBottles;
        return this;
    }

    public String getEmptyBottles() {
        return emptyBottles;
    }

    public void setEmptyBottles(String emptyBottles) {
        this.emptyBottles = emptyBottles;
    }

    public PojoDelivery withEmptyBottles(String emptyBottles) {
        this.emptyBottles = emptyBottles;
        return this;
    }

    public String getDeliveryNote() {
        return deliveryNote;
    }

    public void setDeliveryNote(String deliveryNote) {
        this.deliveryNote = deliveryNote;
    }

    public PojoDelivery withDeliveryNote(String deliveryNote) {
        this.deliveryNote = deliveryNote;
        return this;
    }

    public Object getOrderId() {
        return orderId;
    }

    public void setOrderId(Object orderId) {
        this.orderId = orderId;
    }

    public PojoDelivery withOrderId(Object orderId) {
        this.orderId = orderId;
        return this;
    }

    public Object getProductId() {
        return productId;
    }

    public void setProductId(Object productId) {
        this.productId = productId;
    }

    public PojoDelivery withProductId(Object productId) {
        this.productId = productId;
        return this;
    }

    public Object getVariationId() {
        return variationId;
    }

    public void setVariationId(Object variationId) {
        this.variationId = variationId;
    }

    public PojoDelivery withVariationId(Object variationId) {
        this.variationId = variationId;
        return this;
    }

    public Object getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Object dateCreated) {
        this.dateCreated = dateCreated;
    }

    public PojoDelivery withDateCreated(Object dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public Object getProductQty() {
        return productQty;
    }

    public void setProductQty(Object productQty) {
        this.productQty = productQty;
    }

    public PojoDelivery withProductQty(Object productQty) {
        this.productQty = productQty;
        return this;
    }

    public Object getProductNetRevenue() {
        return productNetRevenue;
    }

    public void setProductNetRevenue(Object productNetRevenue) {
        this.productNetRevenue = productNetRevenue;
    }

    public PojoDelivery withProductNetRevenue(Object productNetRevenue) {
        this.productNetRevenue = productNetRevenue;
        return this;
    }

    public Object getProductGrossRevenue() {
        return productGrossRevenue;
    }

    public void setProductGrossRevenue(Object productGrossRevenue) {
        this.productGrossRevenue = productGrossRevenue;
    }

    public PojoDelivery withProductGrossRevenue(Object productGrossRevenue) {
        this.productGrossRevenue = productGrossRevenue;
        return this;
    }

    public Object getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(Object couponAmount) {
        this.couponAmount = couponAmount;
    }

    public PojoDelivery withCouponAmount(Object couponAmount) {
        this.couponAmount = couponAmount;
        return this;
    }

    public Object getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(Object taxAmount) {
        this.taxAmount = taxAmount;
    }

    public PojoDelivery withTaxAmount(Object taxAmount) {
        this.taxAmount = taxAmount;
        return this;
    }

    public Object getShippingAmount() {
        return shippingAmount;
    }

    public void setShippingAmount(Object shippingAmount) {
        this.shippingAmount = shippingAmount;
    }

    public PojoDelivery withShippingAmount(Object shippingAmount) {
        this.shippingAmount = shippingAmount;
        return this;
    }

    public Object getShippingTaxAmount() {
        return shippingTaxAmount;
    }

    public void setShippingTaxAmount(Object shippingTaxAmount) {
        this.shippingTaxAmount = shippingTaxAmount;
    }

    public PojoDelivery withShippingTaxAmount(Object shippingTaxAmount) {
        this.shippingTaxAmount = shippingTaxAmount;
        return this;
    }

    public String getSubsStatus() {
        return subsStatus;
    }

    public void setSubsStatus(String subsStatus) {
        this.subsStatus = subsStatus;
    }

    public PojoDelivery withSubsStatus(String subsStatus) {
        this.subsStatus = subsStatus;
        return this;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public PojoDelivery withOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
        return this;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public PojoDelivery withSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PojoDelivery.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("orderType");
        sb.append('=');
        sb.append(((this.orderType == null)?"<null>":this.orderType));
        sb.append(',');
        sb.append("orderItemId");
        sb.append('=');
        sb.append(((this.orderItemId == null)?"<null>":this.orderItemId));
        sb.append(',');
        sb.append("ordId");
        sb.append('=');
        sb.append(((this.ordId == null)?"<null>":this.ordId));
        sb.append(',');
        sb.append("totalDelivery");
        sb.append('=');
        sb.append(((this.totalDelivery == null)?"<null>":this.totalDelivery));
        sb.append(',');
        sb.append("remainDelivery");
        sb.append('=');
        sb.append(((this.remainDelivery == null)?"<null>":this.remainDelivery));
        sb.append(',');
        sb.append("orderDate");
        sb.append('=');
        sb.append(((this.orderDate == null)?"<null>":this.orderDate));
        sb.append(',');
        sb.append("startDate");
        sb.append('=');
        sb.append(((this.startDate == null)?"<null>":this.startDate));
        sb.append(',');
        sb.append("deliveryInterval");
        sb.append('=');
        sb.append(((this.deliveryInterval == null)?"<null>":this.deliveryInterval));
        sb.append(',');
        sb.append("days");
        sb.append('=');
        sb.append(((this.days == null)?"<null>":this.days));
        sb.append(',');
        sb.append("nextDelivery");
        sb.append('=');
        sb.append(((this.nextDelivery == null)?"<null>":this.nextDelivery));
        sb.append(',');
        sb.append("emptyBottlesTotal");
        sb.append('=');
        sb.append(((this.emptyBottlesTotal == null)?"<null>":this.emptyBottlesTotal));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("customerId");
        sb.append('=');
        sb.append(((this.customerId == null)?"<null>":this.customerId));
        sb.append(',');
        sb.append("renewDate");
        sb.append('=');
        sb.append(((this.renewDate == null)?"<null>":this.renewDate));
        sb.append(',');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null)?"<null>":this.createdAt));
        sb.append(',');
        sb.append("updatedAt");
        sb.append('=');
        sb.append(((this.updatedAt == null)?"<null>":this.updatedAt));
        sb.append(',');
        sb.append("osubscriptionId");
        sb.append('=');
        sb.append(((this.osubscriptionId == null)?"<null>":this.osubscriptionId));
        sb.append(',');
        sb.append("scheduleDate");
        sb.append('=');
        sb.append(((this.scheduleDate == null)?"<null>":this.scheduleDate));
        sb.append(',');
        sb.append("deliveryDate");
        sb.append('=');
        sb.append(((this.deliveryDate == null)?"<null>":this.deliveryDate));
        sb.append(',');
        sb.append("driverId");
        sb.append('=');
        sb.append(((this.driverId == null)?"<null>":this.driverId));
        sb.append(',');
        sb.append("receiverName");
        sb.append('=');
        sb.append(((this.receiverName == null)?"<null>":this.receiverName));
        sb.append(',');
        sb.append("receivedBottles");
        sb.append('=');
        sb.append(((this.receivedBottles == null)?"<null>":this.receivedBottles));
        sb.append(',');
        sb.append("emptyBottles");
        sb.append('=');
        sb.append(((this.emptyBottles == null)?"<null>":this.emptyBottles));
        sb.append(',');
        sb.append("deliveryNote");
        sb.append('=');
        sb.append(((this.deliveryNote == null)?"<null>":this.deliveryNote));
        sb.append(',');
        sb.append("orderId");
        sb.append('=');
        sb.append(((this.orderId == null)?"<null>":this.orderId));
        sb.append(',');
        sb.append("productId");
        sb.append('=');
        sb.append(((this.productId == null)?"<null>":this.productId));
        sb.append(',');
        sb.append("variationId");
        sb.append('=');
        sb.append(((this.variationId == null)?"<null>":this.variationId));
        sb.append(',');
        sb.append("dateCreated");
        sb.append('=');
        sb.append(((this.dateCreated == null)?"<null>":this.dateCreated));
        sb.append(',');
        sb.append("productQty");
        sb.append('=');
        sb.append(((this.productQty == null)?"<null>":this.productQty));
        sb.append(',');
        sb.append("productNetRevenue");
        sb.append('=');
        sb.append(((this.productNetRevenue == null)?"<null>":this.productNetRevenue));
        sb.append(',');
        sb.append("productGrossRevenue");
        sb.append('=');
        sb.append(((this.productGrossRevenue == null)?"<null>":this.productGrossRevenue));
        sb.append(',');
        sb.append("couponAmount");
        sb.append('=');
        sb.append(((this.couponAmount == null)?"<null>":this.couponAmount));
        sb.append(',');
        sb.append("taxAmount");
        sb.append('=');
        sb.append(((this.taxAmount == null)?"<null>":this.taxAmount));
        sb.append(',');
        sb.append("shippingAmount");
        sb.append('=');
        sb.append(((this.shippingAmount == null)?"<null>":this.shippingAmount));
        sb.append(',');
        sb.append("shippingTaxAmount");
        sb.append('=');
        sb.append(((this.shippingTaxAmount == null)?"<null>":this.shippingTaxAmount));
        sb.append(',');
        sb.append("subsStatus");
        sb.append('=');
        sb.append(((this.subsStatus == null)?"<null>":this.subsStatus));
        sb.append(',');
        sb.append("orderStatus");
        sb.append('=');
        sb.append(((this.orderStatus == null)?"<null>":this.orderStatus));
        sb.append(',');
        sb.append("subscriptionId");
        sb.append('=');
        sb.append(((this.subscriptionId == null)?"<null>":this.subscriptionId));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}



 