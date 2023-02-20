package com.example.projectpages;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class datascreen extends Activity {
    Button btn;
    ListView list1;
    List list;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_screen);

        btn = (Button)findViewById(R.id.buttonR);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(datascreen.this,contactpage.class);
                startActivity(intent);

            }
        });


        list1 = (ListView) findViewById(R.id.list1);

        list = new ArrayList<String>();

        list.add("07/09/23: Grill out day!");
        list.add("07/10/23: Puppy's on the patio!");
        list.add("07/12/23: Shop till you drop!");
        list.add("07/15/23: Yard sale day!");
        list.add("07/16/23: Music hall tour!");
        list.add("07/18/23: Museum day!");
        list.add("07/20/23: Mimosas and patios!");
        list.add("07/21/23: Live music!");
        list.add("07/24/23: Yoga center village!");
        list.add("07/30/23: Live music!");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1, list);

        list1.setAdapter(arrayAdapter);


    }
}
