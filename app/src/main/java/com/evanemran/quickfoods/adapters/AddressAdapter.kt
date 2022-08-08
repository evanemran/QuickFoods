package com.evanemran.quickfoods.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.evanemran.quickfoods.R
import com.evanemran.quickfoods.listeners.ClickListener
import com.evanemran.quickfoods.models.Address
import com.evanemran.quickfoods.models.PaymentChannels


class AddressAdapter (val context: Context, val selectedAddress: Address,
                      val list: List<Address>, val listener: ClickListener<Address>)
    : RecyclerView.Adapter<AddressViewHolder>(){
    private var selectedPos = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.list_address, parent, false)
        return AddressViewHolder(layout)
    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        selectedPos = getSelectedPos()
        val item = list[holder.adapterPosition]

//        holder.imageView_paySelected.visibility = (
//            if (selectedPos == holder.adapterPosition) View.VISIBLE
//            else View.GONE
//        )

        holder.textView_address.setText(item.addressName)
//        holder.imageView_payChannel.setImageResource(item.pIcon)


        holder.address_container.setOnClickListener {
//            holder.imageView_paySelected.visibility = View.VISIBLE
//            listener.onClicked(item)
//            //                holder.textView_cat.setBackgroundColor(Color.parseColor("#4694E3"));
//            notifyItemChanged(selectedPos)
//            selectedPos = holder.adapterPosition
//            notifyItemChanged(selectedPos)
        }
    }

    private fun getSelectedPos(): Int {
        list.forEachIndexed { index, element ->
//            if (element.pName == selectedChannel.pName){
//                selectedPos = index
//            }
        }

        return selectedPos

    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class AddressViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView_address: ImageView
    var textView_address: TextView
    var radioButton_address: RadioButton
    var address_container: LinearLayout

    init {
        imageView_address = itemView.findViewById(R.id.imageView_address)
        textView_address = itemView.findViewById(R.id.textView_address)
        radioButton_address = itemView.findViewById(R.id.radioButton_address)
        address_container = itemView.findViewById(R.id.address_container)
    }
}