package elieoko.me.butterfly

import android.os.Bundle
import androidx.activity.*
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import elieoko.me.butterfly.core.network.connectivity.AndroidConnectivityObserver
import elieoko.me.butterfly.core.network.connectivity.ConnectivityViewModel
import elieoko.me.butterfly.core.ui.theme.ButterflyTheme
import elieoko.me.butterfly.view.navigation.NavigationRoot

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val connectivityViewModel = viewModel<ConnectivityViewModel> {
                ConnectivityViewModel(
                    connectivityObserver = AndroidConnectivityObserver(
                        context = applicationContext
                    )
                )
            }
            val isConnected by connectivityViewModel.isConnected.collectAsStateWithLifecycle()
            ButterflyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationRoot(modifier = Modifier
                        .padding(innerPadding))
                }
            }
        }
    }
}