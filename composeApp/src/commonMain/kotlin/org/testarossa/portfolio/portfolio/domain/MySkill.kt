package org.testarossa.portfolio.portfolio.domain

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ListAlt
import androidx.compose.material.icons.filled.BugReport
import androidx.compose.material.icons.filled.CloudQueue
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.Storage
import androidx.compose.material.icons.outlined.BugReport
import androidx.compose.material.icons.outlined.Code
import androidx.compose.material.icons.outlined.DeviceHub
import androidx.compose.material.icons.outlined.ListAlt
import androidx.compose.material.icons.outlined.Mediation
import androidx.compose.material.icons.outlined.Palette
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.rounded.Storage
import androidx.compose.ui.graphics.vector.ImageVector
import myportfolio.composeapp.generated.resources.Res
import myportfolio.composeapp.generated.resources.accessibility
import myportfolio.composeapp.generated.resources.android_sdk
import myportfolio.composeapp.generated.resources.android_studio
import myportfolio.composeapp.generated.resources.animation
import myportfolio.composeapp.generated.resources.architecture
import myportfolio.composeapp.generated.resources.backend
import myportfolio.composeapp.generated.resources.clean_architecture
import myportfolio.composeapp.generated.resources.clickup
import myportfolio.composeapp.generated.resources.code_review
import myportfolio.composeapp.generated.resources.coroutine
import myportfolio.composeapp.generated.resources.custom_view
import myportfolio.composeapp.generated.resources.data_management
import myportfolio.composeapp.generated.resources.data_store
import myportfolio.composeapp.generated.resources.dependency_injection
import myportfolio.composeapp.generated.resources.espresso
import myportfolio.composeapp.generated.resources.figma
import myportfolio.composeapp.generated.resources.firebase
import myportfolio.composeapp.generated.resources.git
import myportfolio.composeapp.generated.resources.intellij
import myportfolio.composeapp.generated.resources.java
import myportfolio.composeapp.generated.resources.jetpack_compose
import myportfolio.composeapp.generated.resources.kotlin
import myportfolio.composeapp.generated.resources.material_design
import myportfolio.composeapp.generated.resources.mobile_development
import myportfolio.composeapp.generated.resources.mockito
import myportfolio.composeapp.generated.resources.mvi
import myportfolio.composeapp.generated.resources.mvvm
import myportfolio.composeapp.generated.resources.postman
import myportfolio.composeapp.generated.resources.rest
import myportfolio.composeapp.generated.resources.websocket
import myportfolio.composeapp.generated.resources.retrofit
import myportfolio.composeapp.generated.resources.room
import myportfolio.composeapp.generated.resources.testing
import myportfolio.composeapp.generated.resources.ui_ux
import myportfolio.composeapp.generated.resources.unit_test
import org.jetbrains.compose.resources.StringResource

val MY_SKILLS = listOf(
    MySkill(
        Icons.Default.PhoneAndroid,
        Res.string.mobile_development,
        listOf(Res.string.kotlin to 95, Res.string.java to 90, Res.string.android_sdk to 95, Res.string.jetpack_compose to 95)
    ),
    MySkill(
        Icons.Default.Code,
        Res.string.architecture,
        listOf(Res.string.mvvm to 92, Res.string.mvi to 92, Res.string.clean_architecture to 88, Res.string.dependency_injection to 85)
    ),
    MySkill(
        Icons.Default.Storage,
        Res.string.data_management,
        listOf(Res.string.room to 90, Res.string.data_store to 92, Res.string.retrofit to 92, Res.string.coroutine to 88)
    ),
    MySkill(
        Icons.Default.CloudQueue,
        Res.string.backend,
        listOf(Res.string.firebase to 85, Res.string.rest to 90, Res.string.websocket to 70)
    ),
    MySkill(
        Icons.Outlined.Palette,
        Res.string.ui_ux,
        listOf(Res.string.material_design to 90, Res.string.custom_view to 85, Res.string.animation to 80, Res.string.accessibility to 88)
    ),
    MySkill(
        Icons.Outlined.BugReport,
        Res.string.testing,
        listOf(Res.string.unit_test to 85, Res.string.espresso to 80, Res.string.mockito to 80, Res.string.code_review to 90)
    ),
)

val MY_TOOLS = listOf(
    MySkill(
        Icons.Outlined.Mediation,
        Res.string.git,
        emptyList()
    ),
    MySkill(
        Icons.Outlined.Settings,
        Res.string.android_studio,
        emptyList()
    ),
    MySkill(
        Icons.Outlined.Code,
        Res.string.intellij,
        emptyList()
    ),
    MySkill(
        Icons.Rounded.Storage,
        Res.string.postman,
        emptyList()
    ),
    MySkill(
        Icons.Outlined.Palette,
        Res.string.figma,
        emptyList()
    ),
    MySkill(
        Icons.AutoMirrored.Outlined.ListAlt,
        Res.string.clickup,
        emptyList()
    ),
)

data class MySkill(
    val icon: ImageVector,
    val title: StringResource,
    val listSkill: List<Pair<StringResource, Int>>
)

