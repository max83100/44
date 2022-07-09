package com.express.android.stevdzaroom.fragments.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.express.android.stevdzaroom.model.User
import com.express.android.stevdzaroom.databinding.CustomRowBinding

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            CustomRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]

        //holder.binding.idTxt.text = currentItem.id.toString()
        holder.binding.apply {
            idTxt.text = currentItem.id.toString()
            firstNameTxt.text = currentItem.firstName.toString()
            lastNameTxt.text = currentItem.lastName.toString()
            ageTxt.text = currentItem.age.toString()
        }

        holder.binding.rowLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }

    class MyViewHolder(val binding: CustomRowBinding): RecyclerView.ViewHolder(binding.root)
}