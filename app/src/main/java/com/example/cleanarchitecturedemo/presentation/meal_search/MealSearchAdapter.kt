package com.example.cleanarchitecturedemo.presentation.meal_search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleanarchitecturedemo.databinding.ViewHolderSearchListBinding
import com.example.cleanarchitecturedemo.domain.model.Meal

/**
 * Created by Ajeet Singh on 06/06/22.
 */
class MealSearchAdapter : RecyclerView.Adapter<MealSearchAdapter.MyViewHolder>() {



    private var listener :((Meal)->Unit)?=null

    var list = mutableListOf<Meal>()

    fun setContentList(list: MutableList<Meal>) {
        this.list = list
        notifyDataSetChanged()
    }


    class MyViewHolder(val binding: ViewHolderSearchListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MealSearchAdapter.MyViewHolder {
        return MyViewHolder(ViewHolderSearchListBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    fun itemClickListener(l:(Meal)->Unit){
        listener= l
    }

    override fun onBindViewHolder(holder: MealSearchAdapter.MyViewHolder, position: Int) {
        holder.binding.meal = this.list[position]

        holder.binding.root.setOnClickListener {
            listener?.let {
                it(this.list[position])
            }
        }

    }

    override fun getItemCount(): Int {
        return this.list.size
    }
}