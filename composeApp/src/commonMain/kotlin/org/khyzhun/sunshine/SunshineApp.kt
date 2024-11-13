package org.khyzhun.sunshine

import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.khyzhun.sunshine.core.navigation.AppNavigation
import org.khyzhun.sunshine.core.theme.SunshineTheme

@Composable
@Preview
fun SunshineAppView() {
    SunshineTheme {
        AppNavigation()
    }
}