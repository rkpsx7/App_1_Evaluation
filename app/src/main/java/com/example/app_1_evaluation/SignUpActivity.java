package com.example.app_1_evaluation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class SignUpActivity extends AppCompatActivity {

    private EditText mEtSignUpName,mEtSignUpEmail,mEtPassword;
    private Button mBtnSignUp;
    private TextView finalSignIn;
    private ImageButton mBackButton2;
    String validation = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mEtSignUpName = findViewById(R.id.etSignUpName);
        mEtSignUpEmail = findViewById(R.id.etSignUpEmail);
        mEtPassword = findViewById(R.id.etSignUpPassword);
        mBtnSignUp = findViewById(R.id.btnSignUP2);
        mBackButton2 = findViewById(R.id.SignUpBack);
        finalSignIn = findViewById(R.id.tvFinalSignIn);
        finalSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,SignInActivity.class);
                startActivity(intent);
            }
        });

        mBackButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this,MainActivity.class);
                startActivity(intent);
            }
    });
        mBtnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nameValidation() &&emailValidation() && passwordValidation()){
                    Intent intent = new Intent(SignUpActivity.this,HomeActivity.class);
                    intent.putExtra("name",""+mEtSignUpName.getText().toString());
                    startActivity(intent);
                }
            }
        });


    }

    private boolean nameValidation() {
        if(mEtSignUpName.getText().toString().length()>=4)
            return true;
        else
            mEtSignUpName.setError("Name length should be minimum 4 characters");
        return false;
    }

    private boolean passwordValidation() {
        if(mEtPassword.getText().toString().trim().length()>=6)
            return true;
        else
            mEtPassword.setError("Password is weak");
        return false;
    }

    private boolean emailValidation() {
        if(mEtSignUpEmail.getText().toString().trim().matches(validation))
            return true;
        else
            mEtSignUpEmail.setError("Invalid Email");
        return false;
    }
}