package com.yvkalume.tinderswipe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yvkalume.tinderswipe.databinding.SwipeItemBinding

class ProfileAdapter : ListAdapter<Profile, ProfileAdapter.CustomViewHolder>(Companion) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = SwipeItemBinding.inflate(layoutInflater,parent,false)
        return CustomViewHolder(binding)
    }


    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentProfile = getItem(position)
        val binding= holder.binding
        binding.profil = currentProfile
        binding.imageProfil.setImageResource(currentProfile.image)
    }

    companion object : DiffUtil.ItemCallback<Profile>() {
        override fun areItemsTheSame(oldItem: Profile, newItem: Profile): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Profile, newItem: Profile): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class CustomViewHolder(val binding: SwipeItemBinding) : RecyclerView.ViewHolder(binding.root)
}