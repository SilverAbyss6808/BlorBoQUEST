package com.zybooks.blorboquest

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


class Settings: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        supportActionBar?.setIcon(R.drawable.menu_icon)
        setSupportActionBar(findViewById(R.id.nav_menu))
        val spinner: Spinner = findViewById(R.id.backgrounds_spinner)
        val defaultTextForBackgroundSpinner = "Background Color"
        val backgroundColors: MutableList<String?> = ArrayList()
        backgroundColors.add(0, "Select Background Color")
        backgroundColors.add("Brown")
        backgroundColors.add("Yellow")
        backgroundColors.add("Green")
        backgroundColors.add("Blue")
        backgroundColors.add("Purple")
        backgroundColors.add("Pink")

        val settings_layout = findViewById<ConstraintLayout>(R.id.settingsLayout)
        //R.color.default_back_color=663106
        val arrayAdapter: ArrayAdapter<String?> = ArrayAdapter<String?>(this, android.R.layout.simple_list_item_1, backgroundColors)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = arrayAdapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                if (parent.getItemAtPosition(position) == "Select Background Color") {
                    settings_layout.setBackgroundResource(R.color.default_back_color)
                }
                if(parent.getItemAtPosition(position)== "Yellow"){
                   // settings_layout.setBackgroundResource(R.color.yellow_back_color)
                }
                if(parent.getItemAtPosition(position)== "Brown"){
                    settings_layout.setBackgroundResource(R.color.brown_back_color)
                }
                if(parent.getItemAtPosition(position)== "Green"){
                    settings_layout.setBackgroundResource(R.color.green_back_color)
                }
                if(parent.getItemAtPosition(position)== "Blue"){
                    settings_layout.setBackgroundResource(R.color.blue_back_color)
                }
                if(parent.getItemAtPosition(position)== "Purple"){
                    settings_layout.setBackgroundResource(R.color.purple_back_color)
                }
                if(parent.getItemAtPosition(position)== "Pink"){
                    settings_layout.setBackgroundResource(R.color.pink_back_color)
                }
                else {
                    val item = parent.getItemAtPosition(position).toString()

                    Toast.makeText(parent.context, "Selected: $item", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_button ->{
                startActivity(Intent(this, MenuPage::class.java))
            }
        }
        return super.onOptionsItemSelected(item)

    }
}