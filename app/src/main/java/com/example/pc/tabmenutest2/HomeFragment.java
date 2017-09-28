package com.example.pc.tabmenutest2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class HomeFragment extends Fragment implements View.OnClickListener
{
    String url ="http://m.freet.co.kr/mevent/event_201709.jsp";
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
        imageevent.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.imageevent:
                Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(it);
                break;
        }

    }
}
