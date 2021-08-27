package com.raywenderlich.lifecycletest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.raywenderlich.lifecycletest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var viewBinding: ActivityMainBinding? = null
    private var count: Int = 0
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding?.root)
        Log.e ("Activity Main", "onCreate")

        //first;
        //Called when the activity is first created

        if(supportFragmentManager.fragments.isEmpty()) {
            supportFragmentManager.beginTransaction().add(R.id.fragment, FragmentTest()).commit()
        }

//        viewBinding?.increment?.setOnClickListener{
//            increment()
//        }
//
//        viewBinding?.decrement?.setOnClickListener{
//            decrement()
//        }
//
//        if(savedInstanceState != null){
//            count = savedInstanceState.getInt("count")
//            //viewBinding?.valueText?.text = count.toString()
//        }
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putInt("count", count)
//        Log.e("Activity Main", "onSaveInstanceState")
//
//    }

    //the onRestoreInstanceState() is not mandatory because we have a savedInstanceState Bundle in onCreate() method too and we can directly use it there
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if(savedInstanceState != null){
            count = savedInstanceState.getInt("count")
            //viewBinding?.valueText?.text = count.toString()
        }
        Log.e("Activity Main", "onRestoreInstanceState")
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

//    private fun increment(){
//        count++
//        viewBinding?.valueText?.text = count.toString()
//    }
//
//
//    private fun decrement(){
//        count--
//        viewBinding?.valueText?.text = count.toString()
//    }

}