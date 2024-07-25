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

public class Semester4Activity extends AppCompatActivity {

    String[] subjects = {"Discrete Mathematics Structure", "Managerial Economics Financial Accounting", "Microprocessor & Interfaces", "Data Communication and Computer Networks", "Database Management System","Theory of computation"};
    String[] driveLinks = {
            "https://drive.google.com/drive/folders/16xmG5EORoL5tsg1xADMe_CAUNL4NwlkP?usp=drive_link",
            "https://drive.google.com/drive/folders/1TrWjdGV36Ue-oOyVQiCrUl4w6rz3t52W?usp=drive_link",
            "https://drive.google.com/drive/folders/1EPi1LDouNpgaFNT8uDA9Fkxwlhh3x9pB?usp=drive_link",
            "https://drive.google.com/drive/folders/1qmoEJbSTdXiut-1yDRs8p1mac-WtovQN?usp=drive_link",
            "https://drive.google.com/drive/folders/17IYDYxridyIuy01DbkB-NAjYYE1F77LK?usp=drive_link",
            "https://drive.google.com/drive/folders/1IptE8jUZBkTQ5THO0P7A5Hk5EIIUP6dV?usp=drive_link"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester4);

        ListView listView = findViewById(R.id.subjects_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, subjects);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> openDriveLink(position));
    }

    private void openDriveLink(int position) {
        String url = driveLinks[position];
        Log.d("Semester4Activity", "Opening URL: " + url);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        try {
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "No application can handle this request. Please install a web browser", Toast.LENGTH_SHORT).show();
            Log.e("Semester1Activity", "Error opening URL", e);
        }
    }
}
