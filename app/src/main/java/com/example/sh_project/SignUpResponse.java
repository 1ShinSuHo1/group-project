package com.example.sh_project;

// 응답 데이터를 받을 클래스
public class SignUpResponse {
    private boolean success;
    private String message;

    public SignUpResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    // Getters and Setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

