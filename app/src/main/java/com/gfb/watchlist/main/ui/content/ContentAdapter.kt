package com.gfb.watchlist.main.ui.content

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gfb.watchlist.databinding.AdapterContentBinding
import com.gfb.watchlist.main.model.ContentModel

class ContentAdapter(
    private val listener: (ContentModel) -> Unit
) : ListAdapter<ContentModel, ContentAdapter.ViewHolder>(ContentDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, listener)
    }

    class ViewHolder private constructor(private val binding: AdapterContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(content: ContentModel, listener: (ContentModel) -> Unit) = with(binding) {
            binding.content = content
            binding.executePendingBindings()
            binding.root.setOnClickListener { listener(content) }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)

                val binding =
                    AdapterContentBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

class ContentDiffCallback : DiffUtil.ItemCallback<ContentModel>() {
    override fun areItemsTheSame(oldItem: ContentModel, newItem: ContentModel): Boolean {
        return oldItem.imdbID == newItem.imdbID
    }

    override fun areContentsTheSame(oldItem: ContentModel, newItem: ContentModel): Boolean {
        return oldItem == newItem
    }
}