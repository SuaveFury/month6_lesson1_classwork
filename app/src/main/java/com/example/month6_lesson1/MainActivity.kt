package com.example.month6_lesson1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.month6_lesson1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListeners()
        }
    private val array = arrayListOf(
        "https://www.cnet.com/a/img/resize/50e11858414030f7ace1dd3d92f7d24e5f4c5ce8/hub/2023/01/17/91eb6502-7246-430f-aa5f-e99f7cdea3ac/rs-2024-chevrolet-corvette-e-ray-3lz-006.jpg?auto=webp&fit=crop&height=620&width=620",
        "https://imageio.forbes.com/specials-images/imageserve/5f962df3991e5636a2f68758/0x0.jpg?format=jpg&crop=812,457,x89,y103,safe&width=1200",
        "https://www.mitsubishicars.com/content/dam/mitsubishi-motors-us/images/siteimages/events/2022-year-end-sales/2022-mitsubishi-outlander-phev-white-desert-m.jpg",
        "https://assets-eu-01.kc-usercontent.com/3b3d460e-c5ae-0195-6b86-3ac7fb9d52db/2088033c-b4e3-4ca8-b477-0e3f112b617b/Polo%20Mob.jpg?width=720&fm=jpg&auto=format",
        "https://s7d1.scene7.com/is/image/volkswagen/VW_NGW6_Homepage_Vehicle_Large_2022_09_15?Zml0PWNyb3AlMkMxJndpZD04MDAmaGVpPTgwMCZmbXQ9anBlZyZxbHQ9NzkmYmZjPW9mZiYxMjM4"
    )
    private fun initListeners(){
        binding.btnSubmit.setOnClickListener {
            if (binding.editText.text.isNotEmpty() && Patterns.WEB_URL.matcher(binding.editText.text.toString()).matches()) {
                array.add(binding.editText.text.toString())
                Toast.makeText(this, getString(R.string.added_into_array), Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this,getString(R.string.error_image), Toast.LENGTH_SHORT).show()
            }
            binding.editText.text.clear()
        }
        binding.btnRandom.setOnClickListener {
            Glide.with(this).load(array.random()).into(binding.ivImage)
        }
    }
}