package com.ontappoc.pocmenu.bottomnav

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.dynamicfeatures.fragment.DynamicNavHostFragment
import androidx.navigation.fragment.NavHostFragment

class NavHostContainerFragment() : Fragment() {

    private var layoutRes: Int = -1

    private var navHostFragmentId: Int = -1

    constructor(@LayoutRes layoutRes: Int, @IdRes navHostFragmentId: Int) : this() {
        this.layoutRes = layoutRes
        this.navHostFragmentId = navHostFragmentId
    }

    private val navControllerViewModel by activityViewModels<NavControllerViewModel>()

    private var navController: NavController? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (arguments?.get(KEY_RES_ID) as? Int)?.let {
            layoutRes = it
        }

        (arguments?.get(KEY_NAV_HOST_ID) as? Int)?.let {
            navHostFragmentId = it
        }

        val view = inflater.inflate(layoutRes, container, false)

        val nestedNavHostFragment =
            childFragmentManager.findFragmentById(navHostFragmentId) as? NavHostFragment

        if (nestedNavHostFragment?.navController == null)
            throw Exception(
                "This fragment should have " +
                        "a NavHostFragment with NavController"
            )

        navController = nestedNavHostFragment.navController

        return view
    }

    override fun onResume() {
        super.onResume()
        // Set this navController as ViewModel's navController
        navControllerViewModel.currentNavController.value = navController
    }

    override fun onDestroyView() {
        navController = null
        navControllerViewModel.currentNavController.value = null
        super.onDestroyView()
    }

    companion object {
        const val KEY_RES_ID = "key-res-id"
        const val KEY_NAV_HOST_ID = "key-nav-host-id"
        const val DEFAULT_LAYOUT_ID = "default"

        @JvmStatic
        fun createNavHostContainerFragment(
            @LayoutRes layoutRes: Int,
            @IdRes navHostFragmentId: Int,
            fragmentTag: String? = null
        ): NavHostContainerFragment {

            return NavHostContainerFragment().apply {

                arguments = Bundle().apply {
                    putInt(KEY_RES_ID, layoutRes)
                    putInt(KEY_NAV_HOST_ID, navHostFragmentId)
                }
            }
        }
    }
}