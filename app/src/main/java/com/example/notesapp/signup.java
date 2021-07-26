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

public class signup extends AppCompatActivity {

    EditText signemail,signpassword;
    TextView signup,gotologin;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().hide();

        signemail=findViewById(R.id.signupemail);
        signpassword=findViewById(R.id.signuppassword);
        signup=findViewById(R.id.usersignup);
        gotologin=findViewById(R.id.signuplogin);

        firebaseAuth=FirebaseAuth.getInstance();

        gotologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signup.this,MainActivity.class));
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String email=signemail.getText().toString().trim();
        String spassword=signpassword.getText().toString().trim();
    if(email.isEmpty() && spassword.isEmpty()){
    Toast.makeText(signup.this, "Please Enter Valied Email & Password", Toast.LENGTH_SHORT).show();
}
    else if(spassword.length()<7){
        Toast.makeText(signup.this, "Password Should be <= 7.", Toast.LENGTH_SHORT).show();
    }
    else {
        firebaseAuth.createUserWithEmailAndPassword(email,spassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(signup.this, "Sign-up SuccessFully!!", Toast.LENGTH_SHORT).show();
                sendemailverification();
                }
                else
                {
                    Toast.makeText(signup.this, "Sign-up Failed..", Toast.LENGTH_SHORT).show();
                }

            }

            private void sendemailverification() {
                FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
                if(firebaseUser!=null){
                    firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(signup.this, "Verification mail is send,Verify and Login Again!", Toast.LENGTH_SHORT).show();
                        firebaseAuth.signOut();
                        finish();
                        startActivity(new Intent(signup.this,MainActivity.class));
                        }
                    });
                }
                else
                {
                    Toast.makeText(signup.this, "Failed to send Verification mail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    }
});
    }
}