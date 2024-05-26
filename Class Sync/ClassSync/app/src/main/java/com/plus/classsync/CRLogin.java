package com.plus.classsync;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CRLogin extends AppCompatActivity {
    Button si, create;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crlogin);
        si = findViewById(R.id.crsignup);
        create = findViewById(R.id.createSection);
        si.setOnClickListener(v -> {
            Intent intent = new Intent(CRLogin.this,SDashboard.class);
            startActivity(intent);
        });
        create.setOnClickListener(v -> {
            Intent intent = new Intent(CRLogin.this, CreateSection.class);
            startActivity(intent);
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}