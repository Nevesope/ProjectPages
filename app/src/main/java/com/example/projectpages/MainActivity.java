package com.example.projectpages;

import androidx.appcompat.app.AppCompatActivity;
import com.example.projectpages.DatabaseManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txtUsername;
    EditText txtPassword;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername = findViewById(R.id.editTextEmailAddress);
        txtPassword = findViewById(R.id.editTextPassword);
        btn = (Button)findViewById(R.id.button1);
        getSupportActionBar().setTitle("Neve Sopeland Event Page");


        btn.setOnClickListener(listener -> handleLogin());
    }

    private void handleLogin(){
        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();

        if (DatabaseManager.getInstance(getApplicationContext()).authenticate(username, password)){
            Intent intent = new Intent(this, datascreen.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "invalid credentials", Toast.LENGTH_LONG).show();
        }
    }
}