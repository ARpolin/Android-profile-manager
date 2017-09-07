package profile.manager.sensor.profilemanager;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SensorActivity extends AppCompatActivity implements SensorEventListener {
    public TextView x,y,z;
    public SensorManager mSensorManager;
    public Sensor mAcceleration;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAcceleration = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }
    public void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAcceleration, mSensorManager.SENSOR_DELAY_NORMAL);
        x=(TextView)findViewById(R.id.xvalue);
        y=(TextView)findViewById(R.id.yvalue);
        z=(TextView)findViewById(R.id.zvalue);
    }

    public void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        x.setText("X: "+event.values[0]);
        y.setText("Y: "+ event.values[1]);
        z.setText("Z: "+ event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
