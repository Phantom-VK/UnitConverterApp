package com.example.unitconverter

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
fun UnitConverter(){

    var inputValue by remember {
        mutableStateOf("")
    }
    var outputValue by remember {
        mutableStateOf("")
    }
    var inputUnit by remember {
        mutableStateOf("Meters")
    }
    var outputUnit by remember {
        mutableStateOf("Centimeters")
    }
    var iExpanded by remember {
        mutableStateOf(false)
    }
    var oExpanded by remember {
        mutableStateOf(false)
    }
    val conversionFactor = remember {
        mutableDoubleStateOf(1.00)
    }
    val oConversionFactor = remember {
        mutableDoubleStateOf(100.00)
    }

    //Function to convert units
    fun convert(){

        val inputValueDouble = inputValue.toDoubleOrNull()?: 0.0
        val result = (inputValueDouble * conversionFactor.doubleValue * 100.0/oConversionFactor.doubleValue).roundToInt()/100
        outputValue = result.toString()

    }
    Column(
    modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = "Unit Converter")
        //Spacer to give space
        Spacer(modifier = Modifier.height(16.dp))
        
        //TextField to input value
        OutlinedTextField(value = inputValue, onValueChange ={
            inputValue = it
        /*Here we can put what will happen when outlinedtf changes*/}
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row() {
            val context = LocalContext.current
            //Button to select initial unit to convert from

            //Input unit selection Box
            Box{
                var inputButtonText by remember {
                    mutableStateOf("From")
                }
                //Input unit selection Button
                Button(onClick = { iExpanded = !iExpanded }) {
                    Text(text = inputButtonText)
                    Icon(imageVector = Icons.Default.ArrowDropDown, "Unit From DropDown Icon")
                }

                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false
                }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters")}, onClick = { inputUnit = "Centimeters"
                        iExpanded = false
                        inputButtonText = inputUnit
                        conversionFactor.doubleValue = 100.00
                        convert()


                    })
                    DropdownMenuItem(text = { Text(text = "Meters")}, onClick = { inputUnit = "Meters"
                        iExpanded = false
                        inputButtonText = inputUnit
                        conversionFactor.doubleValue = 1.00
                        convert()
                        })
                    DropdownMenuItem(text = { Text(text = "Kilometers")}, onClick = { inputUnit = "Kilometers"
                        iExpanded = false
                        inputButtonText = inputUnit
                        conversionFactor.doubleValue = 0.001
                        convert()
                         })
                    DropdownMenuItem(text = { Text(text = "Millimeters")}, onClick = { inputUnit = "Millimeters"
                        iExpanded = false
                        inputButtonText = inputUnit
                        conversionFactor.doubleValue = 1000.00
                        convert()
                         })
                    DropdownMenuItem(text = { Text(text = "Decimeters")}, onClick = {inputUnit = "Decimeters"
                        iExpanded = false
                        inputButtonText = inputUnit
                        conversionFactor.doubleValue = 10.00
                        convert()
                         })
                    DropdownMenuItem(text = { Text(text = "Feet")}, onClick = { inputUnit = "Feet"
                        iExpanded = false
                        inputButtonText = inputUnit
                        conversionFactor.doubleValue = 3.28084
                        convert()
                         })
                }
            }
            //Spacer to give space between two buttons
            Spacer(modifier = Modifier.width(80.dp))
            //Button box to select unit to convert to
            Box {
                var outputUnitButtonText by remember {
                    mutableStateOf("To")
                }
                //Output unit selection Button
                Button(onClick = {

                    oExpanded = !oExpanded

                     }
                ) {
                    Text(text = outputUnitButtonText)
                    Icon(imageVector = Icons.Default.ArrowDropDown, "Unit From DropDown Icon")
                }
                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters")}, onClick = { outputUnit = "Centimeters"
                        oExpanded = false
                        outputUnitButtonText = outputUnit
                        oConversionFactor.doubleValue = 100.00
                        convert()

                    })
                    DropdownMenuItem(text = { Text(text = "Meters")}, onClick = { outputUnit = "Meters"
                        oExpanded = false
                        outputUnitButtonText = outputUnit
                        oConversionFactor.doubleValue = 1.00
                        convert()

                    })
                    DropdownMenuItem(text = { Text(text = "Kilometers")}, onClick = { outputUnit = "Kilometers"
                        oExpanded = false
                        outputUnitButtonText = outputUnit
                        oConversionFactor.doubleValue = 0.001
                        convert()

                    })
                    DropdownMenuItem(text = { Text(text = "Millimeters")}, onClick = { outputUnit = "Millimeters"
                        oExpanded = false
                        outputUnitButtonText = outputUnit
                        oConversionFactor.doubleValue = 1000.00
                        convert()
                    })
                    DropdownMenuItem(text = { Text(text = "Decimeters")}, onClick = {outputUnit = "Decimeters"
                        oExpanded = false
                        outputUnitButtonText = outputUnit
                        oConversionFactor.doubleValue = 10.00
                        convert()

                    })
                    DropdownMenuItem(text = { Text(text = "Feet")}, onClick = { outputUnit = "Feet"
                        oExpanded = false
                        outputUnitButtonText = outputUnit
                        oConversionFactor.doubleValue =  3.28084
                        convert()
                        })
                }
                }

            }
        Row {
            //Text showing result
            Text(text = "Result: $outputValue  ", color = Color.DarkGray, fontFamily = FontFamily.Serif)
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