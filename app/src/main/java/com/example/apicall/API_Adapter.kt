package com.example.apicall

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class API_Adapter(var  datalist :ArrayList<UserModelItem>):RecyclerView.Adapter<API_Adapter.ApiHolder>() {

    lateinit var context: Context


    class ApiHolder(itemView: View) : ViewHolder(itemView) {
        var tv1 = itemView.findViewById<TextView>(R.id.tv1)
        var tv2 = itemView.findViewById<TextView>(R.id.tv2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiHolder {
          context = parent.context
            var view = LayoutInflater.from(parent.context).inflate(R.layout.recy_api,parent,false)
            return ApiHolder(view)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: ApiHolder, position: Int) {
        holder.tv1.text = datalist.get(position).userId.toString()
        holder.tv2.text = datalist.get(position).title

                }

    fun setData(list: ArrayList<UserModelItem>) {
        this.datalist = list
    }
}
