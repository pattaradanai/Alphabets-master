package com.example.alphabets;


import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.alphabets.model.EnglishAlphabet;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlphabetFragment extends Fragment {

    private int mAlphabetIndex;

    public AlphabetFragment() {
        // Required empty public constructor
    }
    public static AlphabetFragment newInstance(int alphabetIndex){
        AlphabetFragment fragment = new AlphabetFragment();
        Bundle args = new Bundle();
        args.putInt("alphabet_index",alphabetIndex);
        //พูกติดกับFragment
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAlphabetIndex = getArguments().getInt("alphabet_index");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_alphabet, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView =(TextView) view.findViewById(R.id.alphabet_textview);
        char letter = EnglishAlphabet.DATA[mAlphabetIndex].letter;
        textView.setText(String.valueOf(letter));

        int resId = EnglishAlphabet.DATA[mAlphabetIndex].image;
        ImageView iv = (ImageView)view.findViewById(R.id.imageView);
        iv.setImageResource(resId);
    }
}
