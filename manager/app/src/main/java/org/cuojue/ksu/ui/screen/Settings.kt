package org.cuojue.ksu.ui.screen

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.BugReport
import androidx.compose.material.icons.filled.ContactPage
import androidx.compose.material.icons.filled.Fence
import androidx.compose.material.icons.filled.RemoveModerator
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.core.content.FileProvider
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.cuojue.ksu.BuildConfig
import org.cuojue.ksu.Natives
import org.cuojue.ksu.R
import org.cuojue.ksu.ui.component.AboutDialog
import org.cuojue.ksu.ui.component.LoadingDialog
import org.cuojue.ksu.ui.component.SwitchItem
import org.cuojue.ksu.ui.screen.destinations.AppProfileTemplateScreenDestination
import org.cuojue.ksu.ui.util.LocalDialogHost
import org.cuojue.ksu.ui.util.getBugreportFile

/**
 * @author weishu
 * @date 2023/1/1.
 */
@Destination
@Composable
fun SettingScreen(navigator: DestinationsNavigator) {

    Scaffold(
        topBar = {
            TopBar(onBack = {
                navigator.popBackStack()
            })
        }
    ) { paddingValues ->
        LoadingDialog()

        val showAboutDialog = remember { mutableStateOf(false) }
        AboutDialog(showAboutDialog)

        Column(modifier = Modifier.padding(paddingValues)) {

            val context = LocalContext.current
            val scope = rememberCoroutineScope()
            val dialogHost = LocalDialogHost.current

            val profileTemplate = stringResource(id = R.string.settings_profile_template)
            ListItem(
                leadingContent = { Icon(Icons.Filled.Fence, profileTemplate) },
                headlineContent = { Text(profileTemplate) },
                supportingContent = { Text(stringResource(id = R.string.settings_profile_template_summary))},
                modifier = Modifier.clickable {
                     navigator.navigate(AppProfileTemplateScreenDestination)
                }
            )

            var umountChecked by rememberSaveable {
                mutableStateOf(Natives.isDefaultUmountModules())
            }
            SwitchItem(
                icon = Icons.Filled.RemoveModerator,
                title = stringResource(id = R.string.settings_umount_modules_default),
                summary = stringResource(id = R.string.settings_umount_modules_default_summary),
                checked = umountChecked
            ) {
                if (Natives.setDefaultUmountModules(it)) {
                    umountChecked = it
                }
            }

            ListItem(
                leadingContent = { Icon(Icons.Filled.BugReport, stringResource(id = R.string.send_log)) },
                headlineContent = { Text(stringResource(id = R.string.send_log)) },
                modifier = Modifier.clickable {
                    scope.launch {
                        val bugreport = dialogHost.withLoading {
                            withContext(Dispatchers.IO) {
                                getBugreportFile(context)
                            }
                        }

                        val uri: Uri =
                            FileProvider.getUriForFile(
                                context,
                                "${BuildConfig.APPLICATION_ID}.fileprovider",
                                bugreport
                            )

                        val shareIntent = Intent(Intent.ACTION_SEND)
                        shareIntent.putExtra(Intent.EXTRA_STREAM, uri)
                        shareIntent.setDataAndType(uri, "application/zip")
                        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

                        context.startActivity(
                            Intent.createChooser(
                                shareIntent,
                                context.getString(R.string.send_log)
                            )
                        )
                    }
                }
            )

            val about = stringResource(id = R.string.about)
            ListItem(
                leadingContent = { Icon(Icons.Filled.ContactPage, stringResource(id = R.string.about)) },
                headlineContent = { Text(about) },
                modifier = Modifier.clickable {
                    showAboutDialog.value = true
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(onBack: () -> Unit = {}) {
    TopAppBar(
        title = { Text(stringResource(R.string.settings)) },
        navigationIcon = {
            IconButton(
                onClick = onBack
            ) { Icon(Icons.Filled.ArrowBack, contentDescription = null) }
        },
    )
}
