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

public class Semester5Activity extends AppCompatActivity {

    String[] subjects = {"information theory &coding  ", "Compiler Design", "Operating System", "Computer Graphics & Multimedia", "Analysis of Algorithms", "wireless communication "};
    String[] driveLinks = {
            "https://drive.google.com/drive/folders/1fXPtiiAYx0aosJlO2CBn7s9cXeI--PIM?usp=sharing",
            "https://drive.google.com/drive/folders/1Nq7Eh3TleJY0pThH5rAQ3fSAxmFDwbc-?usp=sharing",
            "https://drive.google.com/drive/folders/1HLxWDD18dngmGllX0m4Dmaq0J1K-8e2B?usp=drive_link",
            "https://drive.google.com/drive/folders/12dD4jH-ZMdKe_U_JTK4bC0lKyIF6HViQ?usp=sharing",
            "https://drive.google.com/drive/folders/1bdn7s0-Kl26eYt0M4L-8diFGsf4KTBJa?usp=drive_link",
            "https://drive.google.com/drive/folders/155eiqQn5U5H4riAUFX8c2b6z3RVbUlgb?usp=drive_link"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_semester5);

        ListView listView = findViewById(R.id.subjects_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, subjects);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> openDriveLink(position));
    }

    private void openDriveLink(int position) {
        String url = driveLinks[position];
        Log.d("Semester5Activity", "Opening URL: " + url);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

        try {
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "No application can handle this request. Please install a web browser", Toast.LENGTH_SHORT).show();
            Log.e("Semester1Activity", "Error opening URL", e);
        }
    }
}
