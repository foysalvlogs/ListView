package com.listview.bynffoysal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    SearchView SearchView;

    String[]  tutorial = {" Typing Master Pro", "Maxon CINEMA 4D", "APK Easy Tool",
            "Rom Porter ", "Multiple Zip", "Google Adsense ", "Remove Voice ",
            " kali Linux", "Adobe XD", "Stock Rom", "Safe Mode", "Miracle Box",
    "Wondershare Filmora", "Magisk Manager Install", "Kali NetHunter ", "Data Decryption", "Offcial Firmware",
            "Android Unroot ", "Audio Spectrum " };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView =  findViewById(R.id.list);
        SearchView = findViewById(R.id.SearchView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this , android.R.layout.simple_dropdown_item_1line , tutorial);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long ld) {

                Toast.makeText(MainActivity.this, "Clicked" + tutorial[position] , Toast.LENGTH_SHORT).show();

            }
        });

        SearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                adapter.getFilter().filter(newText);

                return false;
            }
        });

    }
}