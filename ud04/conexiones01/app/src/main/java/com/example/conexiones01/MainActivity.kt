package com.example.conexiones01

import android.app.usage.NetworkStatsManager
import android.bluetooth.BluetoothManager
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.wifi.WifiManager
import android.nfc.NfcAdapter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.conexiones01.ui.theme.Conexiones01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Conexiones01Theme {
                pantalla()
            }
        }
    }
}

@Composable
fun pantalla() {
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        // wifi
        if (!wifiActivo(LocalContext.current)) {
            Text(
                text = "Sin Internet",
                Modifier.background(color = Color.Red)
            )
        } else {
            Text(
                text = "Con Internet",
                Modifier.background(color = Color.Green)
            )
        }

        // datos
        /*if (!datosActivo(LocalContext.current)) {
            Text(
                text = "Sin Datos",
                Modifier.background(color = Color.Red)
            )
        } else {
            Text(
                text = "Con Datos",
                Modifier.background(color = Color.Green)
            )
        }*/

        // bluetooth
        if (!bluetoothActivo(LocalContext.current)) {
            Text(
                text = "Sin Bluetooth",
                Modifier.background(color = Color.Red)
            )
        } else {
            Text(
                text = "Con Bluetooth",
                Modifier.background(color = Color.Green)
            )
        }

        // NFC
        if (!nfcActivo(LocalContext.current)) {
            Text(
                text = "Sin NFC",
                Modifier.background(color = Color.Red)
            )
        } else {
            Text(
                text = "Con NFC",
                Modifier.background(color = Color.Green)
            )
        }

    }
}


fun wifiActivo(context: Context): Boolean {
    val wifiManager = context.getSystemService(Context.WIFI_SERVICE) as WifiManager
    return wifiManager.isWifiEnabled
}

/*fun datosActivo(context: Context): Boolean {
    val netManager = context.getSystemService() as ConnectivityManager
    return true
}*/

fun bluetoothActivo(context: Context): Boolean {
    val bluetoothManager = context.
    getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
    val bluetoothAdapter = bluetoothManager.adapter
    return bluetoothAdapter != null && bluetoothAdapter.isEnabled
}

fun nfcActivo(context: Context): Boolean {
    val nfcAdapter: NfcAdapter? = NfcAdapter.getDefaultAdapter(context)
    return nfcAdapter != null && nfcAdapter.isEnabled
}

fun color(){

}