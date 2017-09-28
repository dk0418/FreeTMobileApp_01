package com.example.pc.tabmenutest2;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity implements View.OnClickListener{

    String info="";
    Button DPbutton , PPbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DPbutton = (Button)findViewById(R.id.DPbutton); //후불
        PPbutton = (Button)findViewById(R.id.PPbutton); //선불

        DPbutton.setOnClickListener(this);
        PPbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.DPbutton:
                Intent DPit = new Intent(LoginActivity.this , DPMainActivity.class);
                startActivity(DPit);
                break;
            case R.id.PPbutton:
                Intent PPit = new Intent(LoginActivity.this , PPMainActivity.class);
                startActivity(PPit);
                break;
        }
    }
}
