package org.khyzhun.sunshine.presentation.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import org.khyzhun.sunshine.core.base.BaseContentLayout
import org.khyzhun.sunshine.core.base.components.ToolbarPadding
import org.khyzhun.sunshine.core.theme.AppColors

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
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()
    var cityName by remember { mutableStateOf("") }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                TextField(
                    value = cityName,
                    onValueChange = { cityName = it },
                    label = { Text("City Name") }
                )
                Button(onClick = {
                    event(SettingsUiEvent.UpdateLocation(cityName))
                    coroutineScope.launch { sheetState.hide() }
                }) {
                    Text("Save")
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = AppColors.SunnyBackground)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            ToolbarPadding()
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                CloseButton(onClick = onNavigateBack)
                Text(
                    text = "Settings screen",
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
            }

            Spacer(modifier = Modifier.height(48.dp))

            LocationField(
                location = state.location,
                onClick = {
                    coroutineScope.launch { sheetState.show() }
                }
            )

            SettingSwitch(
                label = "Dark Theme",
                isChecked = state.isDarkTheme,
                onCheckedChange = { event(SettingsUiEvent.UpdateTheme(it)) }
            )

            SettingSwitch(
                label = "Celsius",
                isChecked = state.isCelsius,
                onCheckedChange = { event(SettingsUiEvent.UpdateTemperatureUnit(it)) }
            )
        }
    }
}

@Composable
fun CloseButton(onClick: () -> Unit) {
    Icon(
        imageVector = Icons.Filled.Close,
        tint = Color.White,
        contentDescription = "Close",
        modifier = Modifier
            .size(24.dp)
            .clickable(onClick = onClick)
    )
}

@Composable
fun LocationField(location: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = location.ifEmpty { "Enter location" },
            color = Color.White,
            modifier = Modifier.weight(1f)
        )
        Icon(imageVector = Icons.Default.Edit, tint = Color.White, contentDescription = "Edit Location")
    }
}

@Composable
fun SettingSwitch(label: String, isChecked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            color = Color.White,
            modifier = Modifier.weight(1f)
        )
        Switch(
            checked = isChecked,
            onCheckedChange = onCheckedChange
        )
    }
}