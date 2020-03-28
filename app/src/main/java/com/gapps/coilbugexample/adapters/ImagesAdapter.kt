package com.gapps.coilbugexample.adapters

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gapps.coilbugexample.R
import com.gapps.coilbugexample.coil.loadImage
import kotlinx.android.synthetic.main.item_image.view.*
import java.util.*


class ImagesAdapter(private val listener: Listener) : RecyclerView.Adapter<ImagesAdapter.Holder>() {

	private var data: MutableList<String> = mutableListOf()

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
		return Holder(
				LayoutInflater.from(parent.context)
						.inflate(R.layout.item_image, parent, false)
		)
	}

	override fun getItemCount() = data.size

	override fun onBindViewHolder(holder: Holder, position: Int) = holder.bind(data[position], listener)

	fun swapData(data: List<String>) {
		this.data.clear()
		this.data.addAll(data)
		notifyDataSetChanged()
	}

	fun addData(data: List<String>) {
		this.data.addAll(data)
		notifyDataSetChanged()
	}

	class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
		fun bind(item: String, listener: Listener) = with(itemView) {

			hc_image.loadImage(item)
			setOnClickListener {
				listener.onItemClick(item)
			}
		}
	}

	interface Listener {
		fun onItemClick(item: String)
	}
}