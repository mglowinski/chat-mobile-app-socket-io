package com.android.mobilechat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.android.mobilechat.fragment.JoinChatFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, JoinChatFragment.newInstance(), JoinChatFragment.TAG)
                    .commit();
        }
    }

}
