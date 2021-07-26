package com.example.notesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotpassword extends AppCompatActivity {
EditText editText;
Button button;
TextView textView;
FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        getSupportActionBar().hide();

        firebaseAuth=FirebaseAuth.getInstance();

    editText=findViewById(R.id.resetpasword);
    button=findViewById(R.id.recoverbutton);
    textView=findViewById(R.id.gobacklogin);

    textView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(forgotpassword.this,MainActivity.class));
        }
    });

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String email=editText.getText().toString().trim();

            if(email.isEmpty()){
                Toast.makeText(forgotpassword.this, "Please enter vailed Email", Toast.LENGTH_SHORT).show();
    }
            else
            {
                firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(forgotpassword.this, "Mail Sent,You Can recover your Password.", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(new Intent(forgotpassword.this,MainActivity.class));
                        }
                        else
                        {
                            Toast.makeText(forgotpassword.this, "Email is wrong or Account not exist", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }






        }
    });
    }
}