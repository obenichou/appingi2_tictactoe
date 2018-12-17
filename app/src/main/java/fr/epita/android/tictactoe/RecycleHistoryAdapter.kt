package fr.epita.android.tictactoe

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView

class RecycleHistoryAdapter(val data: List<History>) : RecyclerView.Adapter<RecycleHistoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val rowView = LayoutInflater.from(parent.context).inflate(R.layout.row_result, parent, false)
        return ViewHolder(rowView)
    }

    override fun getItemCount(): Int { return data.size   }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val currentItem = data[position]
        viewHolder.playername.text = currentItem.player
        viewHolder.dateres.text = currentItem.date
        when(currentItem.result) {
            1 -> viewHolder.res_img.setImageResource(R.drawable.ic_thumb_down)
            3 -> viewHolder.res_img.setImageResource(R.drawable.ic_thumb_up)
            2 -> viewHolder.res_img.setImageResource(R.drawable.ic_thumb_up)
        }
        viewHolder.itemView.tag = position
    }
    class ViewHolder(rowView : View) : RecyclerView.ViewHolder(rowView) {
        val playername = rowView.findViewById<TextView>(R.id.player_name_result_row)
        val res_img = rowView.findViewById<ImageView>(R.id.result_view_image_result)
        val dateres = rowView.findViewById<TextView>(R.id.result_view_date)
    }
}
