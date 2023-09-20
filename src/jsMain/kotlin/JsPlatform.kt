class JsPlatform : Platform {
    override val name: String
        get() = "JS"
}

actual fun getPlatform(): Platform = JsPlatform()