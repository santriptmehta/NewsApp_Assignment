package com.binarybeast.newsfog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    lateinit var head_title : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        head_title = findViewById(R.id.general_title)


        getNews()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener{
            when (it.itemId){
                R.id.nav_science ->{

                    head_title.text = "Science"
                    val techBtn = NewsService.newsInstance.fetchHeadlines("in","science",Constant.API_KEY)
                    techBtn.enqueue(object : Callback<News>{
                        override fun onResponse(call: Call<News>, response: Response<News>) {
                            val techNewsResponse = response.body()
                            techNewsResponse?.let {
                                recyclerView.adapter = NewsAdapter(techNewsResponse.articles,this@MainActivity)
                            }
                            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                        }

                        override fun onFailure(call: Call<News>, t: Throwable) {
                            Toast.makeText(applicationContext,"Something went wrong",Toast.LENGTH_LONG).show()
                        }

                    })

                }
                R.id.nav_health ->{
                    head_title.text = "Health"
                    val techBtn = NewsService.newsInstance.fetchHeadlines("in","health",Constant.API_KEY)
                    techBtn.enqueue(object : Callback<News>{
                        override fun onResponse(call: Call<News>, response: Response<News>) {
                            val techNewsResponse = response.body()
                            techNewsResponse?.let {
                                recyclerView.adapter = NewsAdapter(techNewsResponse.articles,this@MainActivity)
                            }
                            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                        }

                        override fun onFailure(call: Call<News>, t: Throwable) {
                            Toast.makeText(applicationContext,"Something went wrong",Toast.LENGTH_LONG).show()
                        }

                    })
                }
                R.id.nav_business ->{
                    head_title.text = "Business"
                    val techBtn = NewsService.newsInstance.fetchHeadlines("in","business",Constant.API_KEY)
                    techBtn.enqueue(object : Callback<News>{
                        override fun onResponse(call: Call<News>, response: Response<News>) {
                            val techNewsResponse = response.body()
                            techNewsResponse?.let {
                                recyclerView.adapter = NewsAdapter(techNewsResponse.articles,this@MainActivity)
                            }
                            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                        }

                        override fun onFailure(call: Call<News>, t: Throwable) {
                            Toast.makeText(applicationContext,"Something went wrong",Toast.LENGTH_LONG).show()
                        }

                    })
                }
                R.id.nav_sports ->{
                    head_title.text = "Sports"
                    val techBtn = NewsService.newsInstance.fetchHeadlines("in","sports",Constant.API_KEY)
                    techBtn.enqueue(object : Callback<News>{
                        override fun onResponse(call: Call<News>, response: Response<News>) {
                            val techNewsResponse = response.body()
                            techNewsResponse?.let {
                                recyclerView.adapter = NewsAdapter(techNewsResponse.articles,this@MainActivity)
                            }
                            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                        }

                        override fun onFailure(call: Call<News>, t: Throwable) {
                            Toast.makeText(applicationContext,"Something went wrong",Toast.LENGTH_LONG).show()
                        }

                    })

                }
                R.id.nav_All ->{
                    head_title.text = "Discovery"
                    val techBtn = NewsService.newsInstance.fetchHeadlines("in","general",Constant.API_KEY)
                    techBtn.enqueue(object : Callback<News>{
                        override fun onResponse(call: Call<News>, response: Response<News>) {
                            val techNewsResponse = response.body()
                            techNewsResponse?.let {
                                recyclerView.adapter = NewsAdapter(techNewsResponse.articles,this@MainActivity)
                            }
                            recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                        }

                        override fun onFailure(call: Call<News>, t: Throwable) {
                            Toast.makeText(applicationContext,"Something went wrong",Toast.LENGTH_LONG).show()
                        }

                    })

                }
            }
            true
        }

    }



    private fun getNews() {
        val news = NewsService.newsInstance.fetchHeadlines("in","",Constant.API_KEY)
        news.enqueue(object: Callback<News> {
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val newsResponse = response.body()
                newsResponse?.let {
                    recyclerView.adapter = NewsAdapter(newsResponse.articles,this@MainActivity)
                }
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            }

            override fun onFailure(call: Call<News>, t: Throwable) {

                Log.e("MainActivity",t.message.toString())
            }

        })
    }

}