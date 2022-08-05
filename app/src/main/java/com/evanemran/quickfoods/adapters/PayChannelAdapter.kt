package com.evanemran.quickfoods.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.evanemran.quickfoods.R
import com.evanemran.quickfoods.listeners.ClickListener
import com.evanemran.quickfoods.models.*
import com.squareup.picasso.Picasso


class PayChannelAdapter (val context: Context, val list: List<PaymentChannels>, val listener: ClickListener<PaymentChannels>)
    : RecyclerView.Adapter<PayChannelViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PayChannelViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.list_paychannel, parent, false)
        return PayChannelViewHolder(layout)
    }

    override fun onBindViewHolder(holder: PayChannelViewHolder, position: Int) {
        val item = list[holder.adapterPosition]

        holder.textView_payChannel.setText(item.pName)
        holder.imageView_payChannel.setImageResource(item.pIcon)


        holder.radioButton_payChannel.setOnClickListener {
            listener.onClicked(item)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class PayChannelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView_payChannel: ImageView
    var textView_payChannel: TextView
    var radioButton_payChannel: RadioButton

    init {
        imageView_payChannel = itemView.findViewById(R.id.imageView_payChannel)
        textView_payChannel = itemView.findViewById(R.id.textView_payChannel)
        radioButton_payChannel = itemView.findViewById(R.id.radioButton_payChannel)
    }
}