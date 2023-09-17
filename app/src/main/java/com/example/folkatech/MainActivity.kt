package com.example.folkatech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.folkatech.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listProduct: List<ResponseData>
    private lateinit var product: ResponseData
    private lateinit var factory: ViewModelFactory

    private val model: ViewModel by lazy {
        ViewModelProvider(this, factory)[ViewModel::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        factory = ViewModelFactory.getInstance()

        //Setting on click for the bottom navigation
        binding.cardView.setOnClickListener {
            Log.d("cekKlik", "klik")
            val modalBottomSheet = BottomNavFragment()
            modalBottomSheet.show(supportFragmentManager, BottomNavFragment.TAG)
        }

        //hit the api
        model.getData()

        //get the api response and display the data
        model.data.observe(this) {
            listProduct = it
            listProduct.map { responseData ->
                product = responseData
            }

            val adapter = Adapter(listProduct) { product ->
                (this).goToDetail(product.id)
            }
            binding.progressBar.visibility = GONE
            binding.recyclerView.layoutManager = GridLayoutManager(this, 2)
            binding.recyclerView.adapter = adapter
        }

        //Setting pull Refresh and hit the api again
        binding.swipeRefreshLayout.setOnRefreshListener {
            binding.recyclerView.visibility = GONE
            model.getData()

            val handler = Handler()
            handler.postDelayed({
                binding.swipeRefreshLayout.isRefreshing = false
                binding.recyclerView.visibility = VISIBLE
            }, 1000)

        }


    }

    //Navigate to the detail product page
    private fun goToDetail(id: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("id", id)
        Log.d("cekId", id.toString())
        startActivity(intent)
    }
}