package com.dbs.employeeapplication

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dbs.employeeapplication.databinding.ItemHistoryRowBinding
import com.dbs.employeeapplication.databinding.UserHistoryRowBinding

class DashBoardAdapter(private val users: ArrayList<String>): RecyclerView.Adapter<DashBoardAdapter.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashBoardAdapter.ViewHolder {
            return DashBoardAdapter.ViewHolder(UserHistoryRowBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
        }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name: String = users.get(position)

        holder.tvPositionUser.text = (position + 1).toString()
        holder.tvItemUser.text = name
        holder.llUserHistory.setBackgroundColor(
            Color.parseColor("#EBEBEB"))
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class ViewHolder(binding: UserHistoryRowBinding) : RecyclerView.ViewHolder(binding.root) {
        val llUserHistory = binding.llUserHistory
        val tvItemUser = binding.tvItemUser
        val tvPositionUser = binding.tvPositionUser
    }


}