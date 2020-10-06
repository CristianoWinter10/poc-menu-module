package com.ontappoc.pocmenu.menu

import com.ontappoc.pocmenu.R

class ListMenu {
    companion object {
        val items: ArrayList<ItemMenu>
            get() {
                return arrayListOf(
                    ItemMenu(
                        R.id.visit_nav_graph,
                        android.R.drawable.ic_dialog_map,
                        R.string.visit
                    ),
                    ItemMenu(
                        R.id.kpi_nav_graph,
                        android.R.drawable.ic_menu_agenda,
                        R.string.kpi
                    ),
                    ItemMenu(
                        R.id.tasks_nav_graph,
                        android.R.drawable.ic_menu_edit,
                        R.string.tasks
                    )
                )
            }
    }
}