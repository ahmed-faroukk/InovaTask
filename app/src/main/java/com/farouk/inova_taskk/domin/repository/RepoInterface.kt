package com.farouk.inova_taskk.domin.repository

import com.farouk.inova_taskk.common.Resource
import com.farouk.inova_taskk.domin.model.Book


interface RepoInterface {
    suspend fun getBooks(): List<Book>
}