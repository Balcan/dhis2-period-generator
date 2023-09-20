import kotlin.js.ExperimentalJsExport
import kotlin.js.JsExport

@ExperimentalJsExport
@JsExport
class Greetings {
    private val platform: Platform = getPlatform()
    fun greet():String{
        return "Hello, ${platform.name}!"
    }
}