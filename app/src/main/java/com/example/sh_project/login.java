package com.example.sh_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton; // 수정된 부분
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class login extends AppCompatActivity {
    private TextView signUpText;
    private AppCompatButton loginButton; // 로그인 버튼 추가

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // 회원가입 텍스트뷰를 찾고
        signUpText = findViewById(R.id.signUpText);
        // 로그인 버튼을 찾기
        loginButton = findViewById(R.id.loginButton); // 로그인 버튼 ID 추가

        // 회원가입 버튼 클릭 시 sign_up 액티비티로 이동
        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, sign_up.class);
                startActivity(intent);
            }
        });

        // 로그인 버튼 클릭 시 function 액티비티로 이동
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, function.class);
                startActivity(intent);
            }
        });
    }
}
