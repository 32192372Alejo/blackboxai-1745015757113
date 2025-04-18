package com.example.interviewface

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

data class PracticeInterview(
    val title: String,
    val description: String,
    val imageUrl: String
)

class PracticeInterviewAdapter(private val items: List<PracticeInterview>) :
    RecyclerView.Adapter<PracticeInterviewAdapter.PracticeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PracticeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_practice_interview, parent, false)
        return PracticeViewHolder(view)
    }

    override fun onBindViewHolder(holder: PracticeViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.description.text = item.description
        Glide.with(holder.image.context)
            .load(item.imageUrl)
            .centerCrop()
            .into(holder.image)
    }

    override fun getItemCount(): Int = items.size

    class PracticeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imagePractice)
        val title: TextView = itemView.findViewById(R.id.textTitle)
        val description: TextView = itemView.findViewById(R.id.textDescription)
    }
}
