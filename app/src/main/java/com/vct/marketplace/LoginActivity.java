package com.vct.marketplace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void loginClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        EditText userName = findViewById(R.id.nameLogin);
        EditText userEmail = findViewById(R.id.emailLogin);
        intent.putExtra("userName",userName.getText().toString());
        intent.putExtra("userEmail",userEmail.getText().toString());
        startActivity(intent);
    }
}
