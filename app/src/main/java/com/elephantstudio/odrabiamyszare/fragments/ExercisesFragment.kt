package com.elephantstudio.odrabiamyszare.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.elephantstudio.odrabiamyszare.databinding.FragmentExercisesBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ExercisesFragment : Fragment() {

    private var _binding: FragmentExercisesBinding? = null
    private val binding get() = _binding!!

    val args: ExercisesFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        _binding = FragmentExercisesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val book = args.book
        binding.tvBookInformation.text = "${book.title},  ${book.subject}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}