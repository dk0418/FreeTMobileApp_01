package com.example.pc.tabmenutest2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Field;

import static com.example.pc.tabmenutest2.R.id.navigation_home;

public class DPMainActivity extends AppCompatActivity {
    String info="";
    BottomNavigationView DPnavigation;
    private TextView mTextMessage;
    Intent it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            DPnavigation = (BottomNavigationView) findViewById(R.id.DP_navigation);
            DPnavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
            disableShiftMode(DPnavigation); // 메뉴4개 호출
            DPnavigation.setVisibility(View.VISIBLE);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeButtonEnabled(true);
    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        if(id == R.id.logout)
        {
//            it = new Intent(DPMainActivity.this , MainActivity.class);
//            startActivity(it);
//            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        //메뉴선택 메소드
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case navigation_home:

                case R.id.navigation_allMenu:

                    return true;
                case R.id.navigation_charge:

                    return true;
                case R.id.navigation_login:
                    info="NoMain";
                    it = new Intent(DPMainActivity.this , LoginActivity.class);
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