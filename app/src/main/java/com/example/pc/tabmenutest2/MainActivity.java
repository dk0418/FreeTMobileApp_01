package com.example.pc.tabmenutest2;



import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    String info="";
    BottomNavigationView Mainnavigation;
    Intent it;
    private final int FRAGMENT_HOME = 1;
    private final int FRAGMENT_ALL = 2;
    private final int FRAGMENT_MY = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mainnavigation = (BottomNavigationView) findViewById(R.id.Main_navigation);
        Mainnavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        disableShiftMode(Mainnavigation); // 메뉴4개 호출
        Mainnavigation.setVisibility(View.VISIBLE);
        // 임의로 액티비티 호출 시점에 어느 프레그먼트를 프레임레이아웃에 띄울 것인지를 정함
        callFragment(FRAGMENT_HOME);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        //메뉴선택 메소드
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {

                case R.id.navigation_home:
                    callFragment(FRAGMENT_HOME);
                    break;
                case R.id.navigation_allMenu:
                    callFragment(FRAGMENT_ALL);
                    break;
                case R.id.navigation_myPage:
                    callFragment(FRAGMENT_MY);
                    break;
                case R.id.navigation_login:
                    it = new Intent(MainActivity.this , LoginActivity.class);
                    startActivity(it);
                    Log.d("info1",info);
                    break;
            }
            return false;
        }
    };
    private void callFragment(int frament_no) {

        // 프래그먼트 사용을 위해
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (frament_no) {
            case 1:
                // '프래그먼트1' 호출
                HomeFragment homefragment = new HomeFragment();
                transaction.replace(R.id.content, homefragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case 2:
                // '프래그먼트2' 호출
                AllMenuFragment menufragment = new AllMenuFragment();
                transaction.replace(R.id.content, menufragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case 3:
                // '프래그먼트2' 호출
                MyPageFragment mypagefragment = new MyPageFragment();
                transaction.replace(R.id.content, mypagefragment);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
        }
    }

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