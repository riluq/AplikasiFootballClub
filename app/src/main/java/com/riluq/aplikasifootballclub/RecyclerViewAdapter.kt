package com.riluq.aplikasifootballclub

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class RecyclerViewAdapter(private val items: List<Item>, private val listener: (Item) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ClubUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    class ClubUI : AnkoComponent<ViewGroup> {
        override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {

            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)
                orientation = LinearLayout.HORIZONTAL

                imageView {
                    id = R.id.reservedImageId
                }.lparams(
                        width = dip(50),
                        height = dip(50)
                )

                textView {
                    id = R.id.reservedNamedId
                    textSize = 16f
                }.lparams {
                    margin = dip(15)
                }
            }
        }

    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){

        private val name= view.find<TextView>(R.id.reservedNamedId)
        private val image= view.find<ImageView>(R.id.reservedImageId)

        fun bindItem(items: Item, listener: (Item) -> Unit) {
            name.text = items.name
            Glide.with(itemView.context).load(items.image).into(image)
            itemView.setOnClickListener {
                listener(items)
            }
        }

    }


}