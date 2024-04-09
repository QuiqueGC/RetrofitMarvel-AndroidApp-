package com.example.retrofitmarvel.ui.list_fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.retrofitmarvel.R
import com.example.retrofitmarvel.data.domain.model.hero.HeroModel
import com.example.retrofitmarvel.databinding.ItemHeroBinding

class HeroAdapter(
    private val context: Context,
    private val dataSet: MutableList<HeroModel>,
    private val listener: CellClickListener
) :
    RecyclerView.Adapter<HeroAdapter.ViewHolder>() {

    interface CellClickListener {
        fun onCellClick(heroModel: HeroModel)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemHeroBinding.bind(view)
        fun setListener(heroModel: HeroModel) {
            binding.root.setOnClickListener {
                listener.onCellClick(heroModel)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        with(holder.binding) {
            tvNameHero.text = dataSet[position].name
            tvDescriptionHero.text = dataSet[position].description
            Glide.with(context)
                .load(dataSet[position].smallThumbnailPath)
                .apply(RequestOptions().centerCrop())
                .into(imgHero)
        }
        holder.setListener(dataSet[position])
    }

    override fun getItemCount(): Int = dataSet.size

    fun refreshData(heroes: MutableList<HeroModel>) {
        dataSet.clear()
        dataSet.addAll(heroes)
        notifyDataSetChanged()
    }
}
