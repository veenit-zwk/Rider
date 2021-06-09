package com.zworthkey.rider2;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.zworthkey.rider2.data.model.LoggedInUser;
import com.zworthkey.rider2.databinding.ActivityMainBinding;
import com.zworthkey.rider2.utils.Config;
import com.zworthkey.rider2.utils.RestroAPI;
import com.zworthkey.rider2.utils.pojoClasses.PojoExample;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Retrofit;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import static android.content.Intent.ACTION_OPEN_DOCUMENT;
import static android.content.Intent.ACTION_PICK;
import static android.graphics.ImageDecoder.Source;
import static android.graphics.ImageDecoder.createSource;
import static android.graphics.ImageDecoder.decodeBitmap;

public class MainActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener{

    private static final int OPEN_IMAGES_REQUEST_CODE = 1200;
    private AppBarConfiguration mAppBarConfiguration;
    private ImageView profileImage;
    public static ArrayList<PojoExample>  pojoExampleArrayList;


    // declaring width and height
    // for our PDF file.
    int pageHeight = 1120;
    int pagewidth = 792;

    // creating a bitmap variable
    // for storing our images
    Bitmap bmp, scaledbmp;

    // constant code for runtime permissions
    private static final int PERMISSION_REQUEST_CODE = 200;
    // Request code for creating a PDF document.
    private static final int CREATE_FILE = 1;


    public static Call getRetrofitCallInstance(Retrofit retrofit,Config config)
    {
        RestroAPI restroAPI = retrofit.create(RestroAPI.class);
        Log.d("Config", "onCreate: "+config.getRiderUsername()+"  "+config.getRiderUserPassword());

        return restroAPI.getDeliveryData(config.getRiderUsername(),config.getRiderUserPassword());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.zworthkey.rider2.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());





        setSupportActionBar(binding.appBarMain.toolbar);
        TextView userName=binding.navView.getHeaderView(0).findViewById(R.id.text_Username);
        TextView userEmail=binding.navView.getHeaderView(0).findViewById(R.id.text_userEmail);
        userEmail.setText(LoggedInUser.getUserEmail());
        userName.setText(LoggedInUser.getDisplayName());

        profileImage= (ImageView) binding.navView.getHeaderView(0).findViewById(R.id.riderProfileImage);
    loadProfileLocal();

        profileImage.setOnClickListener(v ->{
            Intent intent = new Intent();

            intent.setAction(ACTION_OPEN_DOCUMENT)
                    .setAction(ACTION_PICK).setType("image/*")
                    .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                    .addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION)
                    .addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION);

            startActivityForResult(Intent.createChooser(intent,"Select Profile Picture"),OPEN_IMAGES_REQUEST_CODE);



                }
        );
        binding.appBarMain.fab.setOnClickListener(view -> {
            if (checkPermission())
                   /* generatePDF();*/
                createFile();
            else
                requestPermission();
                }
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()*/);
        DrawerLayout drawer = binding.drawerLayout;

        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_Shipping, R.id.nav_bottles,R.id.nav_utils,R.id.nav_logout,R.id.nav_help).setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

    }

    private void updateRiderProfileInLocalStorage(Bitmap bitmap) {



        /*boolean isAvailable= false;
boolean isWritable= false;
boolean isReadable= false;
String state = Environment.getExternalStorageState();

if(Environment.MEDIA_MOUNTED.equals(state)) {
// Operation possible - Read and Write
isAvailable= true;
isWritable= true;
isReadable= true;
} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
	// Operation possible - Read Only
	isAvailable= true;
	isWritable= false;
	isReadable= true;
} else {
	// SD card not available
	isAvailable = false;
	isWritable= false;
	isReadable= false;
}



getExternalStoragePublicDirectory()


// Request code for creating a PDF document.
private static final int CREATE_FILE = 1;

private void createFile(Uri pickerInitialUri) {
    Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
    intent.addCategory(Intent.CATEGORY_OPENABLE);
    intent.setType("application/pdf");
    intent.putExtra(Intent.EXTRA_TITLE, "invoice.pdf");

    // Optionally, specify a URI for the directory that should be opened in
    // the system file picker when your app creates the document.
    intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, pickerInitialUri);

    startActivityForResult(intent, CREATE_FILE);
}
*/
        ContextWrapper contextWrapper = new ContextWrapper(getApplicationContext());






        File directory = contextWrapper.getDir("profileDir", Context.MODE_PRIVATE);
        File path =new File(directory,"profile.jpg");
        FileOutputStream fileOutputStream=null;
        try {

            fileOutputStream =new FileOutputStream(path);
            bitmap.compress(Bitmap.CompressFormat.PNG,100,fileOutputStream);
        }catch (Exception e)
        {
            e.printStackTrace();

        }
        finally {
            try {
                if(fileOutputStream!=null)
                fileOutputStream.close();
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }


    }
    private void loadProfileLocal()
    {
        try {
            File f = new File(getDir("profileDir",Context.MODE_PRIVATE),"profile.jpg");
            Bitmap bitmap = BitmapFactory.decodeStream(new FileInputStream(f));
            profileImage.setImageBitmap(bitmap);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @SuppressLint("RestrictedApi")
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);




        if(data!=null)
       {
           if(requestCode==OPEN_IMAGES_REQUEST_CODE)
           {
               Uri filePath = data.getData();
               try {

                  /* OneTimeWorkRequest.Builder changeProfileRequest= new OneTimeWorkRequest.Builder(WorkerUpdateProfileLocally.class);

                   *//*Passing Activity's Data To WorkManager's Worker Class*//*


                   Data.Builder dataBuilder = new Data.Builder();
                   dataBuilder.put("filePath",filePath);
                   changeProfileRequest.setInputData(dataBuilder.build());
                   WorkManager.getInstance(getApplicationContext()).enqueue(changeProfileRequest.build());
                    */

                   Source source = createSource(getContentResolver(),filePath);


                   updateRiderProfileInLocalStorage(decodeBitmap(source));
                   Toast.makeText(getApplicationContext(),"Your Profile has Been Changed Locally!!",Toast.LENGTH_LONG).show();

                   loadProfileLocal();

               }catch (Exception e)
               {
                   e.printStackTrace();
               }




           }

           else if(requestCode ==CREATE_FILE   && resultCode == Activity.RESULT_OK) {
               // The result data contains a URI for the document or directory that
               // the user selected.
               Uri uri = null;

               uri = data.getData();
               // Perform operations on the document using its URI.
               {
                   generatePDF(uri);
               }

           }

       }


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        if(item.getItemId()==R.id.nav_logout)
        {
            Toast.makeText(getApplicationContext(),"Logout Clicked",Toast.LENGTH_LONG).show();
        }
        return false;
    }






    private void generatePDF(Uri uri) {
        // creating an object variable
        // for our PDF document.
        PdfDocument pdfDocument = new PdfDocument();

        // two variables for paint "paint" is used
        // for drawing shapes and we will use "title"
        // for adding text in our PDF file.
        Paint paint = new Paint();
        Paint title = new Paint();


    /*    DisplayMetrics displayMetrics = new DisplayMetrics();*/
        ScrollView recyclerViewContent = (ScrollView) findViewById(R.id.scrollViewHome);
        pageHeight= recyclerViewContent.getHeight();
        pagewidth= recyclerViewContent.getWidth();

        // we are adding page info to our PDF file
        // in which we will be passing our pageWidth,
        // pageHeight and number of pages and after that
        // we are calling it to create our PDF.
        PdfDocument.PageInfo mypageInfo = new PdfDocument.PageInfo.Builder(pagewidth, pageHeight, 1).create();

        // below line is used for setting
        // start page for our PDF file.
        PdfDocument.Page myPage = pdfDocument.startPage(mypageInfo);




        // creating a variable for canvas
        // from our page of PDF.
        Canvas canvas = myPage.getCanvas();

        recyclerViewContent.draw(canvas);


      /*  View view= findViewById(R.id.fab);
        view.draw(canvas);*/

        // below line is used to draw our image on our PDF file.
        // the first parameter of our drawbitmap method is
        // our bitmap
        // second parameter is position from left
        // third parameter is position from top and last
        // one is our variable for paint.
        /*canvas.drawBitmap(scaledbmp, 56, 40, paint);*/

        // below line is used for adding typeface for
        // our text which we will be adding in our PDF file.
        title.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));

        // below line is used for setting text size
        // which we will be displaying in our PDF file.
        title.setTextSize(15);

        // below line is sued for setting color
        // of our text inside our PDF file.
        title.setColor(ContextCompat.getColor(this, R.color.purple_200));

        // below line is used to draw text in our PDF file.
        // the first parameter is our text, second parameter
        // is position from start, third parameter is position from top
        // and then we are passing our variable of paint which is title.


        canvas.drawText("*COURTYARD FARMS RIDER REPORT*", 209, 30, title);
        canvas.drawText("Rider ID:"+"06", 209, 80, title);

        // similarly we are creating another text and in this
        // we are aligning this text to center of our PDF file.
        title.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        title.setColor(ContextCompat.getColor(this, R.color.purple_200));
        title.setTextSize(15);

        // below line is used for setting
        // our text to center of PDF.
        title.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("This is sample document which is created by ZWK Android Team.", 396, 560, title);

        // after adding all attributes to our
        // PDF file we will be finishing our page.

        pdfDocument.finishPage(myPage);



        /* Request code for creating a PDF document.*/
        // below line is used to set the name of
        // our PDF file and its path.



       /* createFile();*/


        try {
            ParcelFileDescriptor pfd = getContentResolver().
                    openFileDescriptor(uri, "w");
            FileOutputStream fileOutputStream =
                    new FileOutputStream(pfd.getFileDescriptor());
            Log.d("pfg_gen", "generatePDF: "+fileOutputStream.toString());


            // after creating a file name we will
            // write our PDF file to that location.
            pdfDocument.writeTo(new FileOutputStream(pfd.getFileDescriptor()));

            // below line is to print toast message
            // on completion of PDF generation.
            Toast.makeText(MainActivity.this, "PDF file generated succesfully.", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            // below line is used
            // to handle error
            e.printStackTrace();
        }
        // after storing our pdf to that
        // location we are closing our PDF file.
        pdfDocument.close();
    }




    private void createFile() {

        Date d = Calendar.getInstance().getTime();


        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String date=df.format(d);
        /* File file = new File(getApplicationContext().getDataDir(), "Rider_Report_"+"06"+"_"+date +".pdf");*/
        /*  File file = new File(uri.getPath());*/
        Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/pdf");
        intent.putExtra(Intent.EXTRA_TITLE, "Rider_Report_"+"06"+"_"+date +".pdf");


        // Optionally, specify a URI for the directory that should be opened in
        // the system file picker when your app creates the document.
       /* intent.putExtra(DocumentsContract.EXTRA_INITIAL_URI, pickerInitialUri);*/
        startActivityForResult(intent, CREATE_FILE);
    }


    private boolean checkPermission() {
        // checking of permissions.
        int permission1 = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int permission2 = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        return permission1 == PackageManager.PERMISSION_GRANTED && permission2 == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        // requesting permissions if not provided.
        ActivityCompat.requestPermissions(this, new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0) {

                // after requesting permissions we are showing
                // users a toast message of permission granted.
                boolean writeStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean readStorage = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                if (writeStorage && readStorage) {
                    Toast.makeText(this, "Permission Granted..", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission Denined.", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    }


    private void alterDocument(Uri uri,File file) {
        try {
            ParcelFileDescriptor pfd =getContentResolver().
                    openFileDescriptor(uri, "w");
            FileOutputStream fileOutputStream =
                    new FileOutputStream(pfd.getFileDescriptor());
            fileOutputStream.write(("Overwritten at " + System.currentTimeMillis() +
                    "\n").getBytes());
            // Let the document provider know you're done by closing the stream.
            fileOutputStream.close();
            pfd.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }












   /* @Override
    public void onBackPressed() {
        Object[] l=    getSupportFragmentManager().getFragments().toArray() ;

        Toast.makeText(getApplicationContext(),""+toString()+"",Toast.LENGTH_LONG).show();

    }
*/







}