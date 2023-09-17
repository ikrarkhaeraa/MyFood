package com.example.folkatech

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.folkatech.databinding.FragmentBottomNavBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomNavFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentBottomNavBinding? = null
    val binding get() = _binding!!

    companion object {
        const val TAG = "ModalBottomSheet"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBottomNavBinding.inflate(inflater, container, false)
        return binding.root
    }

}