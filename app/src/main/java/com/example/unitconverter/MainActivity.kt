package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UnitConverter()
                }
            }
        }
    }
}

@Composable
fun UnitConverter() {

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Meters") }
    var outputUnit by remember { mutableStateOf("Centimeters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableDoubleStateOf(1.00) }
    val oConversionFactor = remember { mutableDoubleStateOf(100.00) }

    // Function to convert units
    fun convert() {
        val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0
        val result = (inputValueDouble * conversionFactor.doubleValue * 100.0 / oConversionFactor.doubleValue) / 100.0
        outputValue = result.toString()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Unit Converter",
            style = MaterialTheme.typography.headlineMedium.copy(
                color = Color(0xFF6200EE),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        )
        // Spacer to give space
        Spacer(modifier = Modifier.height(16.dp))

        // TextField to input value
        OutlinedTextField(
            value = inputValue,
            onValueChange = {
                inputValue = it
                convert()
            },
            label = { Text("Enter Value") },
            modifier = Modifier.width(200.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            // Input unit selection Box
            Box {
                // Input unit selection Button
                Button(
                    onClick = { iExpanded = !iExpanded },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
                ) {
                    Text(text = inputUnit, color = Color.White)
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Unit From DropDown Icon", tint = Color.White)
                }

                DropdownMenu(
                    expanded = iExpanded,
                    onDismissRequest = { iExpanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeters") },
                        onClick = {
                            inputUnit = "Centimeters"
                            iExpanded = false
                            conversionFactor.doubleValue = 100.0
                            convert()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meters") },
                        onClick = {
                            inputUnit = "Meters"
                            iExpanded = false
                            conversionFactor.doubleValue = 1.00
                            convert()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Kilometers") },
                        onClick = {
                            inputUnit = "Kilometers"
                            iExpanded = false
                            conversionFactor.doubleValue = 1000.0
                            convert()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Millimeters") },
                        onClick = {
                            inputUnit = "Millimeters"
                            iExpanded = false
                            conversionFactor.doubleValue = 0.001
                            convert()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Decimeters") },
                        onClick = {
                            inputUnit = "Decimeters"
                            iExpanded = false
                            conversionFactor.doubleValue = 10.0
                            convert()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Feet") },
                        onClick = {
                            inputUnit = "Feet"
                            iExpanded = false
                            conversionFactor.doubleValue = 0.3048
                            convert()
                        }
                    )
                }
            }
            // Spacer to give space between two buttons
            Spacer(modifier = Modifier.width(16.dp))
            // Button box to select unit to convert to
            Box {
                // Output unit selection Button
                Button(
                    onClick = { oExpanded = !oExpanded },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF03DAC5))
                ) {
                    Text(text = outputUnit, color = Color.White)
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "Unit From DropDown Icon", tint = Color.White)
                }
                DropdownMenu(
                    expanded = oExpanded,
                    onDismissRequest = { oExpanded = false }
                ) {
                    DropdownMenuItem(
                        text = { Text(text = "Centimeters") },
                        onClick = {
                            outputUnit = "Centimeters"
                            oExpanded = false
                            oConversionFactor.doubleValue = 100.0
                            convert()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Meters") },
                        onClick = {
                            outputUnit = "Meters"
                            oExpanded = false
                            oConversionFactor.doubleValue = 1.00
                            convert()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Kilometers") },
                        onClick = {
                            outputUnit = "Kilometers"
                            oExpanded = false
                            oConversionFactor.doubleValue = 1000.0
                            convert()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Millimeters") },
                        onClick = {
                            outputUnit = "Millimeters"
                            oExpanded = false
                            oConversionFactor.doubleValue = 0.001
                            convert()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Decimeters") },
                        onClick = {
                            outputUnit = "Decimeters"
                            oExpanded = false
                            oConversionFactor.doubleValue = 10.0
                            convert()
                        }
                    )
                    DropdownMenuItem(
                        text = { Text(text = "Feet") },
                        onClick = {
                            outputUnit = "Feet"
                            oExpanded = false
                            oConversionFactor.doubleValue = 0.3048
                            convert()
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            // Text showing result
            Text(
                text = "Result: $outputValue",
                color = Color.DarkGray,
                fontFamily = FontFamily.Serif,
                style = MaterialTheme.typography.headlineMedium.copy(fontSize = 20.sp, fontWeight = FontWeight.Medium)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverterTheme {
        UnitConverter()
    }
}
