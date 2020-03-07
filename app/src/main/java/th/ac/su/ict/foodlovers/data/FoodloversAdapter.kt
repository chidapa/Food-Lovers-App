package th.ac.su.ict.foodlovers.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.list_item_foodlovers.view.*
import th.ac.su.ict.foodlovers.R

class FoodloversAdapter(private val context: Context,
                        private val dataSource:ArrayList<Foodlovers>) : BaseAdapter() {

    private val inflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

//    private val inflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as  LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val rowView = inflater.inflate(R.layout.list_item_foodlovers,null)

        rowView.tvTitle.text = dataSource[position].foodloversName
        rowView.tvSubtitle.text = dataSource[position].caption
        rowView.tvDetail.text = dataSource[position].price

        return rowView
    }

    override fun getItem(position: Int): Any {

        return dataSource[position]

    }

    override fun getItemId(position: Int): Long {

        return position.toLong()

    }

    override fun getCount(): Int {

        return dataSource.size
    }

}