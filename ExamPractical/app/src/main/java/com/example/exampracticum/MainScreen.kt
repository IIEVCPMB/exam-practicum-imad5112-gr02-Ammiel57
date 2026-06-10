package com.example.exampracticum

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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

        var intTotalItems = 0

        //The loop checks input field one by one
        for (inputField in listGearInputs){
            //if the user typed something (the field is not blank)
            if (inputField.text.toString().trim().isNotEmpty()){
                intTotalItems++ // Add 1 to our count

            }
        }
        //Output final total to screen
        txtTotalItems.text = "Total items packed: $intTotalItems"
    }



    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
        insets
    }
}
}