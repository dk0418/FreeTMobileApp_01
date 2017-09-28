package com.example.pc.tabmenutest2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


public class HomeFragment extends Fragment implements View.OnClickListener
{
    String url ="http://m.freet.co.kr/mevent/event_201709.jsp";
    String url2 ="http://m.freet.co.kr/mevent/event_201708.jsp";
    Intent it;
    Button leftbutton , rightbutton;
    public HomeFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        ImageView imageevent = (ImageView)view.findViewById(R.id.imageevent);
        ImageView imageevent2 = (ImageView)view.findViewById(R.id.imageevent2);
        leftbutton = (Button)view.findViewById(R.id.imageleft_button);
        rightbutton = (Button)view.findViewById(R.id.imageright_button);
        imageevent.setOnClickListener(this);
        imageevent2.setOnClickListener(this);
        leftbutton.setOnClickListener(this);
        rightbutton.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.imageevent:
                it = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(it);
                break;
            case R.id.imageevent2:
                it = new Intent(Intent.ACTION_VIEW, Uri.parse(url2));
                startActivity(it);
                break;

        }

    }
}
