package com.example.get.gps;
/*package com.example.get.gps;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.location.*;
import android.location.LocationListener;
import android.location.LocationManager;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
    
    
    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(this);
    }
    
    
}
*/

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements LocationListener {
  private TextView latituteField;
  private TextView longitudeField;
  private LocationManager locationManager;
  private String provider;

  String longitude;
  String latitude;
/** Called when the activity is first created. */

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    latituteField = (TextView) findViewById(R.id.TextView02);
    longitudeField = (TextView) findViewById(R.id.TextView04);
    long longitude;
    long latitude;
    

    // Get the location manager
    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    // Define the criteria how to select the locatioin provider -> use
    // default
    Criteria criteria = new Criteria();
    provider = locationManager.getBestProvider(criteria, false);
    Location location = locationManager.getLastKnownLocation(provider);

    // Initialize the location fields
    if (location != null) {
      System.out.println("Provider " + provider + " has been selected.");
      onLocationChanged(location);
    } else {
      latituteField.setText("Location not available");
      longitudeField.setText("Location not available");
    }
  }
  
  public void buttonclick(View view){
/*  	Intent intent = new Intent(this, GpsActivity.class);*/
/*  	TextView longitude = (TextView) findViewById(R.id.TextView02);
  	TextView latitude = (TextView) findViewById(R.id.TextView04);*/
    latituteField.setText(String.valueOf(latitude));
    longitudeField.setText(String.valueOf(longitude));
/*  	startActivity(intent);*/
	  
  }
  
  public void goToCamera(View view){
	  Intent intent = new Intent(this, GoToCam.class);
	  startActivity(intent);
	  
  }

  /* Request updates at startup */
  @Override
  protected void onResume() {
    super.onResume();
    locationManager.requestLocationUpdates(provider, 400, 1, this);
  }

  /* Remove the locationlistener updates when Activity is paused */
  @Override
  protected void onPause() {
    super.onPause();
    locationManager.removeUpdates(this);
  }

  public void onLocationChanged(Location location) {
    double lat = (location.getLatitude());
    double lng =  (location.getLongitude());
    latitude = String.valueOf(lat);
    longitude = String.valueOf(lng);
    
  }

  public void onStatusChanged(String provider, int status, Bundle extras) {
    // TODO Auto-generated method stub

  }

  public void onProviderEnabled(String provider) {
    Toast.makeText(this, "Enabled new provider " + provider,
        Toast.LENGTH_SHORT).show();

  }

  public void onProviderDisabled(String provider) {
    Toast.makeText(this, "Disabled provider " + provider,
        Toast.LENGTH_SHORT).show();
  }
} 