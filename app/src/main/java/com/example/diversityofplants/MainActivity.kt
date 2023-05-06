package com.example.diversityofplants

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var adapter: MyAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val nav_view = findViewById<NavigationView>(R.id.nav_view)
        nav_view.setNavigationItemSelectedListener(this)
        val list = ArrayList<ListItem>()
        list.addAll(fillArras(resources.getStringArray(R.array.room),
                                resources.getStringArray(R.array.room_content), getImageId(R.array.room_image_array)))
        val rcView = findViewById<RecyclerView>(R.id.rcView)
        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list, this)
        rcView.adapter = adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.id_room ->
            {
                Toast.makeText(this, "Id room", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.room),
                    resources.getStringArray(R.array.room_content), getImageId(R.array.room_image_array)))
            }
            R.id.id_garden ->
            {
                Toast.makeText(this, "Id garden", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.garden),
                    resources.getStringArray(R.array.garden_content), getImageId(R.array.garden_image_array)))
            }
            R.id.id_ogorod ->
            {
                Toast.makeText(this, "Id ogorod", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.ogorod),
                    resources.getStringArray(R.array.ogorod_content), getImageId(R.array.ogorod_image_array)))
            }
            R.id.id_plod ->
            {
                Toast.makeText(this, "Id plod", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.plod),
                    resources.getStringArray(R.array.plod_content), getImageId(R.array.plod_image_array)))
            }

        }
        return true
    }

    fun fillArras(titleArray: Array<String>, contentArray: Array<String>, imageArray:IntArray ): List<ListItem>
    {
        val listItemArray = ArrayList<ListItem>()
        for (n in 0..titleArray.size - 1)
        {
            val listItem= ListItem(imageArray[n], titleArray[n], contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }
    fun getImageId(imageArrayId:Int) : IntArray
    {
        val tArray:TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for (i in ids.indices)
        {
            ids[i] = tArray.getResourceId(i, 0)
        }
        tArray.recycle()
        return ids
    }

}