package com.elephantstudio.odrabiamyszare.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import com.elephantstudio.odrabiamyszare.R
import com.elephantstudio.odrabiamyszare.databinding.FragmentSecondBinding
import com.elephantstudio.odrabiamyszare.databinding.PagePickerDialogBinding
import com.google.android.material.tabs.TabLayout

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


        val pagePickerDialog = Dialog(requireContext())
        val dialogBinding = PagePickerDialogBinding.inflate(LayoutInflater.from(requireContext()))
        var pageList = intArrayOf(1,2,3,4,5,6,7)

        var pageListString = pageList.map { it.toString() }.toTypedArray()



        var exerciseNumbers = listOf<Int>(1,2,3,4,5,6,7,8)

        exerciseNumbers.forEach{
            binding.tabLayout.addTab(binding.tabLayout.newTab().setText(it.toString()))
        }


       binding.tabLayout.addOnTabSelectedListener(OnTabSelectedListener())



       var pageValue = pageList[0]
       binding.bookPageTv.text = pageValue.toString()
        var buttonRemove = binding.buttonRemove
        var buttonAdd = binding.buttonAdd


        buttonAdd.setOnClickListener{
            pageValue++
            binding.bookPageTv.text = pageValue.toString()
        }


        buttonRemove.setOnClickListener {
            pageValue--
            binding.bookPageTv.text = pageValue.toString()
        }

        binding.bookPageTv.setOnClickListener {
            pagePickerDialog.show()
            pagePickerDialog.setContentView(dialogBinding.root)

        }

        dialogBinding.numberPicker.setMinValue(1);
        dialogBinding.numberPicker.setMaxValue(pageList.size)
        dialogBinding.numberPicker.setDisplayedValues(pageListString)
        dialogBinding.dialogButton.setOnClickListener {
            pageValue = dialogBinding.numberPicker.getValue()
            binding.bookPageTv.text = pageValue.toString()
            pagePickerDialog.dismiss()
        }













    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private class OnTabSelectedListener: TabLayout.OnTabSelectedListener{
    override fun onTabSelected(tab: TabLayout.Tab?) {
        val tabName = tab?.text

    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {}

    override fun onTabReselected(tab: TabLayout.Tab?) {}

}