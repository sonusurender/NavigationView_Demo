package com.navigationview_demo;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SONU on 21/03/16.
 */
public class NavigationView_Activity extends AppCompatActivity {

    private static DrawerLayout mDrawerLayout;
    private static ActionBarDrawerToggle mDrawerToggle;
    private static Toolbar toolbar;
    private static FragmentManager fragmentManager;
    private static NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get boolean data value from intent
        boolean isDefaultNavigationView = getIntent().getBooleanExtra("value", false);

        //according to boolean value set content view
        if (isDefaultNavigationView)
            setContentView(R.layout.default_navigation_view_activity);
        else
            setContentView(R.layout.custom_navigation_view_activity);

        initViews();
        setUpHeaderView();
        onMenuItemSelected();

        //At start set home fragment
        if (savedInstanceState == null) {
            navigationView.setCheckedItem(R.id.home);
            MenuItem item = navigationView.getMenu().findItem(R.id.home);
            setFragment(item);
        }
    }

    /*  Init all views  */
    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.slider_menu);
        fragmentManager = getSupportFragmentManager();
        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout, toolbar, // nav menu toggle icon
                R.string.drawer_open, // nav drawer open - description for
                // accessibility
                R.string.drawer_close // nav drawer close - description for
                // accessibility
        ) {
            public void onDrawerClosed(View view) {
            }

            public void onDrawerOpened(View drawerView) {

            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    /**
     * For using header view use this method
     **/
    private void setUpHeaderView() {
        View headerView = navigationView.inflateHeaderView(R.layout.header_view);
        TextView textOne = (TextView) headerView.findViewById(R.id.username);
        TextView textTwo = (TextView) headerView.findViewById(R.id.email_address);
    }


    /*  Method for Navigation View item selection  */
    private void onMenuItemSelected() {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                //Check and un-check menu item if they are checkable behaviour
                if (item.isCheckable()) {
                    if (item.isChecked()) item.setChecked(false);
                    else item.setChecked(true);
                }

                //Closing drawer on item click
                mDrawerLayout.closeDrawers();

                switch (item.getItemId()) {
                    case R.id.home:
                        //Replace fragment


                        setFragment(item);
                        break;

                    case R.id.my_account:
                        //Replace fragment


                        setFragment(item);
                        break;
                    case R.id.chat:
                        //Replace fragment


                        setFragment(item);
                        break;
                    case R.id.notifications:
                        //Replace fragment


                        setFragment(item);

                        break;
                    case R.id.share_app:

                        //Start new Activity or do your stuff


                        Toast.makeText(NavigationView_Activity.this, "You Clicked on \"" + item.getTitle().toString() + "\" menu item.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rate_app:
                        //Start new Activity or do your stuff


                        Toast.makeText(NavigationView_Activity.this, "You Clicked on \"" + item.getTitle().toString() + "\" menu item.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.settings:
                        //Start new Activity or do your stuff


                        Toast.makeText(NavigationView_Activity.this, "You Clicked on \"" + item.getTitle().toString() + "\" menu item.", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.help:
                        //Start new Activity or do your stuff


                        Toast.makeText(NavigationView_Activity.this, "You Clicked on \"" + item.getTitle().toString() + "\" menu item.", Toast.LENGTH_SHORT).show();

                        break;

                }

                return false;
            }
        });
    }

    /*  Set Fragment, setting toolbar title and passing item title via bundle to fragments*/
    public void setFragment(MenuItem item) {
        toolbar.setTitle(item.getTitle());

        //Find fragment by tag
        Fragment fr = fragmentManager.findFragmentByTag(item.getTitle().toString());

        Fragment dummyFragment = new Dummy_Fragment();
        Bundle b = new Bundle();

        //If fragment is null replace fragment
        if (fr == null) {
            b.putString("data", item.getTitle().toString());
            dummyFragment.setArguments(b);//Set Arguments
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_container,
                            dummyFragment, item.getTitle().toString())
                    .commit();
        }
    }


    //On back press check if drawer is open and closed
    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(Gravity.LEFT))
            mDrawerLayout.closeDrawers();
        else
            super.onBackPressed();
    }
}
