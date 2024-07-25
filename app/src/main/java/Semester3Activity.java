package com.example.btechrtu;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Semester3Activity extends AppCompatActivity {

    String[] subjects = {" Advanced Engineering Mathematics", "Technical Communication", "Digital Electronics", "Data Structures and Algorithms", "Object Oriented Programming", "Software Engineering"};
    String[] driveLinks = {
            "https://drive.google.com/drive/folders/1vxMwilGyrLIu_wxpagi5I_axvgHtDvSj?usp=drive_link",
            "https://drive.google.com/drive/folders/1ZHtiTAQmx4MphyG2gJU91yjPCi2imdCm?usp=drive_link",
            "https://drive.google.com/drive/folders/1jGSf3SeT_dcKPeWRUcM_91SP--4OkLBz?usp=drive_link",
            "https://drive.google.com/drive/folders/1QV3fEX33rJIR7lEikcsVIo9wor_8Zywr?usp=drive_link",
            "https://drive.google.com/drive/folders/1XSfpR1_GFK2r2-DtCJCwnNnOADIo9u8G?usp=drive_link",
            "https://drive.google.com/drive/folders/1bhw-yKcAzPTl0FEmJy_r-TYTtsQJlQTW?usp=drive_link"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester3);

        ListView listView = findViewById(R.id.subjects_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, subjects);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> openDriveLink(position));
    }

    private void openDriveLink(int position) {
        String url = driveLinks[position];
        Log.d("Semester3Activity", "Opening URL: " + url);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        try {
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "No application can handle this request. Please install a web browser", Toast.LENGTH_SHORT).show();
            Log.e("Semester1Activity", "Error opening URL", e);
        }
    }
}
