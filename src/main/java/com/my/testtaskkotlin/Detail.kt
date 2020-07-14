package com.my.testtaskkotlin

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class Detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        var textViewName=findViewById<TextView>(R.id.textViewName)
        var textViewEmail=findViewById<TextView>(R.id.textViewEmail)
        var textViewAge=findViewById<TextView>(R.id.textViewAge)
        var textViewCellPhone=findViewById<TextView>(R.id.textViewCellPhone)
        var imageView=findViewById<ImageView>(R.id.imageViewPictureDeteil)
        textViewName.text=intent.getStringExtra("NAME")
        textViewEmail.text=intent.getStringExtra("EMAIL")
        textViewCellPhone.text=intent.getStringExtra("NUMBER")
        var imagePath=intent.getStringExtra("IMAGE")
        Picasso.with(this).load(imagePath).into(imageView)
        var age=intent.getIntExtra("AGE",0)
        textViewAge.text=age.toString()
        textViewCellPhone.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                call(textViewCellPhone.text.toString())
            }
        })
    }
    private fun call(textViewCellPhone:String){
        var s:String= "tel:$textViewCellPhone"
        var intentMy=Intent(Intent.ACTION_DIAL)
        intentMy.setData(Uri.parse(s))
        startActivity(intentMy)
    }
}
