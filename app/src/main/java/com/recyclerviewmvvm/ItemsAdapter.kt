@file:JvmName("ItemsAdapter")

package com.recyclerviewmvvm


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.recyclerviewmvvm.databinding.ItemViewBinding


class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    private var items: List<Movie> = emptyList()

    private val loading = 0
    private val item = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {



        return ItemViewHolder(parent)

    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is ItemViewHolder && items.size > position) {

            holder.bind(items[position])
        }
    }

    fun update(items: List<Movie>) {
        this.items = items
        notifyDataSetChanged()
    }

    fun addItem(items_: List<Movie>) {

        this.items = this.items + items_
        notifyDataSetChanged()

    }

    companion object {
        @JvmStatic
        @BindingAdapter("items")
        fun RecyclerView.bindItems(items: List<Movie>) {
            val adapter = adapter as ItemsAdapter
            adapter.update(items)
        }
    }

//    override fun getItemViewType(position: Int) =
//        if (items[position] == "loading") loading else item

    override fun getItemViewType(position: Int) =
        item

    abstract class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class ItemViewHolder(
        private val parent: ViewGroup,
        private val binding: ItemViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_view,
            parent,
            false
        )
    ) : ViewHolder(binding.root) {

        fun bind(item: Movie ) {
            binding.item = item.title
           binding.imageUrl = item.image

        }
    }





}

