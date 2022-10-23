package com.elephantstudio.odrabiamyszare.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.elephantstudio.odrabiamyszare.data.Book
import com.elephantstudio.odrabiamyszare.data.BookJSON
import com.elephantstudio.odrabiamyszare.data.BooksApi
import com.elephantstudio.odrabiamyszare.databinding.ItemBookBinding


class BookAdapter(): RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(val binding: ItemBookBinding): RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<BookJSON>() {
        override fun areItemsTheSame(oldItem: BookJSON, newItem: BookJSON): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: BookJSON, newItem: BookJSON): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var booksAPI: List<BookJSON>
        get() = differ.currentList
        set(value) {differ.submitList(value)}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {

        return BookViewHolder(ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {

        holder.binding.tvBookTitle.text = booksAPI[position].title
        holder.binding.tvBookType.text = booksAPI[position].subject
        holder.binding.tvBookPublish.text = booksAPI[position].type
    }

    override fun getItemCount(): Int {

        return booksAPI.size
    }
}
