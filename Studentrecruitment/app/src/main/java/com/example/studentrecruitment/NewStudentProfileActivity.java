package com.example.studentrecruitment;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class NewStudentProfileActivity extends AppCompatActivity {


    private TextView tvUploadCv;
    private Button btnFinishProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graduate_profile);

        tvUploadCv = findViewById(R.id.tvUploadCv);
        btnFinishProfile = findViewById(R.id.btnFinishProfile);

        tvUploadCv.setOnClickListener(v -> {
            // Launch file picker
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("application/pdf");
            startActivityForResult(intent, 101);  // Add permission handling as needed
        });

        btnFinishProfile.setOnClickListener(v -> {
            // Validate & Save logic here
            Toast.makeText(this, "Profile completed!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, DashboardActivity.class));
            finish();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK && data != null) {
            Uri uri = data.getData();
            tvUploadCv.setText("CV Uploaded");
        }
    }
}
