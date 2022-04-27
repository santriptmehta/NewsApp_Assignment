package com.binarybeast.newsfog

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.browser.customtabs.CustomTabsIntent
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class ArticleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        val image = intent.getStringExtra("image")
        val title = intent.getStringExtra("title")
        val author = intent.getStringExtra("author")
        val desc = intent.getStringExtra("desc")
        val url = intent.getStringExtra("url")

        val articleImage: ImageView = findViewById(R.id.image)
        val articleText: TextView = findViewById(R.id.title)
        val articleAuthor: TextView = findViewById(R.id.author)
        val articleDesc: TextView = findViewById(R.id.desc)
        val read_moreButton : Button = findViewById(R.id.read_more_button)
        Glide.with(this)
            .load(image)
            .into(articleImage)
        articleText.text = title
        articleAuthor.text = author
        articleDesc.text = desc
        read_moreButton.setOnClickListener {
            /*val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(urlIntent)*/
            val customTabIntent = CustomTabsIntent.Builder().build()
            customTabIntent.launchUrl(this, Uri.parse(url))
        }
    }
}