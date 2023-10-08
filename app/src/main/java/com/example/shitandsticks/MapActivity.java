package com.example.shitandsticks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.shitandsticks.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap gMap;
    FrameLayout map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        map = findViewById(R.id.map);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.gMap = googleMap;

        LatLng goldenPuck = new LatLng(53.184547126126596, 45.06522101250114);
        gMap.addMarker(new MarkerOptions().position(goldenPuck).title("Золотая шайба, ледово-спортивный комплекс. Открыто: до 22:00"));
        gMap.moveCamera(CameraUpdateFactory.newLatLng(goldenPuck));

        LatLng majorLeague = new LatLng(53.184547126126596, 45.06522101250114);
        gMap.addMarker(new MarkerOptions().position(majorLeague).title("\"Высшая лига\", ул. Московская, 37, 5 этаж. Открыто: до 21:00"));
        gMap.moveCamera(CameraUpdateFactory.newLatLng(majorLeague));

        LatLng sportsPalace = new LatLng(53.19048864239309, 44.99854863183193);
        gMap.addMarker(new MarkerOptions().position(sportsPalace).title("Дворец спорта \"Рубин\", ул. Революционная, 9. Открыто: до 22:00"));
        gMap.moveCamera(CameraUpdateFactory.newLatLng(sportsPalace));
    }
}