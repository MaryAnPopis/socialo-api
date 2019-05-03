package com.socialo.exception;

public class ErrorResponse {
    private String message;
    private boolean isValid;

    public ErrorResponse() {
    }

    public ErrorResponse(String message, boolean isValid) {
        this.message = message;
        this.isValid = isValid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }
}
