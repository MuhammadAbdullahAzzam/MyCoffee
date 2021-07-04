package com.medabot.mycoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PickItemActivity extends AppCompatActivity {

    Button pesan;
    EditText jumlah1, jumlah2, jumlah3, jumlah4, jumlah5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_item);

        jumlah1 = findViewById(R.id.jumlah1);
        jumlah2 = findViewById(R.id.jumlah2);
        jumlah3 = findViewById(R.id.jumlah3);
        jumlah4 = findViewById(R.id.jumlah4);
        jumlah5 = findViewById(R.id.jumlah5);
        pesan = findViewById(R.id.pesan);

        pesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PickItemActivity.this, PaymentActivity.class);
                intent.putExtra("jumlah1", jumlah1.getText().toString());
                intent.putExtra("jumlah2", jumlah2.getText().toString());
                intent.putExtra("jumlah3", jumlah3.getText().toString());
                intent.putExtra("jumlah4", jumlah4.getText().toString());
                intent.putExtra("jumlah5", jumlah5.getText().toString());
                intent.putExtra("nama", getIntent().getExtras().getString("nama"));
                intent.putExtra("meja", getIntent().getExtras().getString("meja"));
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(PickItemActivity.this, MainActivity.class));
        super.onBackPressed();
    }
}