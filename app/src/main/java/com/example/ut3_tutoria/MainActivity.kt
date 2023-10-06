package com.example.ut3_tutoria


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ut3_tutoria.ui.theme.UT3_tutoriaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UT3_tutoriaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    DragonCard()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UT3_tutoriaTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun myText() {
    Text(
        text = "Imagen Dragon Ball ",
        style = TextStyle(
            color = Color.Blue,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            shadow = Shadow(color = Color.Red, Offset(10f, 10f), blurRadius = 3f)
        )
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun DragonCard(/*...*/) {
    Column {
        Row(
            modifier = Modifier
                .size(width = 400.dp, height = 100.dp)
                .padding(5.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.dragon),
                contentDescription = "Dragon Ball",
                modifier = Modifier.requiredSize(150.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                //Cambio de color, tamaño, cursiva, negrita y alineación centrada
                Text(
                    text = "Imagen Dragon Ball ",
                    style = TextStyle(
                        color = Color.Blue,
                        fontSize = 30.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        shadow = Shadow(color = Color.Red, Offset(10f, 10f), blurRadius = 3f)
                    )
                )

            }
        }
        Row(
            modifier = Modifier
                .size(width = 400.dp, height = 100.dp)
                .padding(5.dp)
        ) {
            var estadoTextField by remember { mutableStateOf(" ") }
            TextField(value = estadoTextField, onValueChange = { estadoTextField = it })
        }
        Row() {
            var estadoOutlined by remember { mutableStateOf(" ") }
            OutlinedTextField(
                value = estadoOutlined,
                onValueChange = { estadoOutlined = it },
                label = { Text(text = "Hola") },
                modifier = Modifier.padding(10.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Magenta,
                    unfocusedBorderColor = Color.LightGray
                )
            )
        }
        Row (modifier = Modifier
            .size(width = 400.dp, height = 100.dp)
            .padding(5.dp)
        ) {
            myButton()
        }
        Row (
        ) {
            MyButtonRem()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun myButton() {
    Column() {
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.Magenta
            ),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Column() {
                Text(text = "Primer Botón")
            }
        }
        var enable by rememberSaveable { mutableStateOf(true)  }
        Column(
            Modifier
                .fillMaxSize()
                .padding(24.dp)
        ) {
            OutlinedButton(onClick = { enable = false },
                enabled=enable,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Blue,
                    contentColor = Color.Magenta
                ),
                modifier = Modifier.padding(top=8.dp)
            ) {
                Text(text = "Outlined Button")

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun MyButtonRem() {
    var enable by rememberSaveable { mutableStateOf(true)  }
    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = { enable = false },
            enabled=enable,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.Magenta
            ),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Text(text = "Botón con estado")
        }
    }
}
