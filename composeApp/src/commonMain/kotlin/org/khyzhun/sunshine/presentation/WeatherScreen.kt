package org.khyzhun.sunshine.presentation

import androidx.compose.foundation.Image
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import org.khyzhun.sunshine.model.Forecast
import org.khyzhun.sunshine.model.WeatherState
import org.khyzhun.sunshine.theme.AppColors
import org.khyzhun.sunshine.utils.getWeatherIcon
import org.khyzhun.sunshine.utils.getWeatherTitle
import sunshine.composeapp.generated.resources.Res
import sunshine.composeapp.generated.resources.placeholder_degrees

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
            weather = WeatherState.Sunny,
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
private fun TodayDetails(weather: WeatherState, temperature: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        LargeWeatherIcon(weather)
        Text(
            text = stringResource(getWeatherTitle(weather)),
            fontSize = 64.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = stringResource(Res.string.placeholder_degrees, temperature),
            fontSize = 64.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
private fun LargeWeatherIcon(weather: WeatherState) {
    Image(
        painter = painterResource(getWeatherIcon(weather)),
        contentDescription = "Sun Icon",
        modifier = Modifier.size(250.dp)
    )
}

@Composable
private fun ForecastFor3Days(forecasts: List<Forecast>) {
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
    icon: WeatherState
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(getWeatherIcon(icon)),
            contentDescription = "Sun Icon",
            modifier = Modifier.size(36.dp)
        )
        Text(
            text = day,
            fontSize = 18.sp,
            color = Color.White
        )
        Text(
            text = "$temperatureMax/$temperatureMin°",
            fontSize = 18.sp,
            color = Color.White,
            textAlign = TextAlign.End
        )
    }
}


