package com.example.folkatech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.VISIBLE
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.folkatech.databinding.ActivityDetailBinding
import com.example.folkatech.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var factory: ViewModelFactory
    private val model: ViewModel by lazy {
        ViewModelProvider(this, factory)[ViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        factory = ViewModelFactory.getInstance()

        //Setting Icon on Toolbar to naviagte back
        val toolbar: androidx.appcompat.widget.Toolbar = binding.cartToolbar
        val navigationIcon: View = toolbar
        navigationIcon.setOnClickListener {
            finish()
        }

        //Get the product Id from Main Activity
        val id = intent.getIntExtra("id", 0)
        Log.d("cekId", id.toString())

        //display the data
        model.data.observe(this) {
            val title = it[id-1].name
            val price = it[id-1].price
            val cover = it[id-1].cover
            val desc = it[id-1].desc
            Glide.with(this)
                .load(cover)
                .into(binding.image)
            binding.itemTitle.text = title
            binding.itemPrice.text = price.toString()
            binding.desc.text = desc
        }

    }

}