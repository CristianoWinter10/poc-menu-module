package com.ontappoc.pocmenu.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ontappoc.pocmenu.databinding.FragmentMenuDialogItemBinding

class ListMenuAdapter(private val itemMenuSelectedListener: ItemMenuSelectedListener) :
    RecyclerView.Adapter<ListMenuAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(
            parent,
            itemMenuSelectedListener
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = ListMenu.items[position]
        holder.bind(item)
    }


    override fun getItemCount(): Int {
        return ListMenu.items.size
    }

    class ViewHolder private constructor(
        private val binding: FragmentMenuDialogItemBinding,
        private val itemMenuSelectedListener: ItemMenuSelectedListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemMenu) {
            binding.menuItem = item
            binding.executePendingBindings()
            binding.buttonMenu.setOnClickListener {
                itemMenuSelectedListener.onItemSelected(item.idRes)
            }
        }

        companion object {
            fun from(
                parent: ViewGroup,
                itemMenuSelectedListener: ItemMenuSelectedListener
            ): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = FragmentMenuDialogItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(
                    binding,
                    itemMenuSelectedListener
                )
            }
        }
    }
}

