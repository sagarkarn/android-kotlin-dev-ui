package com.skx.devui

import AlertInfo
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.skx.devui.components.*
import com.skx.devui.components.chat.UserMessageListCard
import com.skx.devui.ui.theme.DevuiTheme



class MainActivity : ComponentActivity() {

    val components = listOf(
        "AlertInfo",
        "AlertWarning",
        "AlertDanger",
        "AlertSuccess",
        "Avatar",
        "Badge",
        "ChatNewMessageBox",
        "ChatScreen",
        "UserCard"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        setContent {
            DevuiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()


                    NavHost(navController = navController, startDestination = "List") {
                        components.forEach {routeName ->
                            composable(routeName){
                                when (routeName) {
                                    "AlertInfo" -> AlertInfo()
                                    "AlertWarning" -> AlertWarning()
                                    "AlertDanger" -> AlertDanger()
                                    "AlertSuccess" -> AlertSuccess()
                                    "Avatar" -> Avatar()
                                    "Badge" -> Badge()
                                    "ChatNewMessageBox" -> ChatNewMessageBox()
                                    "ChatScreen" -> ChatScreen()
                                    "UserCard" -> UserMessageListCard()
                                    else -> {
                                        ListComponent(components = components, navController = navController)
                                    }
                                }
                            }
                        }
                        composable("List") {
                            ListComponent(components = components, navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListComponent(components: List<String>, navController: NavController) {
    LazyColumn {
        items(count = components.size) {
            ListItem(
                text = { Text(text = components[it]) },
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Info,
                        contentDescription = "Warning Icon",
                        modifier = Modifier
                            .size(24.dp)
                            .graphicsLayer {
                                rotationZ = 180f
                            },
                        tint = Color.Yellow
                    )
                },
                modifier = Modifier.clickable {
                    navController.navigate(components[it])
                }
            )
        }
    }
}


@Composable
fun Greeting(name: String) {
    Avatar(src = "https://overreacted.io/static/profile-pic-c715447ce38098828758e525a1128b87.jpg", modifier = Modifier
        .width(100.dp)
        .height(100.dp)
        .padding(10.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DevuiTheme {
        Greeting("Android")
    }
}