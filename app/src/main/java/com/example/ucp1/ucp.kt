package com.example.ucp1

import android.telecom.Call.Details
import androidx.annotation.Size
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun detail(judul: String, isinya: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = judul,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.weight(1f),
            color = Color.Black
        )
        Text(
            text = ":",
            modifier = Modifier.weight(0.1f),

            )
        Text(
            text = isinya,
            modifier = Modifier.weight(2f),

            )
    }
}

@Composable
fun ucpB(modifier: Modifier = Modifier) {
    var origin by remember { mutableStateOf("") }
    var departure by remember { mutableStateOf("") }
    var arrival by remember { mutableStateOf("") }
    var transportation by remember { mutableStateOf("") }

    val listtransport = listOf("bus", "ship", "train","plane")

    var svorigin by remember { mutableStateOf("") }
    var svdeparture by remember { mutableStateOf("") }
    var svarrival by remember { mutableStateOf("") }
    var svtransportation by remember { mutableStateOf("") }
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        // Header with profile picture and name
        ProfileHeader()
        Column(modifier = Modifier
            .offset(y = -14.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFFA8C2FF))) {
            Column(modifier = Modifier
                .padding(12.dp)) {
                Text(text="Plan Your adventures"
                        ,fontWeight = FontWeight.Bold ,fontSize = 25.sp)
                Text(text="Lets plan an exquisite adventure",fontSize = 14.sp)

                OutlinedTextField(
                    shape = RoundedCornerShape(20.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                    value = origin,
                    onValueChange = {origin = it},
                    label = {
                        Text("email")
                    },
                    placeholder = {
                        Text("isi email anda")
                    }
                )
                
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .size(60.dp)
                    ){
                    OutlinedTextField(
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier
                            .size(180.dp)
                            .padding(5.dp),
                        value = departure,
                        onValueChange = {departure = it},
                        label = {
                            Text("departure")
                        },
                        placeholder = {
                            Text("isi email anda")
                        },

                    )
                    OutlinedTextField(
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier

                            .padding(5.dp),
                        value = departure,
                        onValueChange = {departure = it},
                        label = {
                            Text("email")
                        },
                        placeholder = {
                            Text("isi email anda")
                        },
                        )

                }
            }


            Row(
                modifier = Modifier
                    .padding(10.dp)

                    .clip(RoundedCornerShape(20.dp))
                    , // Dark blue for main card background
            ) {
                listtransport.forEach{item ->
                    Row (verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = svtransportation == item,
                            onClick = {
                                svtransportation = item
                            }
                        )
                        Text(
                            text = item
                        )
                    }
                }

            }
            Button (
                onClick = {
                    svorigin = origin
                    svdeparture = departure
                    svarrival = arrival
                    svtransportation = transportation
                }
            ) {
                Text(text = "submit")
            }

            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = Color.Red,
                    contentColor = Color.Black //
                )

            ) {
                detail(judul = "nama", isinya = svorigin)
                detail(judul = "jenis kelamin", isinya = svdeparture)
        }
    }
}






@Composable
fun ProfileHeader() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1E88E5))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile image with circular background
        Column () {
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .clip(CircleShape)
                    .background(Color.White),
                contentAlignment = Alignment.BottomEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile), // Profile image resource
                    contentDescription = "Profile Picture",
                    modifier = Modifier.size(100.dp).clip(CircleShape)
                )
            }

        }

        Spacer(modifier = Modifier.width(8.dp))
        // User greeting
        Row (){
            Icon(imageVector = Icons.Filled.Person, contentDescription = null, tint = Color.White)
            Text(text = "Miftahul Huda", color = Color.White, fontSize = 14.sp)
        }
        Row (){
            Icon(imageVector = Icons.Filled.LocationOn, contentDescription = null, tint = Color.White)
            Text(text = "Kabupaten Tangerang", color = Color.White, fontSize = 14.sp)
        }
    }
}





