package com.smoothbear.app.viewmodel.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.smoothbear.app.network.CocktailService
import com.smoothbear.app.network.dto.CocktailData
import com.smoothbear.app.network.dto.CocktailResponse
import com.smoothbear.app.viewmodel.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailViewModel @Inject constructor (
    private val cocktailService: CocktailService
) : BaseViewModel() {

    private val _cocktailData = MutableLiveData<CocktailData>()
    val cocktailData: LiveData<CocktailData>
        get() = _cocktailData

    private val _cocktailResponse = MutableLiveData<CocktailResponse>()
    val cocktailResponse: LiveData<CocktailResponse>
        get() = _cocktailResponse

    fun getCocktailInfo(id: Int) = uiScope.launch {
        val result = cocktailService.getCocktailById(id)
        _cocktailData.value = result
    }

    fun getCocktailResponse(page: Int) = uiScope.launch {
        val result = cocktailService.getCocktailList(page)
        _cocktailResponse.value = result
    }
}