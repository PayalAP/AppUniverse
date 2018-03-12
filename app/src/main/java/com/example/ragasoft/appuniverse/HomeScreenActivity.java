package com.example.ragasoft.appuniverse;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ragasoft.appuniverse.Fragment.BlockCardFragment;
import com.example.ragasoft.appuniverse.Fragment.ContactDetailFragment;
import com.example.ragasoft.appuniverse.Fragment.EditProfileFragment;
import com.example.ragasoft.appuniverse.Fragment.HomeScreenFragment;
import com.example.ragasoft.appuniverse.Fragment.MyTransactionFragment;
import com.example.ragasoft.appuniverse.Fragment.NotificationFragment;
import com.example.ragasoft.appuniverse.Fragment.SendMailFragment;

public class HomeScreenActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        HomeScreenFragment.OnFragmentInteractionListener, SendMailFragment.OnFragmentInteractionListener,
        MyTransactionFragment.OnFragmentInteractionListener, NotificationFragment.OnFragmentInteractionListener, EditProfileFragment.OnFragmentInteractionListener,
        BlockCardFragment.OnFragmentInteractionListener, ContactDetailFragment.OnFragmentInteractionListener {
    Toolbar toolbar;
    BottomNavigationView bottomNavigationView;
    FragmentTransaction fragmentTransaction;
    HomeScreenFragment home_fragment;
    SendMailFragment sendMail;
    MyTransactionFragment myTransaction;
    ImageView tb_logo;
    TextView rupee;
    TextView rupee_amt, avi_Bal;
    NotificationFragment notification_fragment;
    EditProfileFragment editProfile;
    BlockCardFragment blockCard_fragment;
    ContactDetailFragment contactDetailFragment;
    TextView rupee_symbol;
    FragmentManager fm;
    String an,ad;
    String bss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        toolbar = findViewById(R.id.toolbar_activity);
        tb_logo = findViewById(R.id.toolbar_logo);
        rupee = findViewById(R.id.image_rupee);
        rupee_amt = findViewById(R.id.rupee_amount);
        avi_Bal = findViewById(R.id.text_aviBal);
        toolbar.setNavigationIcon(R.drawable.navicon);

        setSupportActionBar(toolbar);

        bottomNavigationView = findViewById(R.id.bottom_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.home)
                {
                    if (home_fragment   != null)
                    {
                        toolbar.setVisibility(View.VISIBLE);
                        fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame, home_fragment);
//                        fragmentTransaction.addToBackStack(null);

                        fragmentTransaction.commit();
                        Toast.makeText(HomeScreenActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                            toolbar.setVisibility(View.VISIBLE);
                            home_fragment = new HomeScreenFragment();
                            fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.frame, home_fragment);
//                            fragmentTransaction.addToBackStack(null);

                            fragmentTransaction.commit();
                            Toast.makeText(HomeScreenActivity.this, "Home", Toast.LENGTH_SHORT).show();
//                        home_fragment = new HomeScreenFragment();
                    }

                }
                if (id == R.id.recharge)
                {
                    Toast.makeText(HomeScreenActivity.this, "Recharge", Toast.LENGTH_SHORT).show();
                }
                if (id == R.id.assistance)
                {
                    Toast.makeText(HomeScreenActivity.this, "Assistance", Toast.LENGTH_SHORT).show();
                }


                return false;
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle
                        (
                                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);

        toggle.syncState();
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.navicon);


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
//        rupee_symbol = navigationView.findViewById(R.id.rupee);
//        rupee_symbol.setText("\u20B9");

        if (home_fragment == null) {


            toolbar.setVisibility(View.VISIBLE);
            home_fragment = new HomeScreenFragment();

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, home_fragment);
//            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();
        } else {
            toolbar.setVisibility(View.VISIBLE);
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, home_fragment);
//            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();
        }


    }

    @Override
    public void onBackPressed()
    {
         DrawerLayout drawer = findViewById(R.id.drawer_layout);
         if (drawer.isDrawerOpen(GravityCompat.START))
        {
          drawer.closeDrawer(GravityCompat.START);
        }
//        else if (fm.getBackStackEntryCount() == 1)
//        {
//            for (int i = 0; i < fm.getBackStackEntryCount(); ++i)
//            {
//                fm.popBackStack();
//            }
//          //  Toast.makeText(this, "This is back pressed Toast", Toast.LENGTH_SHORT).show();
//            super.onBackPressed();
//        }
        else
        {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile: {
                if (editProfile == null) {
//                toolbar.setVisibility(View.GONE);
                    editProfile = new EditProfileFragment();
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, editProfile);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                } else {
//                toolbar.setVisibility(View.GONE);
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, editProfile);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                }
            }
            break;
            case R.id.shopkeeper: {
                Toast.makeText(this, "Search Shopkeeper", Toast.LENGTH_SHORT).show();

            }
            break;

            case R.id.notification: {
                if (notification_fragment == null) {
                    toolbar.setVisibility(View.GONE);
                    notification_fragment = new NotificationFragment();
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, notification_fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    Toast.makeText(this, "NotificationFragment", Toast.LENGTH_SHORT).show();
                } else {
                    toolbar.setVisibility(View.GONE);
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, notification_fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                    Toast.makeText(this, "NotificationFragment", Toast.LENGTH_SHORT).show();
                }
            }
            break;
            case R.id.send_mail: {
                if (sendMail == null) {
                    toolbar.setVisibility(View.GONE);

                    sendMail = new SendMailFragment();
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, sendMail);
                    fragmentTransaction.addToBackStack(null);

                    fragmentTransaction.commit();
                    Toast.makeText(this, "Send Email", Toast.LENGTH_SHORT).show();
                } else {
                    toolbar.setVisibility(View.GONE);
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, sendMail);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
            break;
            case R.id.my_transaction: {
                if (myTransaction == null) {
                    toolbar.setVisibility(View.GONE);
                    myTransaction = new MyTransactionFragment();
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, myTransaction);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                } else {
                    toolbar.setVisibility(View.GONE);
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, myTransaction);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
            break;
            case R.id.card_block: {
                if (blockCard_fragment == null) {
                    toolbar.setVisibility(View.GONE);
                    blockCard_fragment = new BlockCardFragment();
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, blockCard_fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                } else {
                    toolbar.setVisibility(View.GONE);
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, blockCard_fragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
            break;
            case R.id.contactus: {

                if (contactDetailFragment == null) {
                    toolbar.setVisibility(View.GONE);
                    contactDetailFragment = new ContactDetailFragment();
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, contactDetailFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                } else {
                    toolbar.setVisibility(View.GONE);
                    fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame, contactDetailFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
