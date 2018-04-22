package com.example.drawerver3;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> listAdapter;
    String fragmentArray[] ={"Fragment 1","Fragment 2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView=findViewById(R.id.listview);
        listAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,fragmentArray);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Fragment fragment;
                switch (i){
                    case 0:
                        fragment=new FragmentOne();
                        break;
                    case 1:
                        fragment=new FragmentTwo();
                        break;
                        default:
                            fragment=new FragmentOne();
                            break;
                }
                FragmentManager fragmentManager;
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.relativeLayout,fragment).commit();
            }
        });


    }
}
