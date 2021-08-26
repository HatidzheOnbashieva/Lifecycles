package com.raywenderlich.lifecycletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e ("Activity Main", "onCreate")
        //first;
        //Called when the activity is first created

        supportFragmentManager.beginTransaction().add(R.id.fragment, FragmentTest()).commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e ("Activity Main", "onDestroy")
        //the instance of activity is completely removed
        //Called before the activity is destroyed by the system (either manually or by the system to conserve memory)

    }

    override fun onStart() {
        super.onStart()
        Log.e ("Activity Main", "onStart")
        //second; became visible
        //Called when the activity becomes visible to the user
    }

    override fun onStop() {
        super.onStop()
        Log.e ("Activity Main", "onStop")
        //it is invisible
        //Called when the activity is no longer visible to the user
    }

    override fun onResume() {
        super.onResume()
        Log.e ("Activity Main", "onResume")
        //third; became fully visible; user can start interaction
        //Called when the activity starts interacting with the user
    }

    override fun onPause() {
        super.onPause()
        Log.e ("Activity Main", "onPause")
        //partly visible; user cannot interact
        //Called when the current activity is being paused and the previous activity is resumed
    }

    override fun onRestart() {
        super.onRestart()
        Log.e ("Activity Main", "onRestart")
        //Called when the activity has been stopped and is restarting again
    }

}