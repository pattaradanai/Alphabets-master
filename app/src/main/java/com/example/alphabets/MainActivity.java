package com.example.alphabets;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements AlphabetListFragment.MyListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    private void loadFragment(int i) {
        //เรียกผ่าน เมทอดที่สร้างFragment
        AlphabetFragment fragment = AlphabetFragment.newInstance(i);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container,fragment);
        transaction.commit();
    }
    //โค็ดที่เข้าถึงFrameLayout ด้านขวา ส่งมาจาก AlphabetListFragment อันที่4 MyListener
    @Override
    public void onAlphaberListItemClckd(int position) {
        //หน้าจอแนวตั้งมีเฉพาะlist

        if(findViewById(R.id.fragment_container)==null) {
            Intent intent = new Intent(MainActivity.this,DetailActivity.class);
            intent.putExtra("alphabet_index",position);
            startActivity(intent);
        }else{//หน้าจอแนวนอนมีทั้งlist และ Detail
            loadFragment(position);
        }
    }
}
