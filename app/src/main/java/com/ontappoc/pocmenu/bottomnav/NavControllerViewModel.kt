package com.ontappoc.pocmenu.bottomnav

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class NavControllerViewModel : ViewModel() {
    val currentNavController = MutableLiveData<NavController?>()
}
