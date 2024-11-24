package com.teslakitty.browsercat

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

/**
 * MainActivity for BrowserCat app.
 */
class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
