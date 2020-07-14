package com.my.testtaskkotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.my.testtaskkotlin.db.Profile
import com.my.testtaskkotlin.db.ProfileDatabase
import com.my.testtaskkotlin.db.ProfileViewModel
import com.my.testtaskkotlin.retrofit.Example
import com.my.testtaskkotlin.retrofit.ProfileService
import com.my.testtaskkotlin.retrofit.Result
import com.my.testtaskkotlin.retrofit.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private var list: List<Profile> = ArrayList()

    private val MY_TEG = "MY TEG"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //room
        //find dao from db
        var dao = ProfileDatabase.getInstance(this.application).profileDAO
        //find repository
        var repository = ProfileRepository(dao)
        //find ViewModel
        var viewModel = ProfileViewModel(repository)


        //retrofit
        val restService = RetrofitInstance.getRetrofitInstance().create(ProfileService::class.java)

        val call = restService.getProfiles()
        call.enqueue(object : Callback<Example> {
            override fun onFailure(call: Call<Example>, t: Throwable) {
                Toast.makeText(applicationContext, "Error reading JSON", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Example>, response: Response<Example>) {
                val body = response.body()
                val results = body?.results
                Log.i(MY_TEG, results?.size.toString())
                if (results != null) {
                    for (result in results) {
                        getDataFromResponse(result,viewModel)
                    }
                }
            }

        })

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager


        val myAdapter = MyAdapter()
        viewModel.profiles.observe(this, Observer {
            for (i in it) {
                Log.i(MY_TEG, i.toString())
                myAdapter.setListProfiles(it)
                this.list = it
                //create seter for Adapter
            }
        })
        recyclerView.adapter = myAdapter
        myAdapter.setOnItemClickListener(object : MyAdapter.OnItemClickListener {
            override fun setOnClickListener(position: Int) {
                Toast.makeText(applicationContext, "Click" + position, Toast.LENGTH_LONG).show()
                putDataInDetailActivity(position)
            }
        })
    }

    private fun putDataInDetailActivity(position: Int) {
        Log.i(MY_TEG, "----------------------" + position.toString())
        val intent: Intent = Intent(this@MainActivity, Detail::class.java)
        intent.putExtra("NAME", list.get(position)._name)
        intent.putExtra("AGE", list.get(position)._age)
        intent.putExtra("IMAGE", list.get(position)._imageURL)
        intent.putExtra("EMAIL", list.get(position)._mailAddress)
        intent.putExtra("NUMBER", list.get(position)._number)
        startActivity(intent)
    }

    private fun getDataFromResponse(
        result: Result,
        viewModel: ProfileViewModel
    ) {
        val cellPHone = result.cell
        val email = result.email
        //object Name
        val name = result.name
        val fulName = name?.first + name?.last
        //object picture
        val picture = result.picture
        val largePicture = picture?.large
        //get Dob
        val dob = result.dob
        val age = dob?.age
         putDataInProfileClass(cellPHone, email, fulName, largePicture, age,viewModel)

    }

    private fun putDataInProfileClass(
        cellPHone: String?,
        email: String?,
        fulName: String,
        largePicture: String?,
        age: Int?,
        viewModel: ProfileViewModel
    ) {

         var newProfile=Profile(
            _name = fulName,
            _mailAddress = email,
            _number = cellPHone,
            _imageURL = largePicture,
            _age = age
        )
        CoroutineScope(Main).launch {
            //viewModel.clearAll()
            viewModel.insert(newProfile)

        }
    }
}
