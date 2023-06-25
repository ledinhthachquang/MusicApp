package com.example.appnhac.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingUtil;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.appnhac.Model.APIResponse;
import com.example.appnhac.R;
import com.example.appnhac.Service.APIService;
import com.example.appnhac.Service.Dataservice;
import com.example.appnhac.databinding.ActivityLoginBinding;
import com.google.android.material.snackbar.Snackbar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button buttontoreg,buttonLogin;

    EditText txtusername, txtpassword;

    LinearLayout showProgress;

    CoordinatorLayout myCoordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        anhxa();
        initialize();
    }

    private void initialize() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Dang nhap");
        buttontoreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performLogin();
                showProgress.setVisibility(View.VISIBLE);
            }


        });
    }
    private void performLogin() {
        String username = txtusername.getText().toString();
        String password = txtpassword.getText().toString();
        Dataservice dataservice = APIService.getService();
        Call<APIResponse> call = dataservice.performSignIn(username,password);
        call.enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                if(response.code()==200){
                    if(response.body().getStatus().equals("ok")){
                        if(response.body().getResultCode()==1){
                           String name = response.body().getUsername();
                           Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                           intent.putExtra("name",name);
                           startActivity(intent);
                           finish();
                        }else {
                            displayUserInfo("Đăng nhập thất bại");
                        }
                    }else{
                        displayUserInfo("Có lỗi vui lòng thử lại");
                    }
                }else{
                    displayUserInfo("Có lỗi vui lòng thử lại");
                }
            }

            @Override
            public void onFailure(Call<APIResponse> call, Throwable t) {

            }
        });
    }
    private void displayUserInfo(String message) {
        Snackbar.make(myCoordinatorLayout,message,Snackbar.LENGTH_SHORT).show();
        txtpassword.setText("");
        showProgress.setVisibility(View.INVISIBLE);
    }
    private void anhxa() {
        toolbar = findViewById(R.id.logintoolbar);
        buttontoreg = findViewById(R.id.buttonLogintoRegister);
        buttonLogin = findViewById(R.id.buttonLogin);
        showProgress= findViewById(R.id.show_progress);
        txtusername = findViewById(R.id.loginUsername);
        txtpassword = findViewById(R.id.loginPassword);
        myCoordinatorLayout = findViewById(R.id.loginCoordinator);
    }
}