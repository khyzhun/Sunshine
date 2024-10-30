package org.khyzhun.sunshine.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.vectorResource
import sunshine.composeapp.generated.resources.Res
import sunshine.composeapp.generated.resources.allDrawableResources
import sunshine.composeapp.generated.resources.compose_multiplatform
import sunshine.composeapp.generated.resources.ic_sunny

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF4FC3F7)) // Light blue background
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar()

        Spacer(modifier = Modifier.height(24.dp))

        SunIcon()

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "22°",
            fontSize = 64.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(
            text = "SUNNY",
            fontSize = 24.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "22/14°",
            fontSize = 18.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(32.dp))

        WeatherForecast(day = "Today", temperature = "22/14", icon = "☀️")
        WeatherForecast(day = "Monday", temperature = "20/12", icon = "☁️")
        WeatherForecast(day = "Thursday", temperature = "19/10", icon = "🌧️")
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "NEW YORK",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = "Location",
                tint = Color.White,
                modifier = Modifier.size(20.dp)
            )
        }
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "Settings",
            tint = Color.White
        )
    }
}

@Composable
fun SunIcon() {
    Image(
        painter = painterResource(Res.drawable.ic_sunny),
        contentDescription = "Sun Icon",
        modifier = Modifier.size(100.dp)
    )
}

@Composable
fun WeatherForecast(day: String, temperature: String, icon: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = icon,
            fontSize = 24.sp
        )
        Text(
            text = day,
            fontSize = 18.sp,
            color = Color.White
        )
        Text(
            text = temperature,
            fontSize = 18.sp,
            color = Color.White,
            textAlign = TextAlign.End
        )
    }
}