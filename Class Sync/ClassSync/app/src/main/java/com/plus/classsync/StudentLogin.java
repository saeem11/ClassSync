package com.plus.classsync;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StudentLogin extends AppCompatActivity {
    Button studentLogin;
    EditText studentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_student_login);

        studentLogin = findViewById(R.id.studentLogin);
        studentName = findViewById(R.id.stdent_name);

        studentLogin.setOnClickListener(v -> {
            String sn = studentName.getText().toString().trim();
            if (!sn.isEmpty()) {
                Intent intent = new Intent(StudentLogin.this, SDashboard.class);
                intent.putExtra("SName", sn);
                startActivity(intent);
            } else {
                 Toast.makeText(StudentLogin.this, "Please enter your name", Toast.LENGTH_SHORT).show();

            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
