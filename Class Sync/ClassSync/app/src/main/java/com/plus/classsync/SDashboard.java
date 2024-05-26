package com.plus.classsync;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SDashboard extends AppCompatActivity {
    private static final String TAG = "SDashboard";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sdashboard);

        // Initialize UI components
        LinearLayout quiz = findViewById(R.id.quiz);
        LinearLayout assignment = findViewById(R.id.assignment);
        LinearLayout presentation  = findViewById(R.id.presentation);
        LinearLayout niq = findViewById(R.id.niq);
        TextView sname = findViewById(R.id.sname);

        // Retrieve the student name from the Intent
        Intent i = getIntent();
        String student_Name = i.getStringExtra("SName");

        // Log the received student name
        Log.d(TAG, "Received student name: " + student_Name);

        // Set the student name in the TextView
        if (student_Name != null) {
            sname.setText(student_Name);
        } else {
            Log.e(TAG, "Student name is null!");
        }

        // Set up click listeners for each LinearLayout
        quiz.setOnClickListener(v -> {
            Intent intent = new Intent(SDashboard.this, Quiz.class);
            startActivity(intent);
        });
        assignment.setOnClickListener(v -> {
            Intent intent = new Intent(SDashboard.this, Assignment.class);
            startActivity(intent);
        });
        presentation.setOnClickListener(v -> {
            Intent intent = new Intent(SDashboard.this, Presentation.class);
            startActivity(intent);
        });
        niq.setOnClickListener(v -> {
            Intent intent = new Intent(SDashboard.this, Details.class);
            startActivity(intent);
        });

        // Handle window insets for immersive mode
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
