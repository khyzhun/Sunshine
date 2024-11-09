package org.khyzhun.sunshine.presentation.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.stringResource
import org.khyzhun.sunshine.domain.model.ForecastWeatherDomain
import org.khyzhun.sunshine.core.theme.AppColors
import org.khyzhun.sunshine.utils.DateUtils
import sunshine.composeapp.generated.resources.Res
import sunshine.composeapp.generated.resources.placeholder_degrees
import sunshine.composeapp.generated.resources.placeholder_degrees_max_min

@Composable
fun WeatherScreen(viewModel: WeatherViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.SunnyBackground)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        TopBar(city = uiState.city)

        TodayDetails(
            icon = uiState.icon,
            description = uiState.description,
            temperature = uiState.temperature
        )

        ForecastFor3Days(forecasts = uiState.forecast)
    }
}

@Composable
private fun TopBar(city: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LocationRow(city)
        SettingsIcon()
    }
}

@Composable
private fun LocationRow(city: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = city,
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
}

@Composable
private fun SettingsIcon() {
    Icon(
        imageVector = Icons.Default.Settings,
        contentDescription = "Settings",
        tint = Color.White,
        modifier = Modifier.size(20.dp)
    )
}

@Composable
private fun TodayDetails(icon: String, temperature: Int, description: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        WeatherIcon(icon, 150.dp)
        WeatherDescription(description)
        WeatherDegrees(temperature)
    }
}

@Composable
private fun WeatherIcon(icon: String, size: Dp) {
    KamelImage(
        resource = { asyncPainterResource(data = icon) },
        contentDescription = "Weather large icon",
        modifier = Modifier.size(size)
    )
//    Image(
//        painter = rememberAsyncImagePainter(icon),
//        contentDescription = "Weather large icon",
//        contentScale = ContentScale.Crop,
//        modifier = Modifier.size(size)
//    )
}

@Composable
private fun WeatherDescription(description: String) {
    Text(
        text = description,
        fontSize = 64.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}

@Composable
private fun WeatherDegrees(temperature: Int) {
    Text(
        text = stringResource(Res.string.placeholder_degrees, temperature),
        fontSize = 64.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White
    )
}

@Composable
private fun ForecastFor3Days(forecasts: List<ForecastWeatherDomain>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(forecasts) { forecast ->
            WeatherForecast(
                day = forecast.day,
                temperatureMax = forecast.temperatureMax,
                temperatureMin = forecast.temperatureMin,
                icon = forecast.icon
            )
        }
    }
}

@Composable
private fun WeatherForecast(
    day: String,
    temperatureMax: Int,
    temperatureMin: Int,
    icon: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        WeatherIcon(icon, 36.dp)
        WeatherForecastDay(day)
        WeatherForecastMaxMin(temperatureMax, temperatureMin)
    }
}

@Composable
private fun WeatherForecastDay(day: String) {
    Text(
        text = DateUtils.getDayOfWeek(day),
        fontSize = 18.sp,
        color = Color.White
    )
}

@Composable
private fun WeatherForecastMaxMin(
    temperatureMax: Int,
    temperatureMin: Int
) {
    Text(
        text = stringResource(
            Res.string.placeholder_degrees_max_min,
            temperatureMax,
            temperatureMin
        ),
        fontSize = 18.sp,
        color = Color.White,
        textAlign = TextAlign.End
    )
}


