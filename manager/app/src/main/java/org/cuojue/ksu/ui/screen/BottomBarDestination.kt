package org.cuojue.ksu.ui.screen

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.ramcosta.composedestinations.spec.DirectionDestinationSpec
import org.cuojue.ksu.R
import org.cuojue.ksu.ui.screen.destinations.HomeScreenDestination
import org.cuojue.ksu.ui.screen.destinations.SuperUserScreenDestination
import org.cuojue.ksu.ui.screen.destinations.ModuleScreenDestination

enum class BottomBarDestination(
    val direction: DirectionDestinationSpec,
    @StringRes val label: Int,
    val iconSelected: ImageVector,
    val iconNotSelected: ImageVector,
    val rootRequired: Boolean,
) {
    Home(HomeScreenDestination, R.string.home, Icons.Filled.Home, Icons.Outlined.Home, false),
    SuperUser(SuperUserScreenDestination, R.string.superuser, Icons.Filled.Security, Icons.Outlined.Security, true),
    Module(ModuleScreenDestination, R.string.module, Icons.Filled.Apps, Icons.Outlined.Apps, true)
}
