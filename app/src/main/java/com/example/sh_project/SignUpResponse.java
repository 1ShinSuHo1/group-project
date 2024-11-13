package com.example.sh_project;

public class SignUpResponse {
    private boolean success;
    private String message;

    public SignUpResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    // Getter와 Setter
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
