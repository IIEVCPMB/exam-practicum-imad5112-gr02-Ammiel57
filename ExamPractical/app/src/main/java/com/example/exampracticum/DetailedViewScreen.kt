package com.example.exampracticum

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView


class DetailedViewScreen: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.detailed_screen)

        // 1. Link your layout rows and their name tags into clean lists
        val listRows = listOf(
            findViewById<LinearLayout>(R.id.llItemRow1),
            findViewById<LinearLayout>(R.id.llItemRow2),
            findViewById<LinearLayout>(R.id.llItemRow3),
            findViewById<LinearLayout>(R.id.llItemRow4)
        )

        val listTextViews = listOf(
            findViewById<TextView>(R.id.tvItemName1),
            findViewById<TextView>(R.id.tvItemName2),
            findViewById<TextView>(R.id.tvItemName3),
            findViewById<TextView>(R.id.tvItemName4)
        )

        val btnBackToBase = findViewById<Button>(R.id.btnBackToBase)

        // 2. Fetch the incoming gear data from the Intent
        val listReceivedGear = intent.getStringArrayListExtra("KEY_GEAR_LIST")

        // 3. The Loop: Reveal rows based on how many items were packed
        listReceivedGear?.forEachIndexed { intIndex, strGearName ->
            // Safety safety: Make sure we don't exceed our 4 visual design slots
            if (intIndex < listRows.size) {
                listRows[intIndex].visibility = View.VISIBLE        // Unhide the row
                listTextViews[intIndex].text = strGearName         // Display the gear name
            }
        }

        // 4. Back to Base Logic
        btnBackToBase.setOnClickListener {
            // finish() simply closes this screen and drops the user back to the Main screen
            // exactly how they left it, without erasing their current input text!
            finish()
        }
    }
}

