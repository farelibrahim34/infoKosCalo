package com.projectfarrel.infokosadmin.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.projectfarrel.infokosadmin.databinding.ActivityMapsBinding
import com.projectfarrel.infokosadmin.databinding.ActivityRegisterBinding
import com.projectfarrel.infokosadmin.view.isi.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MapsActivity : AppCompatActivity() {
    lateinit var binding : ActivityMapsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val linkLocation = intent.getStringExtra("linkMaps")
        binding.webView.webViewClient = WebViewClient()
        binding.webView.loadUrl(linkLocation.toString())
        val webSettings = binding.webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true

        binding.ivBackDetail.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
        }
    }
}