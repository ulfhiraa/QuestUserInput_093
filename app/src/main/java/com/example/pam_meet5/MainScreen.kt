package com.example.pam_meet5

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.selects.select

@Preview(showBackground = true)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    var nama by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var alamat by rememberSaveable { mutableStateOf("") }
    var noHP by rememberSaveable { mutableStateOf("") }
    var selectedGender by rememberSaveable { mutableStateOf("") }

    val jenisKelamin = listOf("Laki-laki", "Perempuan")

    var namaUser by rememberSaveable { mutableStateOf("") }
    var emailUser by rememberSaveable { mutableStateOf("") }
    var alamatUser by rememberSaveable { mutableStateOf("") }
    var noHPUser by rememberSaveable { mutableStateOf("") }
    var selectedGenderUser by rememberSaveable { mutableStateOf("") }

    Column (Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally) { // layout 1
        OutlinedTextField(
            value = nama,
            onValueChange = {nama = it},
            placeholder = { Text("Masukkan nama: ")},
            label = { Text("Nama")},
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        Row(){
            jenisKelamin.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically) // untuk mengatur posisi
                { RadioButton(selected = selectedGender == item,
                    onClick = {
                        selectedGender = item
                    })
                    Text(item)
                }
            }
        }

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            placeholder = { Text("Masukkan email: ")},
            label = { Text("Email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        OutlinedTextField(
            value = alamat,
            onValueChange = {alamat = it},
            placeholder = { Text("Masukkan alamat: ")},
            label = { Text("Alamat")},
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        OutlinedTextField(
            value = noHP,
            onValueChange = {noHP = it},
            placeholder = { Text("Masukkan no HP: ")},
            label = { Text("No Hp")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth().padding(5.dp)
        )

        Button(onClick =  {
            namaUser = nama
            emailUser = email
            alamatUser = alamat
            noHPUser = noHP
            selectedGenderUser = selectedGender
        })
        {
            Text("Simpan")
        }

        Card(modifier.size(height = 300.dp, width = 300.dp)) {
            CardSection(judulParam = "Nama", isiParam = namaUser)
            CardSection(judulParam = "Jenis Kelamin", isiParam = selectedGenderUser)
            CardSection(judulParam = "Email", isiParam = emailUser)
            CardSection(judulParam = "Alamat", isiParam = alamatUser)
            CardSection(judulParam = "No HP ", isiParam = noHPUser)
        }
    }
}

@Composable
fun CardSection(judulParam:String, isiParam:String){
    Column (horizontalAlignment = Alignment.Start, modifier = Modifier.padding(8.dp)) {
        // horizontal alignment start untuk memulai tulisan secara horizontal dari kiri ke kanan

        Row (
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = judulParam, modifier = Modifier.weight(0.8f)) // weight untuk mengatur space isi data
            Text(text = " : ", modifier = Modifier.weight(0.2f))
            Text(
                text = "$isiParam",
                modifier = Modifier.weight(2f))
        }
    }
}

