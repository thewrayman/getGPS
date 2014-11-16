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
 }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_go_to_cam, menu);
        return true;
    }
}
