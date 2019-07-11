package com.example.list;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    LayoutInflater mInflator;
    ListView listViewing;
    String[] items, prices, descr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        listViewing = findViewById(R.id.listViewing);
        items = res.getStringArray(R.array.items);
        prices = res.getStringArray(R.array.prices);
        descr = res.getStringArray(R.array.descriptions);

        ItemAdapter itemAdapter = new ItemAdapter(this, items, prices, descr);
        listViewing.setAdapter(itemAdapter);

        listViewing.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent showDetails = new Intent(getApplicationContext(), DetailActivity.class);
                showDetails.putExtra("com.example.list.ITEM_IND", position);
                startActivity(showDetails);
            }
        });
    }
}
