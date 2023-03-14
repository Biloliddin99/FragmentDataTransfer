package com.example.fragmentdatatransfer.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragmentdatatransfer.R
import com.example.fragmentdatatransfer.SecondFragment
import com.example.fragmentdatatransfer.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFirstBinding.inflate(layoutInflater)
        binding.btnNext.setOnClickListener {
            val secondFragment = SecondFragment.newInstance(
                binding.edtName.text.toString(),
                binding.edtAge.text.toString().toInt()
            )

            parentFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.to_right,R.anim.to_left)
                .addToBackStack(secondFragment.toString())
                .replace(R.id.container, secondFragment)
                .commit()
        }

        return binding.root
    }

}