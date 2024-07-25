package com.example.btechrtu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Semester1Activity extends AppCompatActivity {

    String[] subjects = {"Basic Civil Engineering","Human value","Engineering Mathematics I","Basic Mechanical Engineering","Engineering Chemistry"};
    String[] driveLinks = {
            "https://drive.google.com/drive/folders/1RKMqtOS44t39olcVIIZKuUQAKeJYx2aD?usp=drive_link",
            "https://drive.google.com/drive/folders/1yzJGU_dm4QgWVDKWYYgc57QbIr2ocTMG?usp=drive_link",
            "https://drive.google.com/drive/folders/1YOatzs2p3BS3cvFisKMnrhw2odTuGlb9?usp=drive_link",
            "https://drive.google.com/drive/folders/1GhJjUjSN2PhaGnBzUW5ZUyrpKNVQgpqn?usp=drive_link",
            "https://drive.google.com/drive/folders/1-H65SXOAQtxK9Q6iEcmfvNbuAA9mCrqc?usp=drive_link"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester1);

        ListView listView = findViewById(R.id.subjects_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, subjects);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> openDriveLink(position));
    }

    private void openDriveLink(int position) {
        String url = driveLinks[position];
        Log.d("Semester1Activity", "Opening URL: " + url);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        try {
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "No application can handle this request. Please install a web browser", Toast.LENGTH_SHORT).show();
            Log.e("Semester1Activity", "Error opening URL", e);
        }
    }
}
