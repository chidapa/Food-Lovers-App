package th.ac.su.ict.foodlovers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import th.ac.su.ict.foodlovers.Utils.getJsonDataFromAsset
import th.ac.su.ict.foodlovers.data.Foodlovers
import th.ac.su.ict.foodlovers.data.FoodloversAdapter

class MainActivity : AppCompatActivity() {

    var itemList:ArrayList<Foodlovers> = ArrayList<Foodlovers>()
    lateinit var arrayAdapter: ArrayAdapter<Foodlovers>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonFileString = getJsonDataFromAsset(applicationContext,"foodlovers_data.json")
//        Log.i("data", jsonFileString)

        val gson = Gson()
        val listItemType = object : TypeToken<ArrayList<Foodlovers>>(){}.type

        var foodloversList : ArrayList<Foodlovers> = gson.fromJson(jsonFileString,listItemType)

//        Log.i("data",foodloversList[0].foodloversName)


        itemList = foodloversList

        val adapter = FoodloversAdapter(this@MainActivity,itemList)

        listView.adapter = adapter
    }
}