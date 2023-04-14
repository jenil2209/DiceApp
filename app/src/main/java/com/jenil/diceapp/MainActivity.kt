package com.jenil.diceapp
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.jenil.diceapp.databinding.ActivityMainBinding

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    private var selectedDie: Int = 6
    private var diceList: MutableList<Int> = mutableListOf(4, 6, 8, 10, 12, 20)
    private var myVals: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    sharedPreferences = getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
    editor = sharedPreferences.edit()

    // Check if myVals is saved in SharedPreferences
    if (sharedPreferences.contains("myVals")) {
        myVals = sharedPreferences.getString("myVals", "") ?: ""
    }



    // Set up Roll button
    binding.rollbutton.setOnClickListener {
        (selectedDie)
    }

    // Set up Roll Twice button
    binding.rolltwicebutton.setOnClickListener {
        (selectedDie)
    }

    // Set up Checkbox for True 10 Sided Die
  // binding.setOnCheckedChangeListener { _, isChecked ->
  //      if (isChecked) {
  //          diceList.add(10)
  //      } else {
  //          diceList.remove(10)
  //      }
  //      adapter.notifyDataSetChanged()
  //  }

    // Set up Save button for custom dice values
    //binding.saveButton.setOnClickListener {
      //  val inputText = binding.customDiceInput.text.toString()
        //if (inputText.isNotBlank()) {
          //  val inputList = inputText.split(",").map { it.trim().toIntOrNull() }.filterNotNull()
            //if (inputList.isNotEmpty()) {
              //  diceList.addAll(inputList)
                //adapter.notifyDataSetChanged()
                //myVals += ", $inputText"
                //editor.putString("myVals", myVals).apply()
            //}
        //}
        //binding.custome.text.clear()
    //}
//}

 fun onItemClick(position: Int) {
    selectedDie = diceList[position]
}

 fun roll(maxVal: Int) {
    val randomVal = ((Math.random() * maxVal) + 1).toInt()
    binding.resultTextview.text = randomVal.toString()
}

 fun rollTwice(maxVal: Int) {
    val randomVal1 = ((Math.random() * maxVal) + 1).toInt()
    val randomVal2 = ((Math.random() * maxVal) + 1).toInt()
    binding.resultTextview.text = "$randomVal1, $randomVal2"
}
}}