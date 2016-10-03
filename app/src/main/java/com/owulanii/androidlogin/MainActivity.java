package com.owulanii.androidlogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import prefs.UserInfo;
import prefs.UserSession;

public class MainActivity extends AppCompatActivity {

    private Button logout;
    private TextView tvUsername, tvEmail;
    private UserInfo userInfo;
    private UserSession userSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInfo        = new UserInfo(this);
        userSession     = new UserSession(this);
        logout          = (Button)findViewById(R.id.logout);
        tvUsername      = (TextView)findViewById(R.id.key_username);
        tvEmail         = (TextView)findViewById(R.id.key_email);

        if(!userSession.isUserLoggedin()){
            startActivity(new Intent(this, Login.class));
            finish();
        }

        String username = userInfo.getKeyUsername();
        String email    = userInfo.getKeyEmail();

        tvUsername.setText(username);
        tvEmail.setText(email);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userSession.setLoggedin(false);
                userInfo.clearUserInfo();
                startActivity(new Intent(MainActivity.this, Login.class));
                finish();
            }
        });


    }

}
