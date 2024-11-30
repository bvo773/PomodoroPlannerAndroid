package com.vo.binh.pomo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    // UI references
    private ImageView mImageView;
    private AutoCompleteTextView mUserNameView;
    private AutoCompleteTextView mEmailView;
    private EditText mPassWordView;
    private EditText mComfirmPasswordView;
    private Button mSignUpButtonView;
    FirebaseAuth.AuthStateListener mAuthStateListener;

    // Firebase reference variable
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Linking UI references to resources
        mUserNameView = findViewById(R.id.register_username);
        mEmailView = findViewById(R.id.register_email);
        mPassWordView = findViewById(R.id.register_password);
        mComfirmPasswordView = findViewById(R.id.register_confirm_password);
        mSignUpButtonView = findViewById(R.id.register_btn);

        // Get an instance of FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        mComfirmPasswordView.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL) {
                attemptRegistration();
                return true;
            }
            return false;
        });

        mAuthStateListener = firebaseAuth -> {
            if (firebaseAuth.getCurrentUser() != null) {
                Intent intent = new Intent(RegisterActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        };
        mAuth.addAuthStateListener(mAuthStateListener);

        mSignUpButtonView.setOnClickListener(v -> attemptRegistration());

        mImageView = findViewById(R.id.sign_up_image);
        Glide.with(this).load(R.drawable.pomodoro_run).into(mImageView);
    }

    private void attemptRegistration() {
        mEmailView.setError(null);
        mPassWordView.setError(null);

        String email = mEmailView.getText().toString();
        String password = mPassWordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for valid password if the user entered one
        if (TextUtils.isEmpty(password) || !isPasswordValid(password)) {
            mPassWordView.setError("Password is too short or does not match");
            focusView = mPassWordView;
            cancel = true;
        }

        // Check if email is valid
        if (TextUtils.isEmpty(email) || !isEmailValid(email)) {
            mEmailView.setError("Requires a valid email address");
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            createFirebaseUser();
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@"); // Simplified email validation
    }

    private boolean isPasswordValid(String password) {
        String confirmPassword = mComfirmPasswordView.getText().toString();
        return confirmPassword.equals(password) && password.length() > 4;
    }

    private void createFirebaseUser() {
        String email = mEmailView.getText().toString();
        String password = mPassWordView.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, task -> {
            Log.d("CreatingUser", "createUser onComplete:" + task.isSuccessful());

            if (!task.isSuccessful()) {
                Log.d("CreatingUser", "createUser failed: " + task.getException());
                showErrorDialog("Registration attempt failed. Please try again.");
            }
        });
    }

    private void showErrorDialog(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Error")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
