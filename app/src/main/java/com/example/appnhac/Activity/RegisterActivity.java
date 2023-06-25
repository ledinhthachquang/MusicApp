package com.example.appnhac.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.appnhac.Model.APIResponse;
import com.example.appnhac.R;
import com.example.appnhac.Service.APIService;
import com.example.appnhac.Service.Dataservice;
import com.google.android.material.snackbar.Snackbar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    Toolbar toolbar;
    Button button;
    LinearLayout showProgress;

    CoordinatorLayout myCoordinatorLayout;
    public boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }


    EditText txtemail, txtusername, txtpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        anhxa();
        initialize();

    }

    private void initialize() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Dang ky");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performSignup();
                showProgress.setVisibility(View.VISIBLE);
            }
        });
    }

    private void performSignup() {
        String username = txtusername.getText().toString();
        String password = txtpassword.getText().toString();
        String email = txtemail.getText().toString();
        if (isValidPassword(password)){
            Dataservice dataservice = APIService.getService();
            Call<APIResponse> call = dataservice.performSignUp(username,password,email);
            call.enqueue(new Callback<APIResponse>() {
                @Override
                public void onResponse(Call<APIResponse> call, Response<APIResponse> response) {
                    if(response.code()==200){
                        if(response.body().getStatus().equals("ok")){
                            if(response.body().getResultCode()==1){
                                Toast.makeText(RegisterActivity.this,"Tạo tài khoàn thành công, giờ bạn có thể đăng nhập",Toast.LENGTH_LONG).show();
                                onBackPressed();
                                finish();
                            }else {
                                displayUserInfo("Người dùng đã tồn tại");
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
        } else {
            displayUserInfo("Password phải có ít nhất 8 ký tự, 1 ký tự đặc biệt và 1 chữ cái viết hoa ");

        }

    }

    private void anhxa() {
        toolbar = findViewById(R.id.registertoolbar);
        button = findViewById(R.id.buttonRegister);
        showProgress = findViewById(R.id.show_progress);
        txtemail = findViewById(R.id.registerEmail);
        txtpassword = findViewById(R.id.registerPassword);
        txtusername = findViewById(R.id.registerUsername);
        myCoordinatorLayout = findViewById(R.id.registerCoordinator);
    }

    private void displayUserInfo(String message) {
        Snackbar.make(myCoordinatorLayout,message,Snackbar.LENGTH_SHORT).show();
        txtpassword.setText("");
        showProgress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}