package com.raywenderlich.lifecycletest

import android.os.Handler
import androidx.lifecycle.ViewModel

class FragmentViewModel : ViewModel() {

    private var count: Int = 0

    fun increment(){
        count++
    }

    fun decrement(callback: (Int) -> Unit){
        Handler().postDelayed({
            count--
            callback.invoke(count)
        },1000)
    }

    fun getCount() = count
}