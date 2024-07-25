package com.example.btechrtu;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Semester2Activity extends AppCompatActivity {

    String[] subjects = {"Engineering Physics", "Communication Skills ", "Programming for Problem Solving", "Basic Electrical Engineering ", " Engineering Mathematics-II"};
    String[] driveLinks = {
            "https://drive.google.com/drive/folders/18wRWObw0iar5TJGRlt16OEZS6T8wtSsl?usp=drive_link",
            "https://drive.google.com/drive/folders/1qVcSIbJCauPTJ_433Jwk5N7zpJLsVqFW?usp=drive_link",
            "https://drive.google.com/drive/folders/11BwBHN4rj1xptk3O80s20_SUI-0_DK9k?usp=drive_link",
            "https://drive.google.com/drive/folders/13v3z-V_OgJ4TLKCqLSSHeenNgTSR1tJE?usp=drive_link",
            "https://drive.google.com/drive/folders/1PGbQ4mW74HQ02g7Kfvz_FyWIhcYigQEL?usp=drive_link"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester2);

        ListView listView = findViewById(R.id.subjects_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, subjects);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> openDriveLink(position));
    }

    private void openDriveLink(int position) {
        String url = driveLinks[position];
        Log.d("Semester2Activity", "Opening URL: " + url);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        try {
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "No application can handle this request. Please install a web browser", Toast.LENGTH_SHORT).show();
            Log.e("Semester1Activity", "Error opening URL", e);
        }
    }
}
