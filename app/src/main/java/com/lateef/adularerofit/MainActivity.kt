package com.lateef.adularerofit

import android.graphics.Color
import android.net.Network
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lateef.adularerofit.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ProductAdapter


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        recyclerView = binding.recyclerProduct

        apicall()

    }

    private fun apicall(){

        val request = RetrofitProduct.api.getProductslist()

       request.enqueue(object: Callback<List<ProdutdtoItem>> {
           override fun onResponse(call: Call<List<ProdutdtoItem>>, response: Response<List<ProdutdtoItem>>) {
               try {
                   if (response.isSuccessful) {
                       val list = response.body() as ArrayList<ProdutdtoItem>
                       adapter = ProductAdapter(this@MainActivity, list)
                       recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                       val divider = DividerItemDecoration(
                           this@MainActivity,
                           DividerItemDecoration.VERTICAL
                       )
                       recyclerView.addItemDecoration(divider)

                       recyclerView.adapter = adapter

                       adapter.setData(list)
                   } else {
                       Toast.makeText(
                           this@MainActivity,
                           "error occur or check Internet Connection",
                           Toast.LENGTH_LONG
                       ).show()
                       return
                   }

               }catch (e: Exception){
                   Toast.makeText(this@MainActivity,  "error occurred", Toast.LENGTH_LONG).show()
               }
           }

           override fun onFailure(call: Call<List<ProdutdtoItem>>, t: Throwable) {
               Toast.makeText(this@MainActivity,  "error occurred", Toast.LENGTH_LONG).show()
           }


       })



    }

}