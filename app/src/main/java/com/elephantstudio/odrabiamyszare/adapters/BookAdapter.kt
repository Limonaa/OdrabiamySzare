package com.elephantstudio.odrabiamyszare.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.elephantstudio.odrabiamyszare.R
import com.elephantstudio.odrabiamyszare.data.Book
import com.elephantstudio.odrabiamyszare.databinding.ItemBookBinding



class BookAdapter(): RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    inner class BookViewHolder(val binding: ItemBookBinding): RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var books: List<Book>
        get() = differ.currentList
        set(value) {differ.submitList(value)}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {

        return BookViewHolder(ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {

        holder.binding.tvBookTitle.text = books[position].title
        holder.binding.tvBookType.text = books[position].subject
        holder.binding.tvBookPublish.text = books[position].type
        holder.binding.tvIconLetter.text = books[position].title.first().toString()
        val fragmentContext = holder.binding.vShape.context
        holder.binding.vShape.backgroundTintList = AppCompatResources.getColorStateList(fragmentContext, R.color.green)

        holder.binding.root.setOnClickListener {
            onItemClickListener?.let {
                it(books[position])
            }
        }
    }

    override fun getItemCount(): Int {

        return books.size
    }

    private var onItemClickListener: ((Book) -> Unit)? = null

    fun setOnItemClickListener(listener: (Book) -> Unit) {
        onItemClickListener = listener
    }
}
