package com.farouk.inova_taskk.presentation.base.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.farouk.inova_taskk.databinding.BookItemBinding
import com.farouk.inova_taskk.domin.model.Book

// BookAdapter.kt
class BookAdapter(private val books: List<Book>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = BookItemBinding.inflate(inflater, parent, false)
        return BookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.bind(book)
    }

    override fun getItemCount() = books.size

    class BookViewHolder(private val binding: BookItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) {
            binding.titleTextView.text = book.title
            binding.authorTextView.text = book.author
        }
    }
}
