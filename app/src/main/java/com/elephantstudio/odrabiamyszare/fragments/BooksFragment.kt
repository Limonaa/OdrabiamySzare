package com.elephantstudio.odrabiamyszare.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.elephantstudio.odrabiamyszare.adapters.BookAdapter
import com.elephantstudio.odrabiamyszare.R
import com.elephantstudio.odrabiamyszare.RetrofitInstance
import com.elephantstudio.odrabiamyszare.databinding.FragmentBooksBinding
import retrofit2.HttpException
import java.io.IOException

const val TAG = "BooksFragment"

class FirstFragment : Fragment(R.layout.fragment_books) {

    private var _binding: FragmentBooksBinding? = null

    private val binding get() = _binding!!

    private lateinit var booksAdapter: BookAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBooksBinding.inflate(inflater, container, false)
        setupRecyclerView()


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        booksAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("book", it)
            }
            findNavController().navigate(
                R.id.action_BooksFragment_to_ExercisesFragment,
                bundle
            )
        }

        lifecycleScope.launchWhenCreated {
            val response = try {
                RetrofitInstance.api.getBooks()
            } catch(e: IOException) {
                Log.e(TAG, "IOException, you might not have internet connection")
                return@launchWhenCreated
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException, unexpected response")
                return@launchWhenCreated
            }
            if(response.isSuccessful && response.body() != null) {
                booksAdapter.books = response.body()!!
            } else {
                Log.e(TAG, "Response not successful")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupRecyclerView() = binding.rvBooks.apply {
        booksAdapter = BookAdapter()
        adapter = booksAdapter
        layoutManager = LinearLayoutManager(requireContext())
    }
}