package com.example.arsee

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(listArray: ArrayList<ListItem>, context: Context): RecyclerView.Adapter<ChatAdapter.ViewHolder>() {

    var listArrayR = listArray
    var contextR = context
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val tvname = view.findViewById<TextView>(R.id.user_name)
        val tvtime = view.findViewById<TextView>(R.id.user_time)
        val user_foto = view.findViewById<ImageView>(R.id.user_foto)

        fun bind(listItem: ListItem, context: Context){
            tvname.text = listItem.name_id
            tvtime.text = listItem.time_id
            user_foto.setImageResource(listItem.image_id)
            itemView.setOnClickListener {
                Toast.makeText(context,"Hello", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.chat_item, parent, false))
    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItem = listArrayR.get(position)
        holder.bind(listItem, contextR)
    }
}