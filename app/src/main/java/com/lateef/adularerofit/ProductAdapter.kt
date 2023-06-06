package com.lateef.adularerofit

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class ProductAdapter(private val context: Context, var itemList: ArrayList<ProdutdtoItem>)
    : RecyclerView.Adapter<ProductAdapter.CharacterListViewHolder>(){



    inner class CharacterListViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val productName: TextView = view.findViewById(R.id.com_name_list)
        val thumbnail: ImageView = view.findViewById(R.id.product_image)
        val brandName: TextView = view.findViewById(R.id.phone_txt)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list, parent, false)
        return CharacterListViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterListViewHolder, position: Int) {
        val list = itemList[position]
        holder.productName.text = list.brand
        holder.brandName.text = list.name


    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(productList: ArrayList<ProdutdtoItem>){
        this.itemList = productList

        notifyDataSetChanged()
    }


}