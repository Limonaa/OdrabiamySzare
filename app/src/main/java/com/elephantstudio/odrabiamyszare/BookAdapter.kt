package com.elephantstudio.odrabiamyszare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elephantstudio.odrabiamyszare.databinding.ActivityMainBinding
import com.elephantstudio.odrabiamyszare.databinding.ItemBookBinding


class BookAdapter(
    var books: List<Book>
): RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(val binding: ItemBookBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {

        return BookViewHolder(ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {

        holder.binding.tvBookTitle.text = books[position].title
        holder.binding.tvBookType.text = books[position].type
        holder.binding.tvBookPublish.text = books[position].publish
    }

    override fun getItemCount(): Int {

        return books.size
    }
}
