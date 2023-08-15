package com.farouk.inova_taskk.domin.usecase

import com.farouk.inova_taskk.common.Resource
import com.farouk.inova_taskk.domin.model.Book
import com.farouk.inova_taskk.domin.repository.RepoInterface
import javax.inject.Inject

class GetDataUseCase @Inject constructor(
   private val repo : RepoInterface
) {
    suspend operator fun invoke(): List<Book> {
        return repo.getBooks()
    }
}