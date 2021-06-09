package com.zworthkey.rider2.ui.shipping;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zworthkey.rider2.R;
import com.zworthkey.rider2.databinding.FragmentShippingSingleFragmentBinding;

import org.jetbrains.annotations.NotNull;

public class FragmentShippingSingle extends Fragment {
private  FragmentShippingSingleFragmentBinding binding;
private String contactNumber;
private int shippingId;


    TextView shippingSinglePropertyTotalAmount;
    TextView shippingSinglePropertyProductVariant;
    TextView shippingSinglePropertyPaymentType;
    TextView shippingSinglePropertyPaymentStatus;
    TextView shippingSinglePropertyOtpCode;
    TextView shippingSinglePropertyOrderAmount;
    TextView shippingSinglePropertyGroessOrderAmount;
    TextView shippingSinglePropertyDeliveryNote;
    TextView shippingSinglePropertyDeliveryStatus;
    TextView shippingSinglePropertyBottels;
    TextView shippingSinglePropertyProductType;
    TextView tvShippingSingleHeading;

public FragmentShippingSingle(int shippingId)
{
    this.shippingId=shippingId;
}
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        /*TODO Change orientation leads to crash this app*/
       /* try {
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);

        }catch (Exception e)
        {
           Toast.makeText(getContext(),"Null Exception Found",Toast.LENGTH_SHORT).show();
        }*/
            View view= inflater.inflate(R.layout.fragment_shipping_single_fragment, container, false);
       binding = FragmentShippingSingleFragmentBinding.inflate(inflater,container,false);

        shippingSinglePropertyProductType=  (TextView)view.findViewById(R.id.shipping_single_property_product_type);
        shippingSinglePropertyBottels=  (TextView)  view.findViewById(R.id.shipping_single_property_bottels);
        shippingSinglePropertyDeliveryNote= (TextView)  (TextView) view.findViewById(R.id.shipping_single_property_delivery_note);
        shippingSinglePropertyDeliveryStatus= (TextView) view.findViewById(R.id.shipping_single_property_delivery_status);

        shippingSinglePropertyGroessOrderAmount= (TextView)view.findViewById(R.id.shipping_single_property_groess_order_amount);
        shippingSinglePropertyOrderAmount= (TextView) view.findViewById(R.id.shipping_single_property_order_amount);

        shippingSinglePropertyOtpCode=  (TextView)view.findViewById(R.id.shipping_single_property_otp_code);/* binding.shippingSinglePropertyOtpCode;*/
        shippingSinglePropertyPaymentStatus=  (TextView) view.findViewById(R.id.shipping_single_property_payment_status);

        shippingSinglePropertyPaymentType =   (TextView) view.findViewById(R.id.shipping_single_property_Payment_type);
        shippingSinglePropertyProductVariant= (TextView) view.findViewById(R.id.shipping_single_property_product_variant);
        shippingSinglePropertyTotalAmount= (TextView)view.findViewById(R.id.shipping_single_property_total_amount);
        tvShippingSingleHeading=  (TextView)  view.findViewById(R.id.tv_shipping_single_heading);


        Button btnCall = (Button) view.findViewById(R.id.call_to_customer);


        Log.d(" singleShipping", "onCreateView: "+shippingId+"  "+shippingSinglePropertyProductType
                +"  "+shippingSinglePropertyBottels+"  "+shippingSinglePropertyDeliveryNote
                +"  "+shippingSinglePropertyDeliveryStatus+"  "+shippingSinglePropertyGroessOrderAmount
                +"  "+shippingSinglePropertyOrderAmount+"  "+shippingSinglePropertyOtpCode
                +"  "+shippingSinglePropertyBottels+"  "+shippingSinglePropertyBottels
                +"  "+shippingSinglePropertyBottels+"  "+shippingSinglePropertyBottels
                +"  "+shippingSinglePropertyBottels+"  "+shippingSinglePropertyBottels);

        shippingSinglePropertyProductType.setText(ShippingViewModel.deliveryArrayList.get(shippingId).getDelivery().getProductId()+"");
        shippingSinglePropertyProductVariant.setText(ShippingViewModel.deliveryArrayList.get(shippingId).getDelivery().getVariationId()+"");
        tvShippingSingleHeading.setText((ShippingViewModel.deliveryArrayList.get(shippingId)).getDelivery().getId()+"");
        shippingSinglePropertyPaymentType.setText((ShippingViewModel.deliveryArrayList.get(shippingId).getPayment()).getPaymentMethod()+"");
        shippingSinglePropertyPaymentStatus.setText(ShippingViewModel.deliveryArrayList.get(shippingId).getPayment().getPaymentUrl()+"");

        shippingSinglePropertyBottels.setText(ShippingViewModel.deliveryArrayList.get(shippingId).getDelivery().getEmptyBottles()+"");
        shippingSinglePropertyDeliveryNote.setText(ShippingViewModel.deliveryArrayList.get(shippingId).getDelivery().getDeliveryNote()+"");
        shippingSinglePropertyDeliveryStatus.setText(ShippingViewModel.deliveryArrayList.get(shippingId).getDelivery().getStatus()+"");

        shippingSinglePropertyGroessOrderAmount.setText(ShippingViewModel.deliveryArrayList.get(shippingId).getDelivery().getShippingAmount()+"");
        shippingSinglePropertyOrderAmount.setText(ShippingViewModel.deliveryArrayList.get(shippingId).getDelivery().getShippingAmount()+"");
        shippingSinglePropertyTotalAmount.setText(ShippingViewModel.deliveryArrayList.get(shippingId).getDelivery().getShippingAmount()+"");

        shippingSinglePropertyOtpCode.setText("static otp for now: 123456");//todo get otp data from server


       /* shippingSinglePropertyProductVariant.setText(ShippingViewModel.deliveryArrayList.get(shippingId).getDelivery().getVariationId().toString());
        shippingSinglePropertyBottels.setText(ShippingViewModel.deliveryArrayList.get(shippingId).getDelivery().getEmptyBottles().toString());

*/
        contactNumber  =((TextView)view.findViewById(R.id.contact_number)).getText().toString();
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(! isCoontactAvailable())
               {

                  Toast.makeText(getContext(),"Contact is not available",Toast.LENGTH_SHORT).show();
                  return;
               }
               /* if(isCallPermissionGranted())
                {
                   *//* String customerNumber=tvContactNumber.getText().toString();*//*
                    callToCustomer(contactNumber);
                }
*/
                //todo call button is not implimentated yet

                /*Toast.makeText(getContext(),"kya bhai call kuin ni lg ri",Toast.LENGTH_SHORT).show();*/

            }


        });

       return view;
    }

    public boolean isCoontactAvailable()
    {
      if(contactNumber.length()>0)
        {
            return true;
        }
      return false;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    /* public void callToCustomer(String contact)
    {
        Intent callIntent =new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+contact));
        startActivity(callIntent);
    }*/

  /*  public boolean isCallPermissionGranted()
    {
        if(Build.VERSION.SDK_INT>=23)
        {
            if(ActivityCompat.checkSelfPermission(getContext(),Manifest.permission.CALL_PHONE)== PackageManager.PERMISSION_GRANTED)
            {
                return true;
            }
        }
        requestPermissions(new String[]{Manifest.permission.CALL_PHONE},1);
        return false;

    }*/

 /*   @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @NotNull String[] permissions, @NonNull @NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==1)
        {
            if(grantResults.length>0&&grantResults[0]==PackageManager.PERMISSION_GRANTED)
            {
                callToCustomer(contactNumber);
            }
        }
    }*/
}





