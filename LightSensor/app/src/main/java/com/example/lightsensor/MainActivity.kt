package com.example.lightsensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.security.identity.IdentityCredentialException
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.tabs.TabLayout.TabGravity

class MainActivity : AppCompatActivity(), SensorEventListener{

    var sensor: Sensor?=null
    var sensorManager: SensorManager?=null
    lateinit var image: ImageView
    lateinit var background: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById(R.id.displayImage)
        background = findViewById(R.id.background)
//        image.visibility = View.INVISIBLE

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        sensor = sensorManager!!.getDefaultSensor(Sensor.TYPE_LIGHT)

        if (sensor == null) {
            // Display a toast message if the sensor is not connected
            Toast.makeText(this, "Light sensor is not available or not connected", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onResume() {
        super.onResume()
        sensorManager?.registerListener(this, sensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onSensorChanged(event: SensorEvent?){
        try {
            if (event != null) {
                Log.d(javaClass.simpleName, "OnSensorChanged: ${event.values[0]}")

                if (event.values[0] < 30) {
                    // light is dim
                    image.visibility = View.INVISIBLE
                    background.setBackgroundColor(resources.getColor(R.color.black))
                } else {
                    image.visibility = View.VISIBLE
                    background.setBackgroundColor(resources.getColor(R.color.yellow))
                }
            } else {
                Log.e(javaClass.simpleName, "Sensor event is null")
            }
        } catch (e: Exception){
            Log.e(javaClass.simpleName, "Error in onSensorChanged: ${e.message}", e)
        }
    }


    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        TODO("Not yet implemented")
    }

    override fun onPause() {
        super.onPause()
        sensorManager?.unregisterListener(this)
    }
}