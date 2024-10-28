package com.example.ejercicionavcontroller01

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "inicio"
            ) {
                composable("inicio") {
                    PantallaInicio(VistaInicionavController = navController)
                }
                composable("goku") {
                    PantallaGoku(VistaGokuController = navController)
                }
                composable("pantalla3") {
                    Pantalla3(Vista3navController = navController)
                }
                composable("pantalla4") {
                    Pantalla4(Vista4navController = navController)
                }
                composable("pantalla5") {
                    Pantalla5(Vista5navController = navController)
                }
            }
        }
    }
}

@Composable
fun FondoPantalla(){
    Box(Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.piccolo),
            contentScale = ContentScale.FillBounds,
            contentDescription = "piccolo",
            modifier = Modifier.matchParentSize()
        )
    }
}


@Composable
fun PantallaInicio(modifier: Modifier = Modifier, VistaInicionavController: NavHostController) {
    FondoPantalla()
    val mMediaPlayer = MediaPlayer.create(LocalContext.current, R.raw.gangstaparadise)
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 340.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "LOS BOTONES!",
            modifier = modifier.clickable {
                if (mMediaPlayer.isPlaying) {
                    mMediaPlayer.stop()
                    mMediaPlayer.prepare()
                }
                else{
                    mMediaPlayer.start()
                }
            },
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Row {
            Button(onClick = {
                VistaInicionavController.navigate("goku")
            },
                modifier.padding(top = 90.dp)
            ) { Text("Imagen 1") }

            Button(onClick = {
                VistaInicionavController.navigate("pantalla3")
            },
                modifier.padding(top = 90.dp)
            ) { Text("Imagen 2") }

            Button(onClick = {
                VistaInicionavController.navigate("pantalla4")
            },
                modifier.padding(top = 90.dp)
            ) { Text("Texto 1") }

            Button(onClick = {
                VistaInicionavController.navigate("pantalla5")
            },
                modifier.padding(top = 90.dp)
            ) { Text("Texto 2") }
        }
    }
}

@Composable
fun PantallaGoku(
    modifier: Modifier = Modifier, VistaGokuController: NavHostController) {
    val context = LocalContext.current
    val mMediaPlayer = MediaPlayer.create(context, R.raw.mui)
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 40.dp)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.drip),
            contentDescription = "GokuDrip",
            Modifier.size(500.dp,500.dp)
        )

        Button(
            onClick = {
                mMediaPlayer.start()

            },
            modifier.zIndex(1f)
        ) { Text("UIN") }
    }
}

@Composable
fun Pantalla3(modifier: Modifier = Modifier, Vista3navController: NavHostController) {
    val context = LocalContext.current
    val mMediaPlayer = MediaPlayer.create(context, R.raw.tolon)
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 40.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "PUEBLO HISTORICO",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 20.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.tolon),
            contentDescription = "puebloHisotrico",
            Modifier.size(500.dp,500.dp)
        )

        Button(
            onClick = {
                mMediaPlayer.start()
            },
            modifier.padding(top = 20.dp)
        ) { Text("TOLON") }
    }
}

@Composable
fun Pantalla4(modifier: Modifier = Modifier, Vista4navController: NavHostController) {
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 40.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "La sociedad industrial y su futuro",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(top = 80.dp)
        )
        Text(
            text = "La Sociedad Industrial y su Futuro\" es un manifiesto penetrante y provocativo que desafía las bases mismas de la modernidad. Escrito por Theodore John Kaczynski, también conocido como \"Unabomber\", este texto no es solo una única en la historia de su tiempo, sino un llamado reflexivo a la realidad contemporánea. Kaczynski, un matemático brillante, presenta una crítica mordaz de la tecnología y sus efectos deshumanizantes en la sociedad, argumentando que el avance tecnológico inevitablemente lleva a la degradación del medio ambiente y a la erosión de la libertad humana. Aunque es imposible separar el texto de los infames actos de violencia de su autor, \"La Sociedad Industrial y su Futuro\" es un documento crucial para entender algunas de las inquietudes más profundas de la era moderna. Esta edición se ofrece como un recurso para estudiantes, académicos y cualquier persona interesada en los debates sobre tecnología, ética y el futuro de la sociedad.",
            modifier = modifier.padding(top = 80.dp, start = 20.dp, end = 20.dp)
        )
    }
}

@Composable
fun Pantalla5(modifier: Modifier = Modifier, Vista5navController: NavHostController) {
    Column (horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(top = 40.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Es épico",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(top = 80.dp)
        )
        Text(
            text = "Es un género narrativo antiguo, que depende de un narrador para contar una serie de episodios reales o ficticios (o ambas cosas). En general, la épica cuenta la historia de las hazañas de un héroe, quien se enfrenta a los dioses, a la guerra, a criaturas sobrenaturales o a las fuerzas de la naturaleza.",
            modifier = modifier.padding(top = 80.dp, start = 20.dp, end = 20.dp)
        )
    }
}