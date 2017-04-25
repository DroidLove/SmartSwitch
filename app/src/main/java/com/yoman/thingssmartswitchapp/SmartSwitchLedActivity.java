package com.yoman.thingssmartswitchapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.things.pio.Gpio;
import com.google.android.things.pio.PeripheralManagerService;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mobility.sunday.thingssmartswitchapp.R;

public class SmartSwitchLedActivity extends Activity {

  PeripheralManagerService pioService;
  Gpio mGPIOs[] = new Gpio[8];
  private DatabaseReference databaseReferenceForS0, databaseReferenceForS1, databaseReferenceForS2, databaseReferenceForS3, databaseReferenceForS4, databaseReferenceForS5, databaseReferenceForS6, databaseReferenceForS7;
  String TAG = getClass().getName();
  ArrayList<ModelSwitch> mArrayListInitialState;
  List<String> gpioPinsNames;
  ImageView imageView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_smart_switch_led);

    init();

    for (int i = 0; i < gpioPinsNames.size(); i++) {
      try {

        mGPIOs[i] = pioService.openGpio(gpioPinsNames.get(i));
        mGPIOs[i].setEdgeTriggerType(Gpio.EDGE_NONE);
        mGPIOs[i].setActiveType(Gpio.ACTIVE_HIGH);
        mGPIOs[i].setDirection(Gpio.DIRECTION_OUT_INITIALLY_LOW);


      } catch (Exception e) {
        Log.e("ex main", e.toString());
      }
    }

    initGoogleFirebase();

  }

  private void init() {
    mArrayListInitialState = new ArrayList<>();
    gpioPinsNames = new ArrayList<>();
    pioService = new PeripheralManagerService();
    gpioPinsNames = BoardDefaults.getAllGpioPinsName();
    imageView = (ImageView) findViewById(R.id.imageView);
  }

  private void initGoogleFirebase() {

    databaseReferenceForS0 = FirebaseDatabase.getInstance().getReference("switchlist").child("s0");
    databaseReferenceForS1 = FirebaseDatabase.getInstance().getReference("switchlist").child("s1");
    databaseReferenceForS2 = FirebaseDatabase.getInstance().getReference("switchlist").child("s2");
    databaseReferenceForS3 = FirebaseDatabase.getInstance().getReference("switchlist").child("s3");
    databaseReferenceForS4 = FirebaseDatabase.getInstance().getReference("switchlist").child("s4");
    databaseReferenceForS5 = FirebaseDatabase.getInstance().getReference("switchlist").child("s5");
    databaseReferenceForS6 = FirebaseDatabase.getInstance().getReference("switchlist").child("s6");
    databaseReferenceForS7 = FirebaseDatabase.getInstance().getReference("switchlist").child("s7");

    databaseReferenceForS0.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {

        ModelSwitch modelSwitch = dataSnapshot.getValue(ModelSwitch.class);
        if (modelSwitch.getSwitchStatus()) {
          Log.e("status 1", "on");
          try {
            mGPIOs[0].setValue(true);
            Log.e("status", "on");
          } catch (IOException e) {
            Log.e(TAG, "error toggling gpio:" + e.toString());
          }

        } else {
          Log.e("status", "off");
          try {
            mGPIOs[0].setValue(false);
            Log.e("status 1", "off");
          } catch (IOException e) {
            Log.e(TAG, "error toggling gpio:" + e.toString());
          }
        }
      }

      @Override
      public void onCancelled(DatabaseError databaseError) {

      }

    });

    databaseReferenceForS1.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {

        ModelSwitch modelSwitch = dataSnapshot.getValue(ModelSwitch.class);
        Log.e("ButtonStatus 2", "" + modelSwitch.getSwitchname());
        if (modelSwitch.getSwitchStatus()) {
          Log.e("status 2", "on");
          try {
            mGPIOs[1].setValue(true);
            Log.e("status", "on");
          } catch (IOException e) {
            Log.e(TAG, "error toggling gpio:" + e.toString());
          }

        } else {
          Log.e("status", "off");
          try {
            mGPIOs[1].setValue(false);
            Log.e("status 2", "off");
          } catch (IOException e) {
            Log.e(TAG, "error toggling gpio:" + e.toString());
          }
        }
      }

      @Override
      public void onCancelled(DatabaseError databaseError) {

      }

    });

    databaseReferenceForS2.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {

        ModelSwitch modelSwitch = dataSnapshot.getValue(ModelSwitch.class);
        Log.e("ButtonStatus 3", "" + modelSwitch.getSwitchname());
        if (modelSwitch.getSwitchStatus()) {
          Log.e("status 3", "on");
          try {
            mGPIOs[2].setValue(true);
            Log.e("status", "on");
          } catch (IOException e) {
            Log.e(TAG, "error toggling gpio:" + e.toString());
          }

        } else {
          Log.e("status", "off");
          try {
            mGPIOs[2].setValue(false);
            Log.e("status 3", "off");
          } catch (IOException e) {
            Log.e(TAG, "error toggling gpio:" + e.toString());
          }
        }
      }

      @Override
      public void onCancelled(DatabaseError databaseError) {

      }

    });

    databaseReferenceForS3.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {

        ModelSwitch modelSwitch = dataSnapshot.getValue(ModelSwitch.class);
        Log.e("ButtonStatus 4", "" + modelSwitch.getSwitchname());
        if (modelSwitch.getSwitchStatus()) {
          Log.e("status 4", "on");
          try {
            mGPIOs[3].setValue(true);
            Log.e("status", "on");
          } catch (IOException e) {
            Log.e(TAG, "error toggling gpio:" + e.toString());
          }

        } else {
          Log.e("status", "off");
          try {
            mGPIOs[3].setValue(false);
            Log.e("status 4", "off");
          } catch (IOException e) {
            Log.e(TAG, "error toggling gpio:" + e.toString());
          }
        }
      }

      @Override
      public void onCancelled(DatabaseError databaseError) {

      }

    });

    databaseReferenceForS4.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {

        ModelSwitch modelSwitch = dataSnapshot.getValue(ModelSwitch.class);
        if (modelSwitch.getSwitchStatus()) {
          try {
            mGPIOs[4].setValue(true);
          } catch (IOException e) {
            Log.e(TAG, "error toggling gpio:" + e.toString());
          }

        } else {
          try {
            mGPIOs[4].setValue(false);
          } catch (IOException e) {
            Log.e(TAG, "error toggling gpio:" + e.toString());
          }
        }
      }

      @Override
      public void onCancelled(DatabaseError databaseError) {

      }

    });

    databaseReferenceForS5.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {

        ModelSwitch modelSwitch = dataSnapshot.getValue(ModelSwitch.class);
        if (modelSwitch.getSwitchStatus()) {
          try {
            mGPIOs[5].setValue(true);
          } catch (IOException e) {
            Log.e(TAG, "error toggling gpio:" + e.toString());
          }

        } else {
          try {
            mGPIOs[5].setValue(false);
          } catch (IOException e) {
            Log.e(TAG, "error toggling gpio:" + e.toString());
          }
        }
      }

      @Override
      public void onCancelled(DatabaseError databaseError) {

      }

    });

    databaseReferenceForS6.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {

        ModelSwitch modelSwitch = dataSnapshot.getValue(ModelSwitch.class);
        if (modelSwitch.getSwitchStatus()) {
          try {
            mGPIOs[6].setValue(true);
          } catch (IOException e) {
            Log.e(TAG, "error toggling gpio:" + e.toString());
          }

        } else {
          try {
            mGPIOs[6].setValue(false);
          } catch (IOException e) {
            Log.e(TAG, "error toggling gpio:" + e.toString());
          }
        }
      }

      @Override
      public void onCancelled(DatabaseError databaseError) {

      }

    });

    databaseReferenceForS7.addValueEventListener(new ValueEventListener() {
      @Override
      public void onDataChange(DataSnapshot dataSnapshot) {

        ModelSwitch modelSwitch = dataSnapshot.getValue(ModelSwitch.class);
        if (modelSwitch.getSwitchStatus()) {
          try {
            mGPIOs[7].setValue(true);
          } catch (IOException e) {
            Log.e(TAG, "error toggling gpio:" + e.toString());
          }

        } else {
          try {
            mGPIOs[7].setValue(false);
          } catch (IOException e) {
            Log.e(TAG, "error toggling gpio:" + e.toString());
          }
        }
      }

      @Override
      public void onCancelled(DatabaseError databaseError) {

      }

    });

  }

}
