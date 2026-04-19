package com.ctb.presentation.sample

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ctb.domain.models.SampleEntity

@Composable
fun SampleContent(
    state: SampleState,
    modifier: Modifier = Modifier
) {
    when {
        state.isLoading -> {
            Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        state.error != null -> {
            Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(state.error)
            }
        }
        else -> {
            LazyColumn(modifier.padding(16.dp)) {
                items(state.items) { item ->
                    SampleItem(item)
                }
            }
        }
    }
}

@Composable
private fun SampleItem(item: SampleEntity) {
    Text(
        text = "${item.name}: ${item.description}",
        modifier = Modifier.padding(8.dp)
    )
}
