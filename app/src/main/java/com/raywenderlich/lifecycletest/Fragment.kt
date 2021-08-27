package com.raywenderlich.lifecycletest

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.raywenderlich.lifecycletest.databinding.TestFragmentLayoutBinding

class FragmentTest : Fragment() {

    private var viewBinding: TestFragmentLayoutBinding? = null
    private val viewModel: FragmentViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e ("Fragment Test", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e ("Fragment Test", "onCreateView")

        viewBinding = TestFragmentLayoutBinding.inflate(layoutInflater, container, false)
        return viewBinding?.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e ("Fragment Test", "onDestroyView")
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e ("Fragment Test", "onViewCreated")

        viewBinding?.valueText?.text = viewModel.getCount().toString()

        viewBinding?.increment?.setOnClickListener{
            //increment()
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.fragment, SecondFragment()).addToBackStack(null).commit()
        }

        viewBinding?.decrement?.setOnClickListener{
            viewModel.decrement(){
                viewBinding?.valueText?.text = it.toString()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e ("Fragment Test", "onDestroy")
    }

    override fun onStart() {
        super.onStart()
        Log.e ("Fragment Test", "onStart")
        //second; became visible
    }

    override fun onStop() {
        super.onStop()
        Log.e ("Fragment Test", "onStop")
        //it is invisible
    }

    override fun onResume() {
        super.onResume()
        Log.e ("Fragment Test", "onResume")

        //third; became fully visible; user can start interaction
    }

    override fun onPause() {
        super.onPause()
        Log.e ("Fragment Test", "onPause")
        //partly visible; user cannot interact
    }



}