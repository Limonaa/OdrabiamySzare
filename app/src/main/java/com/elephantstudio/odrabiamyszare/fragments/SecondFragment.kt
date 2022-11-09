package com.elephantstudio.odrabiamyszare.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.fragment.findNavController
import com.elephantstudio.odrabiamyszare.R
import com.elephantstudio.odrabiamyszare.databinding.FragmentSecondBinding
import com.google.android.material.internal.ContextUtils.getActivity
import com.google.android.material.tabs.TabLayout
import kotlinx.coroutines.NonCancellable.message

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        var exerciseNumbers = listOf<Int>(1,2,3,4,5,6,7,8)

        exerciseNumbers.forEach{
            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(it.toString()))
        }

       binding.tabLayout.addOnTabSelectedListener(OnTabSelectedListener())







    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private class OnTabSelectedListener: TabLayout.OnTabSelectedListener{
    override fun onTabSelected(tab: TabLayout.Tab?) {
        val tabName = tab?.text
        Toast.makeText(requireActivity(), tabName, Toast.LENGTH_LONG).show();
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {}

    override fun onTabReselected(tab: TabLayout.Tab?) {}

}