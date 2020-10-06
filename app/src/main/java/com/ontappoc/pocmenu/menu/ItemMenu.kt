package com.ontappoc.pocmenu.menu

import androidx.annotation.IdRes

data class ItemMenu(
    @IdRes var idRes: Int,
    var icon: Int,
    var title: Int
)