package com.example.exampracticum

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent

class MainScreen : AppCompatActivity(){

    private lateinit var edtGear1: EditText
    private lateinit var edtGear2: EditText
    private lateinit var edtGear3: EditText
    private lateinit var edtGear4: EditText
    private lateinit var btnGear: Button
    private lateinit var txtTotalItems: TextView







override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContentView(R.layout.main_screen)

    edtGear1 = findViewById(R.id.edtGear1)
    edtGear2 = findViewById(R.id.edtGear2)
    edtGear3 = findViewById(R.id.edtGear3)
    edtGear4 = findViewById(R.id.edtGear4)
    btnGear = findViewById(R.id.btnGear)
    txtTotalItems = findViewById(R.id.txtTotalItems)

   btnGear.setOnClickListener {
       val listGearInputs = listOf(edtGear1, edtGear2, edtGear3, edtGear4)

       //Array list to store only items the user typed
       val listPackedItems = ArrayList<String>()
       for (inputField in listGearInputs){
           val strText = inputField.text.toString().trim()
           if (strText.isNotEmpty()){
               listPackedItems.add(strText)//Add gear name to list
           }
       }
       //only move to next screen if they packed one item
       if (listPackedItems.isNotEmpty()) {
           val intentDetails = Intent(this, DetailedViewScreen::class.java)

           //Pass the list of gear names to next screen
           intentDetails.putStringArrayListExtra("KEY_GEAR_LIST", listPackedItems)
           startActivity(intentDetails)
       }else{
           txtTotalItems.text = "Please pack at least 1 item first"
       }
   }



    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        insets
    }
}
}