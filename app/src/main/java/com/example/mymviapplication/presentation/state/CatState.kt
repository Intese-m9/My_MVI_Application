package com.example.mymviapplication.presentation.state

import com.example.mymviapplication.data.model.modelCat.Cats

sealed class CatState {
    data class Success(val cats: Cats): CatState()
    data class Error(val message: String): CatState()
    object Loading: CatState()
}