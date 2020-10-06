package com.ontappoc.pocmenu.bottomnav

import NavigableFragmentStateAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import com.ontappoc.pocmenu.R
import com.ontappoc.pocmenu.menu.ListMenu

class BottomNavigationFragmentStateAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    NavigableFragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = ListMenu.items.size

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> NavHostContainerFragment.createNavHostContainerFragment(
                R.layout.visit_nav_host,
                R.id.nested_nav_host_fragment_visit
            )

            1 -> NavHostContainerFragment.createNavHostContainerFragment(
                R.layout.kpi_nav_host,
                R.id.nested_nav_host_fragment_kpi
            )

            2 -> {
                NavHostContainerFragment.createNavHostContainerFragment(
                    R.layout.tasks_nav_host,
                    R.id.nested_nav_host_fragment_tasks
                )
            }

            else -> NavHostContainerFragment.createNavHostContainerFragment(
                R.layout.visit_nav_host,
                R.id.nested_nav_host_fragment_visit
            )
        }
    }
}
