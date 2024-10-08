package com.example.contactosjpc.composables

import android.text.Layout
import android.text.Layout.Alignment
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.BiasAbsoluteAlignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.lang.reflect.Modifier

@Composable
fun SimpleTextField() {
    var text by rememberSaveable { mutableStateOf("Usuario") }
    var password by remember { mutableStateOf("") }

    Card(androidx.compose.ui.Modifier.fillMaxWidth()) {
        Column {
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Usuario") }
            )
        }
    }
}
