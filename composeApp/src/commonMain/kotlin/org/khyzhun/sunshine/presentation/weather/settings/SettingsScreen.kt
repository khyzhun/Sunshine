package org.khyzhun.sunshine.presentation.weather.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.LaunchedEffect
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
import org.khyzhun.sunshine.core.base.BaseContentLayout
import org.khyzhun.sunshine.core.base.components.ToolbarPadding
import org.khyzhun.sunshine.domain.model.ForecastWeatherDomain
import org.khyzhun.sunshine.core.theme.AppColors
import org.khyzhun.sunshine.presentation.weather.weather.WeatherScreenContent
import org.khyzhun.sunshine.presentation.weather.weather.WeatherUiEvent
import org.khyzhun.sunshine.presentation.weather.weather.WeatherUiState
import org.khyzhun.sunshine.presentation.weather.weather.WeatherViewModel
import org.khyzhun.sunshine.utils.DateUtils
import sunshine.composeapp.generated.resources.Res
import sunshine.composeapp.generated.resources.placeholder_degrees
import sunshine.composeapp.generated.resources.placeholder_degrees_max_min

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel,
    onNavigateBack: () -> Unit
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.handleUiEvent(
            SettingsUiEvent.LoadScreenData
        )
    }

    BaseContentLayout(
        viewModel = viewModel,
        onBackPressed = {},
    ) { uiState ->
        uiState?.let {
            SettingsScreenContent(
                viewModel = viewModel,
                state = it,
                event = viewModel::handleUiEvent,
                onNavigateBack = onNavigateBack
            )
        }
    }

}

@Composable
private fun SettingsScreenContent(
    viewModel: SettingsViewModel,
    state: SettingsUiState,
    event: (SettingsUiEvent) -> Unit,
    onNavigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(AppColors.SunnyBackground)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        ToolbarPadding()

        Text(
            text = "Settings screen",
            fontSize = 50.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.clickable {
                onNavigateBack.invoke()
            }
        )
    }
}