package com.zworthkey.rider2.ui.riderUtils;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.button.MaterialButton;
import com.zworthkey.rider2.R;
import com.zworthkey.rider2.databinding.RiderUtilsFragmentBinding;
import com.zworthkey.rider2.ui.shipping.ShippingFragment;

import static android.app.Activity.RESULT_OK;

public class RiderUtilsFragment extends Fragment implements View.OnClickListener {

    private RiderUtilsViewModel mViewModel;
   private RiderUtilsFragmentBinding binding;

    public static RiderUtilsFragment newInstance() {
        return new RiderUtilsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.rider_utils_fragment, container, false);
        binding = RiderUtilsFragmentBinding.bind(view);
        MaterialButton btnViewPDFReport= binding.riderUtilsViewPdfReport;
        btnViewPDFReport.setOnClickListener(this);
        MaterialButton btnSherePDFReport= binding.riderUtilsSharePdfReport;
        btnSherePDFReport.setOnClickListener(this);
        MaterialButton btnNearestCustomer= binding.riderUtilsNearestCustomer;
        btnNearestCustomer.setOnClickListener(this);
        MaterialButton btnFindBestWay= binding.riderUtilsFindBestWay;
        btnFindBestWay.setOnClickListener(this);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(RiderUtilsViewModel.class);
        // TODO: Use the ViewModel
    }



    @Override
    public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.rider_utils_view_pdf_report:
                    Toast.makeText(getContext(),"View PDF",Toast.LENGTH_LONG).show();

                    Intent intent=new Intent();
                    intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
                    intent.addCategory(Intent.CATEGORY_OPENABLE);
                    intent.setType("application/pdf");
                    startActivityForResult(intent,1212);





                    break;
                case R.id.rider_utils_share_pdf_report:
                    Toast.makeText(getContext(),"Share PDF",Toast.LENGTH_LONG).show();
                    break;
                case R.id.rider_utils_nearest_customer:
                    Toast.makeText(getContext(),"Nearest Customer",Toast.LENGTH_LONG).show();
                    break;
                case R.id.rider_utils_find_best_way:
                    Toast.makeText(getContext(),"Best Way",Toast.LENGTH_LONG).show();
                    break;
                default:
                    Toast.makeText(getContext(),"Default Touch",Toast.LENGTH_LONG).show();
            }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1212:
                if (resultCode == RESULT_OK) {

                    Uri uri = data.getData();

                    PdfRendererBasicViewModel pdfRendererBasicViewModel = new ViewModelProvider(this).get(PdfRendererBasicViewModel.class);
                    pdfRendererBasicViewModel.setFilename(uri);
                    getParentFragmentManager().beginTransaction().addToBackStack("home").replace(R.id.nav_host_fragment_content_main, new PdfRendererBasicFragment(), "PDFRenderer").commit();


                }
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}