package com.example.btechrtu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Semester6Activity extends AppCompatActivity {

    String[] subjects = {"Digital Image Processing", "Machine Learning","Information Security System","Computer Architecture And Organization","Artificial intelligence","Cloud Computing","Distributed system"};
    String[] driveLinks = {
            "https://drive.google.com/drive/folders/12nFWHs4FmbfVopOK5uZgxjNtcyMXTSLk?usp=drive_link",
            "https://drive.google.com/drive/folders/1tEHymPV_sAywELXwsIOpPs67Relwco9q?usp=drive_link",
            "https://drive.google.com/file/d/1zByo57-RMEa5FdVD2Ntnu8ktskJnlWIM/view?usp=drive_link",
            "https://drive.google.com/drive/folders/1vbjIpWNe_SoKPB3zDTe1ZTbnCze9o11U?usp=drive_link",
            "https://drive.google.com/drive/folders/19Rb72HVM8m9RibekUwyu9Yku5EWti5Jq?usp=drive_link",
            "https://drive.google.com/drive/folders/1VzyHkUrdlE-YcYxYzS5yw2Ps-m8J3pkn?usp=drive_link",
            "https://drive.google.com/drive/folders/16-Glx1eXJwd9mK0uz0ctmziNLfiNzjpq?usp=drive_link"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester6);

        ListView listView = findViewById(R.id.subjects_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, subjects);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> openDriveLink(position));
    }

    private void openDriveLink(int position) {
        String url = driveLinks[position];
        Log.d("Semester6Activity", "Opening URL: " + url);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        try {
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "No application can handle this request. Please install a web browser", Toast.LENGTH_SHORT).show();
            Log.e("Semester1Activity", "Error opening URL", e);
        }
    }
}
