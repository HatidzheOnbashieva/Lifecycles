package com.raywenderlich.lifecycletest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.raywenderlich.lifecycletest.databinding.SecondFragmentBinding

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewBinding = SecondFragmentBinding.inflate(layoutInflater, container, false)
        return viewBinding.root
    }


}