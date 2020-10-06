package com.ontappoc.pocmenu.menu

import androidx.annotation.IdRes

interface ItemMenuSelectedListener {
    fun onItemSelected(@IdRes item: Int)
}