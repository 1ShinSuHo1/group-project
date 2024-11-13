package com.example.sh_project;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    // POST 요청을 통해 서버로 회원가입 요청
    @POST("/user/register")
    Call<SignUpResponse> signUp(@Body SignUpRequest request);

    // POST 요청을 통해 서버로 로그인 요청
    // 로그인 요청 (POST 요청)
    @POST("/user/login")
    Call<LoginResponse> login(@Body LoginRequest request);  // 응답을 LoginResponse 객체로 받음
}
