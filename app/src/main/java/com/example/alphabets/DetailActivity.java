package com.example.alphabets;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();

        int alphabetIndex= intent.getIntExtra("alphabet_index", 0);
        //พูก ViewPager กับ adapter
        ViewPager pager = (ViewPager)findViewById(R.id.view_pager);
        //สร้าง ออบเจ็ก adapter
        AlphabetPagerAdaptor adapter = new AlphabetPagerAdaptor(getSupportFragmentManager());
        pager.setAdapter(adapter);
        //โชว์ไปหน้าที่คลิก
        pager.setCurrentItem(alphabetIndex);

        TabLayout tabs = (TabLayout)findViewById(R.id.tab_layout);
        tabs.setupWithViewPager(pager);
    }


}
