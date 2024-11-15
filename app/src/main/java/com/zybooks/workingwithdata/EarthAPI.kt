package com.zybooks.workingwithdata

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.zybooks.workingwithdata.NasaAPI.ImageData
import org.json.JSONArray

//const val TAG = "EARTH_API"

class EarthAPI : AppCompatActivity() {
    lateinit var longitudeEditText: EditText
    lateinit var latitudeEditText: EditText
    lateinit var recyclerView: RecyclerView
    lateinit var imageDataSet: ArrayList<ImageData>
    lateinit var imageCustomAdapter: ImageCustomAdapter
    lateinit var countEditText: EditText


    data class ImageData(val url: String, val description: String = "", val date: String = "") {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_earth_api)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        supportActionBar?.title = "Earth Things!"

        longitudeEditText = findViewById(R.id.dateTextView)
        longitudeEditText = findViewById(R.id.dateEditText)
        longitudeEditText.doAfterTextChanged {
            countEditText.isEnabled = longitudeEditText.text.isEmpty()
        }

        latitudeEditText = findViewById(R.id.endDateTextView)
        latitudeEditText = findViewById(R.id.endDateEditText)
        latitudeEditText.doAfterTextChanged {
            countEditText.isEnabled = latitudeEditText.text.isEmpty()
        }

        countEditText = findViewById(R.id.countEditText)
        countEditText.doAfterTextChanged {
            longitudeEditText.isEnabled = countEditText.text.isEmpty()
            latitudeEditText.isEnabled = countEditText.text.isEmpty()
        }
    }
}