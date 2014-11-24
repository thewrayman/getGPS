package com.example.get.gps;
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

import com.beyondar.android.fragment.BeyondarFragmentSupport;
import com.beyondar.android.fragment.*;
import com.beyondar.android.view.BeyondarGLSurfaceView;
import com.beyondar.android.world.*;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.app.*;




import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class GoToCam extends FragmentActivity {
    
    private BeyondarFragmentSupport mBeyondarFragment;
    
 // ...
 @Override
 public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_go_to_cam);
      
/*      setContentView(R.layout.simple_camera);*/
      
      mBeyondarFragment = (BeyondarFragmentSupport) getSupportFragmentManager().findFragmentById(R.id.beyondarFragment);
      
      World world = new World(this);

   // The user can set the default bitmap. This is useful if you are
   // loading images form Internet and the connection get lost
   world.setDefaultImage(R.drawable.arrow);

   // User position (you can change it using the GPS listeners form Android
   // API)
   world.setGeoPosition(41.26533734214473d, 1.925848038959814d);

   // Create an object with an image in the app resources.
   GeoObject go1 = new GeoObject(1l);
   go1.setGeoPosition(41.26523339794433d, 1.926036406654116d);
   go1.setImageResource(R.drawable.androidmessage);
   go1.setName("message");

   // Is it also possible to load the image asynchronously form internet
   GeoObject go2 = new GeoObject(2l);
   go2.setGeoPosition(41.26518966360719d, 1.92582424468222d);
   go2.setImageUri("http://beyondar.com/sites/default/files/logo_reduced.png");
   go2.setName("Online image");

   // Also possible to get images from the SDcard
   GeoObject go3 = new GeoObject(3l);
   go3.setGeoPosition(41.26550959641445d, 1.925873388087619d);
   go3.setImageUri("/sdcard/someImageInYourSDcard.jpeg");
   go3.setName("IronMan from sdcard");

   // And the same goes for the app assets
   GeoObject go4 = new GeoObject(4l);
   go4.setGeoPosition(41.26518862002349d, 1.925662767707665d);
   go4.setImageUri("assets://creature_7.png");
   go4.setName("Image from assets");

   // We add this GeoObjects to the world
   world.addBeyondarObject(go1);
   world.addBeyondarObject(go2);
   world.addBeyondarObject(go3);
   world.addBeyondarObject(go4);

   // Finally we add the Wold data in to the fragment
   mBeyondarFragment.setWorld(world);
 }
 
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_go_to_cam, menu);
        return true;
    }
    
}
