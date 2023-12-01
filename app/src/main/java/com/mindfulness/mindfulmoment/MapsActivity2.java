package com.mindfulness.mindfulmoment;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.mindfulness.mindfulmoment.databinding.ActivityMaps2Binding;

import java.util.ArrayList;

public class MapsActivity2 extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMaps2Binding binding;
    private ArrayList<LatLng> locations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMaps2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Create a list of locations to add to the map
        locations = new ArrayList<>();
        locations.add(new LatLng(6.958595863472243, 80.13581245914057));
        locations.add(new LatLng(6.901339020083312, 79.89685982076797));
        locations.add(new LatLng(6.979591312401431, 80.0704193168272));
        locations.add(new LatLng(6.912793964684413, 79.91386413996239));
        locations.add(new LatLng(6.890980536258769, 79.97703552521737));
        locations.add(new LatLng(6.927790112659093, 79.87541198935776));
        locations.add(new LatLng(6.940059333716703, 79.86991882525723));

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker at each location and draw a polyline connecting them.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);

        // Add a marker at each location
        for (LatLng loc : locations) {
            mMap.addMarker(new MarkerOptions().position(loc));
        }

        // Move the camera to the first location
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(locations.get(0), 12));

        // Draw a polyline connecting all the locations
        PolylineOptions polylineOptions = new PolylineOptions()
                .color(Color.RED)
                .width(5f);
        for (LatLng loc : locations) {
            polylineOptions.add(loc);
        }
        mMap.addPolyline(polylineOptions);
    }
}
