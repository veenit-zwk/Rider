package com.zworthkey.rider2.utils.backgroundTasks;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.graphics.ImageDecoder.createSource;
import static android.graphics.ImageDecoder.decodeBitmap;
import static androidx.work.ListenableWorker.Result.success;

public class WorkerUpdateProfileLocally extends Worker {

    Context context;
    public WorkerUpdateProfileLocally(@NonNull @NotNull Context context, @NonNull @NotNull WorkerParameters workerParams) {
        super(context, workerParams);
       this. context= context;
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    @NonNull
    @NotNull
    @Override
    public Result doWork() {
        Log.d("UpdateProfile", "doWork: ");
        String uri =getInputData().getString("filePath");
        ImageDecoder.Source source = createSource(getApplicationContext().getContentResolver(), Uri.parse(uri));
        try {
      return  updateRiderProfileInLocalStorage(decodeBitmap(source));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }

    private Result updateRiderProfileInLocalStorage(Bitmap bitmap) {
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
           return null;

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
        return success();
    }
}
