package pl.kacper.misterski.feature.onboarding.ui.navigation


internal sealed class NavigationItem(
    val route: String,
) {
    data object Email : NavigationItem(Screen.EMAIL.name)

    data object FullName : NavigationItem(Screen.FULL_NAME.name)

    data object Phone : NavigationItem(Screen.PHONE.name)

    data object Photo : NavigationItem(Screen.PHOTO.name)

    data object Summary : NavigationItem(Screen.SUMMARY.name)

}