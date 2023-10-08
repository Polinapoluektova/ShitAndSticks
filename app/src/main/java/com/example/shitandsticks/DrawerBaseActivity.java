package com.example.shitandsticks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.navigation.NavigationView;

public class DrawerBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;

    @Override
    public void setContentView(View view) {
        drawerLayout=(DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base, null);
        FrameLayout container = drawerLayout.findViewById(R.id.activityConteiner);
        container.addView(view);
        super.setContentView(drawerLayout);

        Toolbar toolbar = drawerLayout.findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        NavigationView navigationView  = drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.menu_driver_open,
                R.string.menu_driver_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // отслеживает куда нажал пользователь и переходит в то меню

        drawerLayout.closeDrawer(GravityCompat.START);


        if (item.getItemId() == R.id.messages) {
            Intent intent = new Intent (DrawerBaseActivity.this, MainActivity.class);
            startActivity(intent);
        }

        if (item.getItemId() == R.id.map) {
            Intent intent = new Intent (DrawerBaseActivity.this, MapActivity.class);
            startActivity(intent);
        }


        if (item.getItemId() == R.id.exit) {
            Intent intent = new Intent (DrawerBaseActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        return false;
    }

    protected void allocateActivityTitle(String titleString){
        if (getSupportActionBar()!= null)
            getSupportActionBar().setTitle(titleString);
    }
}