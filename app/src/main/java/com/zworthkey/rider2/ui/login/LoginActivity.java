package com.zworthkey.rider2.ui.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.zworthkey.rider2.MainActivity;
import com.zworthkey.rider2.R;
import com.zworthkey.rider2.databinding.ActivityLogin2Binding;
import com.zworthkey.rider2.utils.Config;
import com.zworthkey.rider2.utils.RetrofitResponseListener;
import com.zworthkey.rider2.utils.pojoClasses.PojoExample;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivityLogin2Binding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        binding = ActivityLogin2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        loginViewModel = new ViewModelProvider(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        final EditText usernameEditText = binding.username;
        final EditText passwordEditText = binding.password;
        final Button loginButton = binding.login;
        final ProgressBar loadingProgressBar = binding.loading;

        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                /*loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());

                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());

                }*/
                setResult(Activity.RESULT_OK);





                //Complete and destroy login activity once successful


            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString(), new RetrofitResponseListener() {
                                @Override
                                public void onSuccess() {
                                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(intent);
                                }

                                @Override
                                public void onFailure(String message) {
                                    loadingProgressBar.setVisibility(View.GONE);
                                  /*  loadingProgressBar.setVisibility(View.INVISIBLE);*/
                                    Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
                                }

                                @Override
                                public void onSuccessResult(ArrayList<PojoExample> responseData) {

                                }
                            });
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);

                v.setEnabled(false);
                loginViewModel.login(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString(),
                        new RetrofitResponseListener() {
                            @Override
                            public void onSuccess() {
                                loadingProgressBar.setVisibility(View.GONE);
                                Config config = new Config();
                                Log.d("LoginActivity", "onSucess: "+config.getRiderUsername());
                                Intent intent =new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);

                            }

                            @Override
                            public void onFailure(String message) {
                                loadingProgressBar.setVisibility(View.GONE);
                                loginButton.setEnabled(true);
                                    Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();
                            }

                            @Override
                            public void onSuccessResult(ArrayList<PojoExample> responseData) {

                            }
                        });



            }
        });
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!new Config().getRiderUserPassword().equals(""))
        {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
        }
    }


}