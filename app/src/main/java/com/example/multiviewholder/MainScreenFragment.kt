package com.example.multiviewholder

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multiviewholder.databinding.FragmentMainScreenBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainScreenFragment : Fragment() {

    private lateinit var binding: FragmentMainScreenBinding
    private var list: Data? = null
    private lateinit var mcontext: Context
    private var storeData: ApiData? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mcontext = context
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_main_screen, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        getStoreData()



        super.onViewCreated(view, savedInstanceState)
    }


    private fun addData() {
        if (storeData == null) return
        val cake = listOf(
            R.drawable.cake1,
            R.drawable.cake2,
            R.drawable.cake3,
            R.drawable.cake4,
            R.drawable.cake5
        )
        val offer = listOf(
            R.drawable.cake1,
            R.drawable.cake2,
            R.drawable.cake3,
            R.drawable.cake4,
            R.drawable.cake5
        )
        list = Data(cake, storeData!!, offer)

    }

    fun setLayout() {
        list?.let {
            binding.recyclerview.layoutManager = LinearLayoutManager(mcontext)
            binding.recyclerview.adapter = MainAdapter(mcontext, it)
        }

    }

    fun getStoreData() {
        val retrofit = ServiceBuilder.buildServices(ApiInterface::class.java)
        val retroData = retrofit.getData()
        retroData.enqueue(object : Callback<ApiData> {
            override fun onResponse(call: Call<ApiData>, response: Response<ApiData>) {
                if (response.isSuccessful) {
                    storeData = response.body()
                    addData()
                    setLayout()
                    Log.e("getData", storeData.toString())
                }
            }

            override fun onFailure(call: Call<ApiData>, t: Throwable) {
                Log.e("getData", "Failure: ${t.message}")
            }

        })

    }
}