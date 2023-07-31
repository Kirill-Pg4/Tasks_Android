package com.example.middle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.middle.model.User

class UserAdapter(private val users: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_item_user, parent, false)
        return UserViewHolder(itemView)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        with(holder.itemView) {
            findViewById<TextView>(R.id.Name_Card).text = user.Name
            findViewById<TextView>(R.id.Age_Card).text = user.Age.toString()
            findViewById<Switch>(R.id.isStudent_Card).isChecked = user.isStudent

            findViewById<Switch>(R.id.isStudent_Card).setOnCheckedChangeListener { _: CompoundButton, isChecked: Boolean ->
                user.isStudent = isChecked
            }
        }
    }
}
