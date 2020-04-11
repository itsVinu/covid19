package com.example.covid19tracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19tracker.totalresponse.IndiaCovidResponse
import com.example.covid19tracker.totalresponse.StatewiseItem
import kotlinx.android.synthetic.main.custom_recycler.view.*

class CountryAdapter(val list: List<StatewiseItem>):
    RecyclerView.Adapter<CountryAdapter.UserViewHolder>() {

    var onItemClick: ((user: StatewiseItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.custom_recycler,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(user: StatewiseItem) {
            itemView.apply {
                customTv1.text =  user.state.toString()
                customTv2.text =  user.confirmed.toString()
                customTv3.text =  user.active.toString()
                customTv4.text =  user.recovered.toString()
                customTv5.text =  user.deaths.toString()
                deltaTv2.text = user.deltaconfirmed.toString()
                deltaTv4.text = user.deltarecovered.toString()
                deltaTv5.text = user.deltadeaths.toString()

//                Picasso.get().load("https://image.tmdb.org/t/p/w500" + user.posterPath.toString()).into(sliderIv)
                setOnClickListener{
                    onItemClick?.invoke(user)
                }
            }
        }
    }
}
