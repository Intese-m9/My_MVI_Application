package com.example.mymviapplication.domain.usecase

import com.example.mymviapplication.data.model.modelCat.Cats
import com.example.mymviapplication.data.MainRepository
import javax.inject.Inject

class GetCatsDataUseCase @Inject constructor(private val mainRepository: MainRepository){
    suspend fun getCatsList(): Cats {
        return mainRepository.getCats()
    }
}