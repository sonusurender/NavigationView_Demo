package com.navigationview_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.default_navigation_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNavigationViewActivity(true);
            }
        });
        findViewById(R.id.custom_navigation_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNavigationViewActivity(false);
            }
        });
    }

    /*  Start Navigation View activity  */
    private void startNavigationViewActivity(boolean value) {
        Intent in = new Intent(MainActivity.this, NavigationView_Activity.class);
        in.putExtra("value", value);
        startActivity(in);

    }
}
