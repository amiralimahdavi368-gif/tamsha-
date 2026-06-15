class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hideSystemUI()   // فعال کردن فول‌اسکرین
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideSystemUI() // هر بار فوکوس برگشت دوباره مخفی کن
        }
    }

    private fun hideSystemUI() {
        window.setDecorFitsSystemWindows(false)

        window.insetsController?.apply {
            hide(android.view.WindowInsets.Type.statusBars())
            hide(android.view.WindowInsets.Type.navigationBars())
            systemBarsBehavior =
                android.view.WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
}
