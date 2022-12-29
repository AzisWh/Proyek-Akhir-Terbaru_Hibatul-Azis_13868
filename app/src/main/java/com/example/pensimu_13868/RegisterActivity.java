package com.example.pensimu_13868;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText inputEmail, pass1, pass2;
    String password1, password2, email;
    Button btnRegist;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mAuth = FirebaseAuth.getInstance();

        inputEmail = findViewById(R.id.Remail);
        pass1 = findViewById(R.id.Rpass1);
        pass2 = findViewById(R.id.Rpass2);
        btnRegist = findViewById((R.id.Rlogin));
        btnRegist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cekRegist();
            }
        });
    }

    private void cekRegist() {

        email = inputEmail.getText().toString();
        password1 = pass1.getText().toString();
        password2 = pass2.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password2)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Toast.makeText(RegisterActivity.this,
                                    "Registrasi Berhasil",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(RegisterActivity.this,
                                    "Registrasi Gagal",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}