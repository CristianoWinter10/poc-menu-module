package com.ontappoc.pocmenu.menu

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ontappoc.pocmenu.R
import kotlinx.android.synthetic.main.fragment_menu_dialog.*

// TODO: Customize parameter argument names
const val ARG_ITEM_COUNT = "item_count"

/**
 *
 * A fragment that shows a list of items as a modal bottom sheet.
 *
 * You can show this modal bottom sheet from your activity like this:
 * <pre>
 *    MenuDialogFragment.newInstance(30).show(supportFragmentManager, "dialog")
 * </pre>
 */
class MenuDialogFragment() : BottomSheetDialogFragment() {

    private lateinit var itemMenuSelectedListener: ItemMenuSelectedListener

    constructor(itemMenuSelectedListener: ItemMenuSelectedListener) : this() {
        this.itemMenuSelectedListener = itemMenuSelectedListener
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_menu_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listMenuItems.adapter =
            ListMenuAdapter(itemMenuSelectedListener)

    }

    companion object {
        fun newInstance(itemMenuSelectedListener: ItemMenuSelectedListener) =
            MenuDialogFragment(itemMenuSelectedListener)

    }
}