package com.yusuf.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yusuf.core.R
import com.yusuf.core.databinding.ItemClubBinding
import com.yusuf.core.domain.Club


class ClubAdapter : RecyclerView.Adapter<ClubAdapter.ListViewHolder>() {

    private var listClub = ArrayList<Club>()
    var onItemClick: ((Club) -> Unit)? = null

    fun setData(newListClub: List<Club>?) {
        if (newListClub == null) return
        listClub.clear()
        listClub.addAll(newListClub)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_club, parent, false))

    override fun getItemCount() = listClub.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val club = listClub[position]
        holder.bind(club)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemClubBinding.bind(itemView)
        fun bind(club: Club) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(club.logo)
                    .into(clubLogo)
                clubName.text = club.name
            }
        }
            init {
                binding.root.setOnClickListener {
                    @Suppress("DEPRECATION")
                    onItemClick?.invoke(listClub[adapterPosition])
                }
            }
    }
}