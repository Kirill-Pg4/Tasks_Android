package com.example.junior

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnimalFragment : Fragment() {

    private lateinit var animalAdapter: AnimalAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_animal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        fetchAnimalsData()
    }

    private fun setupRecyclerView() {
        animalAdapter = AnimalAdapter(emptyList())
        view?.findViewById<RecyclerView>(R.id.animalRecyclerView)?.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = animalAdapter
        }
    }

    private fun fetchAnimalsData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://shibe.online/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val animalApi = retrofit.create(AnimalApi::class.java)
        val call = animalApi.getShibes(count = 10, urls = true, httpsUrls = true)

        call.enqueue(object : Callback<List<String>> {
            override fun onResponse(call: Call<List<String>>, response: Response<List<String>>) {
                if (response.isSuccessful) {
                    val animals = response.body()
                    animals?.let {
                        animalAdapter = AnimalAdapter(it)
                        view?.findViewById<RecyclerView>(R.id.animalRecyclerView)?.adapter = animalAdapter
                    }
                }
            }

            override fun onFailure(call: Call<List<String>>, t: Throwable) {
                // Handle failure
            }
        })
    }
}
