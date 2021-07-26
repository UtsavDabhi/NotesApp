package com.example.notesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
EditText memail,mpassword;
TextView mlogin,mfpassword,msignin;
FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if(firebaseUser!=null){
         finish();
      startActivity(new Intent(MainActivity.this,notesactivity.class));
                    }
        memail=findViewById(R.id.loginemail);
        mpassword=findViewById(R.id.loginpassword);
        mlogin=findViewById(R.id.userlogin);
        mfpassword=findViewById(R.id.forgotpassword);
        msignin=findViewById(R.id.usersignin);

        mfpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,forgotpassword.class));
            }
        });

        msignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,signup.class));
            }
        });

        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=memail.getText().toString().trim();
                String spassword=mpassword.getText().toString().trim();
                if(email.isEmpty() && spassword.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Enter Valied Email & Password", Toast.LENGTH_SHORT).show();
                }
                else {
                firebaseAuth.signInWithEmailAndPassword(email,spassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                          checkmailverification();
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Account Don't Exist.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    private void checkmailverification() {
                        FirebaseUser firebaseUser1=firebaseAuth.getCurrentUser();
                        if(firebaseUser.isEmailVerified()){
                            Toast.makeText(MainActivity.this, "Login-In", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(MainActivity.this,notesactivity.class));
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "Verify Your Mail First.", Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        }
                    }
                });
                }
            }
        });
    }
}