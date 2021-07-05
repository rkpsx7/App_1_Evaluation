package com.example.app_1_evaluation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class SignInActivity extends AppCompatActivity {

    private EditText mEtUserName,mEtPassword;
    private Button mBtnSign2;
    private TextView finalSignUp;
    private ImageButton mBackButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mEtUserName = findViewById(R.id.tvUserName);
        mEtPassword = findViewById(R.id.signInPassword);
        mBtnSign2 = findViewById(R.id.btnSignIn2);
        mBackButton = findViewById(R.id.SignInBack);
        finalSignUp = findViewById(R.id.tvFinalSignUp);


        finalSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        mBtnSign2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nameValidation() && passwordValidation()){
                    Intent intent2 = new Intent(SignInActivity.this,HomeActivity.class);
                    intent2.putExtra("name",""+mEtUserName.getText().toString());
                    startActivity(intent2);
                }
            }
        });
    }
    private boolean nameValidation() {
        if(mEtUserName.getText().toString().length()>=4)
            return true;
        else
            mEtUserName.setError("Name length should be minimum 4 characters");
        return false;
    }

    private boolean passwordValidation() {
        if(mEtPassword.getText().toString().trim().length()>=6)
            return true;
        else
            mEtPassword.setError("Password is weak");
        return false;
    }
}