package com.example.sh_project;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

// Retrofit API 인터페이스
public interface ApiService {
    @POST("/api/signup")
        // 서버의 회원가입 엔드포인트
    Call<SignUpResponse> signUp(@Body SignUpRequest request);
}
