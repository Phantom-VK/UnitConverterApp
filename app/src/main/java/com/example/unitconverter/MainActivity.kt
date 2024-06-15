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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme

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
    Column(
    modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(text = "Unit Converter")
        //Spacer to give space
        Spacer(modifier = Modifier.height(16.dp))
        
        //TextField to input value
        OutlinedTextField(value = "", onValueChange ={
        /*Here we can put what will happen when outlinedtf changes*/}
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row() {
            val context = LocalContext.current
            //Button to select initial unit to convert from
            Box{

                Button(onClick = { /*TODO*/ }) {
                    Text(text = "From")
                    Icon(imageVector = Icons.Default.ArrowDropDown, "Unit From DropDown Icon")
                }

                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Meters")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Kilometers")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Millimeters")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Decimeters")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Feet")}, onClick = { /*TODO*/ })
                }
            }
            //Spacer to give space between two buttons
            Spacer(modifier = Modifier.width(80.dp))
            //Button to select unit to convert to
            Box {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "To")
                    Icon(imageVector = Icons.Default.ArrowDropDown, "Unit From DropDown Icon")
                }
                DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                    DropdownMenuItem(text = { Text(text = "Centimeters")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Meters")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Kilometers")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Millimeters")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Decimeters")}, onClick = { /*TODO*/ })
                    DropdownMenuItem(text = { Text(text = "Feet")}, onClick = { /*TODO*/ })
                }
            }
        }
        Row {
            //Text showing result
            Text(text = "Result: ")
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