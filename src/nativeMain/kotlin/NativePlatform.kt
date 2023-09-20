class NativePlatform:Platform {
    override val name: String
        get() = "Native"
}

actual fun getPlatform():Platform = NativePlatform()