package com.wahid.evergrow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.wahid.evergrow.ui.theme.EvergrowTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import com.google.gson.Gson
import com.wahid.evergrow.model.PlantData

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EvergrowTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {

                    MainScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val gson = Gson()
    val plant = "Testttttttttt"

    var plantData by remember { mutableStateOf<PlantData?>(null) }

    LaunchedEffect(Unit) {
        val client = OkHttpClient()

        val request = Request.Builder()
            .url("https://plantwise.p.rapidapi.com/plant/?plant_type=$plant")
            .get()
            .addHeader("X-RapidAPI-Key", "d6fbb006b4msh0ffe92edb16ca4cp12a3fajsn142c11961eb5")
            .addHeader("X-RapidAPI-Host", "plantwise.p.rapidapi.com")
            .build()

        val response = withContext(Dispatchers.IO) {
            client.newCall(request).execute()
        }

        val responseData = response.body?.string()
        if (responseData != null) {
            plantData = gson.fromJson(responseData, PlantData::class.java)
        }

    }

    plantData?.let { data ->
        Column {
            data.plant_care_info?.let { careInfo ->
                Text(
                    text = "Plant Type: ${data.plant_type}",
                    style = TextStyle(fontSize = 16.sp)
                )

                Text(
                    text = "Watering: ${careInfo.watering}",
                    style = TextStyle(fontSize = 16.sp)
                )

                Text(
                    text = "Light: ${careInfo.light}",
                    style = TextStyle(fontSize = 16.sp)
                )

                Text(
                    text = "Light: ${careInfo.temperature}",
                    style = TextStyle(fontSize = 16.sp)
                )

                Text(
                    text = "Light: ${careInfo.humidity}",
                    style = TextStyle(fontSize = 16.sp)
                )

                Text(
                    text = "Light: ${careInfo.soil}",
                    style = TextStyle(fontSize = 16.sp)
                )

                Text(
                    text = "Light: ${careInfo.fertilizers}",
                    style = TextStyle(fontSize = 16.sp)
                )

                Text(
                    text = "Light: ${careInfo.diseases}",
                    style = TextStyle(fontSize = 16.sp)
                )

                Text(
                    text = "Light: ${careInfo.propagation}",
                    style = TextStyle(fontSize = 16.sp)
                )

                Text(
                    text = "Light: ${careInfo.seasonal_care}",
                    style = TextStyle(fontSize = 16.sp)
                )

                Text(
                    text = "Light: ${careInfo.growth}",
                    style = TextStyle(fontSize = 16.sp)
                )
                // Add other Text components to display additional information
            }
        }
    } ?: run {
        Text(text = "Loading")
    }
}