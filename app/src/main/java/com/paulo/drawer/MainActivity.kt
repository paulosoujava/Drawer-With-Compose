package com.paulo.drawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.paulo.drawer.ui.theme.DrawerTheme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state = rememberScaffoldState()
            val coroutineScope = rememberCoroutineScope()

            Surface() {
                Scaffold(
                    scaffoldState = state,
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "Navigation Demo") },
                            navigationIcon = {
                                IconButton(onClick = {
                                    coroutineScope.launch { state.drawerState.open() }
                                }) {
                                    Icon(Icons.Default.Menu, contentDescription = null)
                                }

                            },
                            actions = {
                                IconButton(onClick = {
                                    coroutineScope.launch { state.drawerState.open() }
                                }) {
                                    Icon(Icons.Default.Menu, contentDescription = null)
                                }
                            }
                        )
                    },
                    drawerShape = RoundedCornerShape(topEnd = 23.dp, bottomEnd = 23.dp),
                    drawerContent = { NavDrawer(state, coroutineScope) },
                    content = {
                        Image(
                            painter = painterResource(id = R.drawable.pic0),
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(),
                            contentScale = ContentScale.Crop
                        )
                    }
                )
            }
        }

    }
}
