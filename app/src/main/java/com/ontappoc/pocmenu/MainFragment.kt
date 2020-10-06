package com.ontappoc.pocmenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.navigation.fragment.findNavController
import com.ontappoc.pocmenu.bottomnav.BottomNavigationFragmentStateAdapter
import com.ontappoc.pocmenu.bottomnav.DynamicNavigationFragment
import com.ontappoc.pocmenu.menu.ItemMenuSelectedListener
import com.ontappoc.pocmenu.menu.MenuDialogFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : DynamicNavigationFragment(),
    ItemMenuSelectedListener {

    private lateinit var menuDialogFragment: MenuDialogFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

         menuDialogFragment = MenuDialogFragment.newInstance(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager.isUserInputEnabled = false
        viewPager.adapter =
            BottomNavigationFragmentStateAdapter(
                childFragmentManager,
                viewLifecycleOwner.lifecycle
            )
        bottomNav.setOnNavigationItemSelectedListener {

            when (it.itemId) {

                R.id.visit_nav_graph -> {
                    viewPager.setCurrentItem(0, false)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.kpi_nav_graph -> {
                    viewPager.setCurrentItem(1, false)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.menu_dynamic_nav_graph -> {

                    menuDialogFragment.show(childFragmentManager, "menuDialogFragment")


//                    viewPager.setCurrentItem(2, false)
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.tasks_nav_graph -> {
                    viewPager.setCurrentItem(2, false)
                    return@setOnNavigationItemSelectedListener true
                }

                else -> {
                    return@setOnNavigationItemSelectedListener true
                }
            }
        }
        false
    }

    override fun onDestroyView() {
        viewPager?.let {
            it.adapter = null
        }

        super.onDestroyView()
    }


    override fun onItemSelected(@IdRes item: Int) {
        bottomNav.selectedItemId = item
    }
}
