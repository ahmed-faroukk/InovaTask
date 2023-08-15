package com.farouk.inova_taskk.data.repository

import android.content.Context
import com.farouk.inova_taskk.domin.model.Book
import com.farouk.inova_taskk.domin.model.MockData
import com.farouk.inova_taskk.domin.repository.RepoInterface
import com.google.gson.Gson
import javax.inject.Inject

class RepoImp @Inject constructor(
   private val context: Context
) : RepoInterface {
   override suspend fun getBooks(): List<Book> {
      val inputStream = context.assets.open("mock_books.json")
      val jsonString = inputStream.bufferedReader().use { it.readText() }
      val mockData = Gson().fromJson(jsonString, MockData::class.java)
      return mockData.books

   }

}