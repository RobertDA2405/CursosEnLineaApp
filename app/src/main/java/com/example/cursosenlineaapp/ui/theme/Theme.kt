package com.example.cursosenlineaapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryColor,
    secondary = SecondaryColor,
    surface = SurfaceColor,
    surfaceVariant = SurfaceVariantColor,
    background = BackgroundColor,
    error = ErrorColor,
    onPrimary = OnPrimaryColor,
    onSecondary = OnSecondaryColor,
    onSurface = OnSurfaceColor,
    onSurfaceVariant = OnSurfaceVariantColor
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryColor,
    secondary = SecondaryColor,
    surface = SurfaceColor,
    surfaceVariant = SurfaceVariantColor,
    background = BackgroundColor,
    error = ErrorColor,
    onPrimary = OnPrimaryColor,
    onSecondary = OnSecondaryColor,
    onSurface = OnSurfaceColor,
    onSurfaceVariant = OnSurfaceVariantColor
)

@Composable
fun CursosEnLineaAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}