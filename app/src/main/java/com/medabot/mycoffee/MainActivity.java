package com.medabot.mycoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] aMeja = {"-PILIH MEJA-", "Meja 1", "Meja 2", "Meja 3", "Meja 4", "Meja 5"};

    EditText nama;
    Spinner meja;
    Button lanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = findViewById(R.id.nama);
        meja = findViewById(R.id.meja);
        lanjut = findViewById(R.id.lanjut);

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, aMeja);
        meja.setAdapter(arrayAdapter);

        lanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nama.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Harap Isi Nama Anda", Toast.LENGTH_SHORT).show();
                } else if(meja.getSelectedItemPosition() == 0){
                    Toast.makeText(MainActivity.this, "Pilih Meja Anda", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, PickItemActivity.class);
                    intent.putExtra("nama", nama.getText().toString());
                    intent.putExtra("meja", meja.getSelectedItem().toString());
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        moveTaskToBack(true);
    }
}