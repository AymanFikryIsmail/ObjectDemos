package com.example.socialdemo.listeners;

import retrofit2.Response;

public interface OnResponseListener<T> {
    void onSuccess(Response response);
    void onCustomSuccess(T data);

    void onFailure();

    void onAuthError();

    void onInvalidTokenError();

    void onServerError();

    void onValidationError(String errorMessage);

    void onSuspendedUserError(String errorMessage);
}
