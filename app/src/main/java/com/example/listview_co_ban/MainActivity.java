package com.example.listview_co_ban;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv1;
    Button btn1, btn2;
    EditText edt1;

    int vitri = -1;


    ArrayList<String> arrayCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv1 = (ListView) findViewById(R.id.listView1);
        btn1 = (Button) findViewById(R.id.button1);
        edt1 = (EditText) findViewById(R.id.editText1);
        btn2 = (Button) findViewById(R.id.button2);

        arrayCourse = new ArrayList<>();

        arrayCourse.add("Toán");
        arrayCourse.add("Văn");
        arrayCourse.add("Anh");
        arrayCourse.add("Sử");

        final ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, arrayCourse);

        lv1.setAdapter(adapter);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String monHoc = edt1.getText().toString();
                arrayCourse.add(monHoc);
                adapter.notifyDataSetChanged();
            }
        });

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edt1.setText(arrayCourse.get(position));
                vitri = position;
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayCourse.set(vitri, edt1.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

//        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//
//                arrayCourse.remove(position);
//                adapter.notifyDataSetChanged();
//
//                return false;
//            }
//        });

        lv1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);

                intent.putExtra("key1", arrayCourse.get(position));

                startActivity(intent);

                return false;
            }
        });

    }
}
