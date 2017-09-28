package com.example.pc.tabmenutest2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Field;

import static com.example.pc.tabmenutest2.R.id.navigation_home;

public class PPMainActivity extends AppCompatActivity {
    String info="";
    BottomNavigationView PPnavigation;
    private TextView mTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            PPnavigation = (BottomNavigationView) findViewById(R.id.PP_navigation);
            PPnavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            disableShiftMode(PPnavigation); // 메뉴4개 호출
            PPnavigation.setVisibility(View.VISIBLE);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        //메뉴선택 메소드
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case navigation_home:

                    return true;
                case R.id.navigation_allMenu:

                    return true;
                case R.id.navigation_phone:

                    return true;
                case R.id.navigation_login:
                    info="NoMain";
                    Intent it = new Intent(PPMainActivity.this , LoginActivity.class);
                    it.putExtra("info",info);
                    startActivity(it);
                    Log.d("info1",info);
                    return true;
            }
            return false;
        }
    };

    // 메뉴 4개 이상 고정 메소드
    public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            //Timber.e(e, "Unable to get shift mode field");
        } catch (IllegalAccessException e) {
            //Timber.e(e, "Unable to change value of shift mode");
        }
    }

}