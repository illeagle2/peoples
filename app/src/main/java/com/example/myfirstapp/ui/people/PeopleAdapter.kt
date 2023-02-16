package com.example.myfirstapp.ui.people

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myfirstapp.R
import com.example.myfirstapp.data.model.people.PeopleItemModel
import com.example.myfirstapp.databinding.ItemPeopleBinding
import com.example.myfirstapp.ui.people.PeopleFragmentDirections.ActionNavigationHomeToPeopleDetailFragment

class PeopleAdapter(
    val data: ArrayList<PeopleItemModel>,
    val function: (PeopleItemModel) -> Unit
) : RecyclerView.Adapter<PeopleAdapter.ViewHolder>() {

    inner class ViewHolder(val view: ItemPeopleBinding) : RecyclerView.ViewHolder(view.root) {

        fun initUI(peopleItemModel: PeopleItemModel) {
            //data -> peopleItemModel
            //UI -> view

            view.tvTitle.text = "${peopleItemModel.firstName} ${peopleItemModel.lastName}"
            view.tvDesc.text = peopleItemModel.jobtitle
            with(itemView) {
                Glide.with(context)
                    .load(peopleItemModel.avatar)
                    .placeholder(R.drawable.animate_loading)
                    .centerCrop()
                    .into(view.ivProfilePic)
                view.ivProfilePic.setOnClickListener {
                    //  function.invoke(peopleItemModel)
                    val action2 = PeopleFragmentDirections.actionNavigationHomeToPeopleDetailFragment(peopleItemModel.toString())
                    findNavController().navigate(action2)
                    //Toast.makeText(context, "${peopleItemModel.firstName} Clicked", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemPeopleBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )


    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.initUI(data[position])
    }

}
