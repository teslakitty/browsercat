package com.teslakitty.browsercat

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.FragmentActivity

/**
 * MainActivity for BrowserCat app on Android TV.
 */
class MainActivity : FragmentActivity() {

    private lateinit var webView: WebView
    private lateinit var urlEditText: EditText
    private lateinit var loadButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize WebView
        webView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true // Enable JavaScript
        webView.webViewClient = WebViewClient()  // Handle navigation inside WebView

        // Initialize EditText for URL input
        urlEditText = findViewById(R.id.editTextText)
        urlEditText.requestFocus() // Focus on EditText to start typing immediately

        // Initialize Button
        loadButton = findViewById(R.id.loadButton)

        // Set button click listener to load the URL into WebView
        loadButton.setOnClickListener {
            val url = urlEditText.text.toString().trim()

            if (url.isNotEmpty()) {
                // Add "http://" if the user didn't input a scheme (e.g., "www.example.com" should be turned into "http://www.example.com")
                val validUrl = if (url.startsWith("http://") || url.startsWith("https://")) {
                    url
                } else {
                    "http://$url"
                }

                // Load the URL into the WebView
                webView.loadUrl(validUrl)
            }
        }

        // Load a default page initially
        webView.loadUrl("https://www.google.com")
    }

    // Handle back press for WebView navigation
    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()  // Navigate back in WebView history
        } else {
            super.onBackPressed()  // Exit app if WebView history is empty
        }
    }
}
