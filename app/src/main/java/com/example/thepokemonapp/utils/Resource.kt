import android.app.Application
import android.content.Context
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        private var instance: MyApplication? = null

        fun getContext(): Context {
            return instance!!.applicationContext
        }
    }
}


object Resource {
    fun getString(@StringRes id: Int): String {
        return MyApplication.getContext().getString(id)
    }

    fun getDrawable(@DrawableRes id: Int): Drawable {
        return MyApplication.getContext().getDrawable(id)!!
    }
}
