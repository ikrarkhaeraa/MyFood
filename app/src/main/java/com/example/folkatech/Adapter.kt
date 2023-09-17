package com.example.folkatech

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.folkatech.databinding.ItemRvBinding
import com.squareup.picasso.Picasso
import java.text.NumberFormat
import java.util.Locale

class Adapter(
    private val listProduct: List<ResponseData>,
    private val onProductClick: (ResponseData) -> Unit
) : RecyclerView.Adapter<Adapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val binding = ItemRvBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listProduct.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (productId, productName, productCover, ProductDesc, productPrice) = listProduct[position]
        Picasso.get().load(productCover).into(holder.binding.itemImage)
        holder.binding.itemTitle.text = productName
        holder.binding.itemPrice.text = productPrice.toString()


        holder.itemView.setOnClickListener {
            onProductClick(listProduct[position])
        }

    }

    class ListViewHolder(var binding: ItemRvBinding) : RecyclerView.ViewHolder(binding.root)

//    private fun formatPrice(price: Double): String {
//        val numberFormat = NumberFormat.getNumberInstance(
//            Locale(
//                "id",
//                "ID"
//            )
//        )
//        return numberFormat.format(price)
//    }

//    interface OnItemClickListener {
//        fun onItemClick(position: Int, item: CheckoutDataClass)
//    }


}