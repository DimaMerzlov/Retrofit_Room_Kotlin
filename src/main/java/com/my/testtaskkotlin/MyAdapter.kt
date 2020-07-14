package com.my.testtaskkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.my.testtaskkotlin.db.Profile
import com.squareup.picasso.Picasso


class MyAdapter() :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var profileList: List<Profile> = ArrayList()
    private lateinit var mListener: OnItemClickListener;
    private lateinit var context: Context

    inner class MyViewHolder(itemView: View, var mListener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val textViewName = itemView.findViewById(R.id.textViewName) as TextView
        val imageViewPhoto = itemView.findViewById(R.id.imageViewPhoto) as ImageView

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            if (mListener != null) {
                mListener.setOnClickListener(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        context = parent.context
        return MyViewHolder(v, mListener)
    }

    override fun getItemCount(): Int {
        return profileList.size
        //20
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val profile: Profile = profileList[position]

        holder.textViewName.text = profile._name
        println(profile._name)
        Picasso.with(context).load(profile._imageURL).into(holder.imageViewPhoto)
        println(profile._imageURL)
        //
    }

    interface OnItemClickListener {
        fun setOnClickListener(position: Int)
    }

    fun setOnItemClickListener(mListener: OnItemClickListener) {
        this.mListener = mListener
    }
    fun setListProfiles(it: List<Profile>) {
        profileList=it
        notifyDataSetChanged()
    }
}