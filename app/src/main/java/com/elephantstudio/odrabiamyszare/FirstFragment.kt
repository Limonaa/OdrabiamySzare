package com.elephantstudio.odrabiamyszare

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.elephantstudio.odrabiamyszare.databinding.FragmentFirstBinding
import com.elephantstudio.odrabiamyszare.databinding.ItemBookBinding

class FirstFragment : Fragment(R.layout.fragment_first) {

    private var _binding: FragmentFirstBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        var booksList = mutableListOf(
            Book("MateMatyka 2. Zakres rozszerzony", "Podręcznik", "Nowa Era"),
            Book("Język polski w urzyciu 3.1 Zakres podstawowy", "Podręcznik", "GWO"),
            Book("Oblicza geografii 2. Zakres podstawowy", "Podręcznik", "WSiP"),
        )

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        val adapter = BookAdapter(booksList)
        binding.rvBooks.adapter = adapter
        binding.rvBooks.layoutManager = LinearLayoutManager(requireContext())

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}