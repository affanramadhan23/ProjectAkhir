package com.example.projectakhir.ui.Halaman

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.projectakhir.Navigation.DestinasiNavigasi
import com.example.projectakhir.R

object DestinasiUtama : DestinasiNavigasi {
    override val route = "Item"
    override val titleRes = "Pilih"
}
@Composable
fun HalamanUtama(
    onCustomerClick: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.pinjol),
            color = Color.DarkGray,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 150.dp, top = 100.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Button(
                onClick = { },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
            ) {
                Text("CUSTOMER")
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = onCustomerClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp)
        ) {
            Text("DATA PINJAMAN")
        }
    }
}