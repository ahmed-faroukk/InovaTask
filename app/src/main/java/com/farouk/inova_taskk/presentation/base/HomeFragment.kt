package com.farouk.inova_taskk.presentation.base

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.farouk.inova_taskk.R
import com.farouk.inova_taskk.common.Resource
import com.farouk.inova_taskk.databinding.FragmentHomeBinding
import com.farouk.inova_taskk.presentation.base.adapter.BookAdapter
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private val viewModel: HomeViewModel by activityViewModels()
    private lateinit var binding : FragmentHomeBinding
    private lateinit var adapter: BookAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = binding.recyclerView
        adapter = BookAdapter(emptyList())
        recyclerView.adapter = adapter
        viewModel.booksLiveData.observe(viewLifecycleOwner,  Observer {response ->

            when(response){
                is Resource.Success -> {
                    response.data?.let {
                        adapter = BookAdapter(it)
                    }
                }
                is Resource.Error -> {
                    // handle error
                }
               is Resource.Loading->{

                   // loading bar
                }

                else -> {}
            }
        })


    }


}