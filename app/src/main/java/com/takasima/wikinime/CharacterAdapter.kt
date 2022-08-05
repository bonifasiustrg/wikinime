package com.takasima.wikinime

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*

class CharacterAdapter: RecyclerView.Adapter<CharacterAdapter.ListViewHolder>() {

    private lateinit var onItemClickListener: OnItemClickListener
    private val listCharacter = ArrayList<Character>()

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.onItemClickListener = onItemClickListener
    }

    fun setData(itemData: ArrayList<Character>) {
        listCharacter.clear()
        listCharacter.addAll(itemData)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(character: Character) {
            with(itemView) {
                Glide.with(context).load(character.photo).into(item_list_image)
                item_list_name.text = character.name
                item_list_genre.text = character.detail
                itemView.setOnClickListener {
                    onItemClickListener.onItemClicked(listCharacter[adapterPosition])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterAdapter.ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listCharacter.size

    override fun onBindViewHolder(holder: CharacterAdapter.ListViewHolder, position: Int) {
        holder.bind(listCharacter[position])
    }

    interface OnItemClickListener {
        fun onItemClicked(character: Character)
    }
}