package com.example.sh_project;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class sign_up extends AppCompatActivity {

    private EditText idField, passwordField, passwordConfirmField, serialNumberField;
    private Button signUpButton;
    private ApiService apiService;  // Retrofit 인터페이스

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // UI 요소 찾기
        idField = findViewById(R.id.id);
        passwordField = findViewById(R.id.password);
        passwordConfirmField = findViewById(R.id.passwordConfirm);
        serialNumberField = findViewById(R.id.serialNumber);
        signUpButton = findViewById(R.id.signUpButton);

        // Retrofit 설정
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://3.37.225.63:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build())
                .build();


        apiService = retrofit.create(ApiService.class);  // ApiService 객체 생성

        // 회원가입 버튼 클릭 리스너
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = idField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();
                String passwordConfirm = passwordConfirmField.getText().toString().trim();
                String serialNumber = serialNumberField.getText().toString().trim();

                // 입력 값 오류 검사
                if (id.isEmpty() || password.isEmpty() || serialNumber.isEmpty()) {
                    Toast.makeText(sign_up.this, "모든 칸을 입력해주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(passwordConfirm)) {
                    Toast.makeText(sign_up.this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 서버로 전송할 회원가입 요청 객체 생성
                SignUpRequest request = new SignUpRequest(id, password, serialNumber);

                // 서버에 회원가입 요청
                Call<SignUpResponse> call = apiService.signUp(request);
                call.enqueue(new Callback<SignUpResponse>() {
                    @Override
                    public void onResponse(Call<SignUpResponse> call, Response<SignUpResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            Toast.makeText(sign_up.this, "회원가입 성공!", Toast.LENGTH_SHORT).show();
                            // 로그인 화면으로 이동
                            Intent intent = new Intent(sign_up.this, login.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(sign_up.this, "회원가입 실패", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<SignUpResponse> call, Throwable t) {
                        Toast.makeText(sign_up.this, "서버 연결 실패", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
