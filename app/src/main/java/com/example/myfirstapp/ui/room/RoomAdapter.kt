package com.example.myfirstapp.ui.room

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapp.data.model.room.RoomItemModel
import com.example.myfirstapp.databinding.ItemRoomBinding

class RoomAdapter(
    val data: ArrayList<RoomItemModel>,
) : RecyclerView.Adapter<RoomAdapter.RoomViewHolder>() {

    inner class RoomViewHolder(val binding: ItemRoomBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomAdapter.RoomViewHolder {
        return RoomViewHolder(
            ItemRoomBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: RoomAdapter.RoomViewHolder, position: Int) {

        holder.binding.apply {
            val room = data[position]
            tvRoomId.text = "Room ${room.id}"
            tvRoomMax.text = "Max capacity ${room.maxOccupancy.toString()}"
            if (room.isOccupied == false){
                btnEnter.text = "occupied"
                btnEnter.setTextColor(Color.RED)
            }else{
                btnEnter.text = "open"
                btnEnter.setTextColor(Color.GREEN)
            }

        }
    }
}