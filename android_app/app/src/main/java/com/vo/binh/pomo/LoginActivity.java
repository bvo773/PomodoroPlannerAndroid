package com.vo.binh.pomo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class LoginActivity extends AppCompatActivity {
    private Button mLogInButton;
    private Button mSignUpButton;
    private ImageView mLogInImageView;

    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize UI components
        mLogInButton = findViewById(R.id.login_button);
        mLogInImageView = findViewById(R.id.log_in_image);
        mSignUpButton = findViewById(R.id.signup_button);

        mEmailView = findViewById(R.id.register_email);
        mPasswordView = findViewById(R.id.register_password);

        // Load image with Glide
        Glide.with(this).load(R.drawable.pomodoro_grow).into(mLogInImageView);

        // Set onClick listeners for buttons
        mLogInButton.setOnClickListener(view -> logIn());
        mSignUpButton.setOnClickListener(view -> signUp());

        // Apply animations
        fadeInAnimation(mLogInImageView);
        slideToRightAnimation(mLogInButton, mSignUpButton);
    }

    private void logIn() {
        // Navigate to MenuActivity
        Intent menuActivity = new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(menuActivity);
    }

    private void signUp() {
        // Navigate to RegisterActivity
        Intent signupActivity = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(signupActivity);
    }

    private void slideToRightAnimation(Button... buttons) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.lefttoright);
        for (Button button : buttons) {
            button.startAnimation(animation);
        }
    }

    private void fadeInAnimation(ImageView imageView) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        imageView.startAnimation(animation);
    }

    public void registerNewUser(View v) {
        // Navigate to RegisterActivity
        Intent intent = new Intent(this, RegisterActivity.class);
        finish();
        startActivity(intent);
    }

    private void attemptLogin() {
        // TODO: Use FirebaseAuth to sign in with email and password
    }

    // TODO: Show error on screen with an alert dialog
}
