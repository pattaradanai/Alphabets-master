package com.example.alphabets;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.alphabets.model.EnglishAlphabet;

/**
 * Created by thanadej on 11/8/2015 AD.
 */

//extends คลาสแอนดรอย FragmetPagerAdpter(เก็บทุกหน้า) and FragmetStatePagerAdapter(เก็บแค่หน้าข้างๆ)
public class AlphabetPagerAdaptor extends FragmentStatePagerAdapter {


    public AlphabetPagerAdaptor(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        //มันจะส่งpositionมาเฉยๆ เราก็ส่งไปที่alphabetFragmentต่อ
        AlphabetFragment fragment = AlphabetFragment.newInstance(position);
        return fragment;
    }

    @Override
    public int getCount() {
        return EnglishAlphabet.DATA.length;
    }
    //เรียกเอาไปแสดงข้างบน เรียกว่าgetpagetitle
    @Override
    public CharSequence getPageTitle(int position) {
        return EnglishAlphabet.DATA[position].toString();
    }
}
