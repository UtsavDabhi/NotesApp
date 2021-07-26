package com.example.notesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class createnote extends AppCompatActivity {

//    EditText mtitlenote, mcontentnote;
//    FirebaseAuth firebaseAuth;
//    FirebaseUser firebaseUser;
//    FirebaseFirestore firebaseFirestore;
//    FloatingActionButton floatingActionButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createnote);

        Toast.makeText(this, "You are in new", Toast.LENGTH_SHORT).show();

//
//        mtitlenote=findViewById(R.id.notetitle);
//        mcontentnote=findViewById(R.id.editnote);
//        floatingActionButton=findViewById(R.id.savenote);
//
//
//        Toolbar toolbar=findViewById(R.id.createnote);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        firebaseAuth=FirebaseAuth.getInstance();
//        firebaseFirestore=FirebaseFirestore.getInstance();
//        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
//
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//        String title=mtitlenote.getText().toString().trim();
//        String content=mcontentnote.getText().toString().trim();
//
//        if(title.isEmpty() || content.isEmpty()){
//        Toast.makeText(getApplicationContext(), "Both field are requried", Toast.LENGTH_SHORT).show();
//                }
//        else
//        {
//            DocumentReference documentReference=firebaseFirestore.collection("notes").document(firebaseUser.getUid()).collection("myNotes").document();
//            Map<String,Object> note=new HashMap<>();
//            note.put("title",title);
//            note.put("content",content);
//            documentReference.set(note).addOnSuccessListener(new OnSuccessListener<Void>() {
//                @Override
//                public void onSuccess(Void aVoid) {
//                    Toast.makeText(getApplicationContext(), "Note Created SuccessFully", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(createnote.this,notesactivity.class));
//                }
//            }).addOnFailureListener(new OnFailureListener() {
//                @Override
//                public void onFailure(@NonNull Exception e) {
//                    Toast.makeText(getApplicationContext(), "Failed to created Note", Toast.LENGTH_SHORT).show();
////                    startActivity(new Intent(createnote.this,notesactivity.class));
//                }
//            });
//        }
//            }
//        });
//
//
//
//
//
//
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        if(item.getItemId() == android.R.id.home)
//        {
//            onBackPressed();
//        }
//        return super.onOptionsItemSelected(item);
//    }
    }
}