package com.zworthkey.rider2.ui.login;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zworthkey.rider2.utils.Config;

public class LogOut extends AppCompatActivity {

    //TODO logout Implementation here
    public LogOut()
    {
        Config config=new Config();

       config.setRiderUserPassword(null);
       config.setRiderUsername(null);

       /* Intent intent =new Intent(this,LoginActivity.class);
       this. startActivity(intent);*/
    }

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        startActivity(intent);
    }
}
