package com.medabot.mycoffee;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentActivity extends AppCompatActivity {

    //Deklarasi Elemen
    Button bayar;
    View garis1, garis2, garis3, garis4;
    TableRow item1, item2, item3, item4, item5;
    TextView quantity1, quantity2, quantity3, quantity4, quantity5,
            total, total1, total2, total3, total4, total5, pemesan;
    String jumlah1, jumlah2, jumlah3, jumlah4, jumlah5, nama, meja;
    int hasil1 = 0, hasil2 = 0, hasil3 = 0, hasil4 = 0, hasil5 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        //untuk ambil item meja nama
        nama = getIntent().getExtras().getString("nama");
        meja = getIntent().getExtras().getString("meja");
        jumlah1 = getIntent().getExtras().getString("jumlah1");
        jumlah2 = getIntent().getExtras().getString("jumlah2");
        jumlah3 = getIntent().getExtras().getString("jumlah3");
        jumlah4 = getIntent().getExtras().getString("jumlah4");
        jumlah5 = getIntent().getExtras().getString("jumlah5");

        //untuk cari id di layout
        pemesan = findViewById(R.id.pemesan);
        bayar = findViewById(R.id.bayar);

        garis1 = findViewById(R.id.garis1);
        garis2 = findViewById(R.id.garis2);
        garis3 = findViewById(R.id.garis3);
        garis4 = findViewById(R.id.garis4);

        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);
        item3 = findViewById(R.id.item3);
        item4 = findViewById(R.id.item4);
        item5 = findViewById(R.id.item5);

        quantity1 = findViewById(R.id.quantity1);
        quantity2 = findViewById(R.id.quantity2);
        quantity3 = findViewById(R.id.quantity3);
        quantity4 = findViewById(R.id.quantity4);
        quantity5 = findViewById(R.id.quantity5);

        total = findViewById(R.id.total);
        total1 = findViewById(R.id.total1);
        total2 = findViewById(R.id.total2);
        total3 = findViewById(R.id.total3);
        total4 = findViewById(R.id.total4);
        total5 = findViewById(R.id.total5);

        //untuk set tulisan pemesan di atas
        pemesan.setText("An. " + nama.toUpperCase() + " - " + meja);

        //untuk jumlah item 0 maka garis dan nama item kosong dan ditampilkan dan kalkulasi
        if (jumlah1.equals("") || jumlah1.equals("0")) {
            garis1.setVisibility(View.GONE);
            item1.setVisibility(View.GONE);
        } else {
            quantity1.setText("Rp. 18.000 x @" + jumlah1);
            total1.setText("Rp. " + Integer.parseInt(jumlah1) * 18000);
            hasil1 = Integer.parseInt(jumlah1) * 18000;
        }

        if (jumlah2.equals("") || jumlah2.equals("0")) {
            garis2.setVisibility(View.GONE);
            item2.setVisibility(View.GONE);
        } else {
            quantity2.setText("Rp. 15.000 x @" + jumlah2);
            total2.setText("Rp. " + Integer.parseInt(jumlah2) * 15000);
            hasil2 = Integer.parseInt(jumlah2) * 15000;
        }

        if (jumlah3.equals("") || jumlah3.equals("0")) {
            garis3.setVisibility(View.GONE);
            item3.setVisibility(View.GONE);
        } else {
            quantity3.setText("Rp. 15.000 x @" + jumlah3);
            total3.setText("Rp. " + Integer.parseInt(jumlah3) * 15000);
            hasil3 = Integer.parseInt(jumlah3) * 15000;
        }

        if (jumlah4.equals("") || jumlah4.equals("0")) {
            garis4.setVisibility(View.GONE);
            item4.setVisibility(View.GONE);
        } else {
            quantity4.setText("Rp. 15.000 x @" + jumlah4);
            total4.setText("Rp. " + Integer.parseInt(jumlah4) * 15000);
            hasil4 = Integer.parseInt(jumlah4) * 15000;
        }

        if (jumlah5.equals("") || jumlah5.equals("0")) {
            item5.setVisibility(View.GONE);
        } else {
            quantity5.setText("Rp. 12.000 x @" + jumlah5);
            total5.setText("Rp. " + Integer.parseInt(jumlah5) * 12000);
            hasil5 = Integer.parseInt(jumlah5) * 15000;
        }

        //untuk menghitung total dan set tulisan
        total.setText("Rp. " + (hasil1 + hasil2 + hasil3 + hasil4 + hasil5));

        //untuk konfirmasi dan keluarkan notifikasi
        bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(PaymentActivity.this);
                builder.setTitle("Lakukan Pembayaran?")
                        .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(PaymentActivity.this, "Terima Kasih!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(PaymentActivity.this, MainActivity.class));
                            }
                        })
                        .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }

    @Override
    //untuk kembali bawa meja dan nama pemesan ke activity sebelumnya
    public void onBackPressed() {
        Intent intent = new Intent(PaymentActivity.this, PickItemActivity.class);
        intent.putExtra("nama", nama);
        intent.putExtra("meja", meja);
        startActivity(intent);
        super.onBackPressed();
    }
}