package pt.ipt.dama.googlemaps

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import pt.ipt.dama.googlemaps.databinding.ActivityMainBinding

/*
class MainActivity : AppCompatActivity() {   */
class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        /*
        ##############################################################
        DO NOT FORGET THAT YOU MUST ASK FOR PERMISSION TO USE GPS DATA
        ############################################################## */

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * In this case, we just add a marker at IPT, Tomar.
     * If Google Play services is not installed on the device,
     * the user will be prompted to install it inside the SupportMapFragment.
     * This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Tomar and move the camera to it
        val tomar = LatLng(39.59963776764394, -8.391843590532233)
        mMap.addMarker(MarkerOptions().position(tomar).title("IPT (O103)"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tomar,16f))
        //                                 .newLatLng(tomar))
        //                                 .newLatLngZoom(tomar,15f))
        // permite os controlos do Zoom
        mMap.uiSettings.isZoomControlsEnabled=true
    }

}