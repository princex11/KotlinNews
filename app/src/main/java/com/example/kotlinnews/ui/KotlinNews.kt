package com.example.kotlinnews.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.kotlinnews.R
import com.example.kotlinnews.adapters.KotlinNewsAdapter
import com.example.kotlinnews.databinding.KotlinNewsFragmentBinding

class KotlinNews : Fragment() {

    companion object {
        fun newInstance() = KotlinNews()
    }
    private lateinit var binding: KotlinNewsFragmentBinding
    private lateinit var viewModel: KotlinNewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.kotlin_news_fragment, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(KotlinNewsViewModel::class.java)
        binding.rv.layoutManager = LinearLayoutManager(requireContext())
        binding.rv.apply {
            viewModel.response.observe(viewLifecycleOwner, Observer {
                viewModel.showHideProgressBar(binding)
                adapter = KotlinNewsAdapter(it)
                setHasFixedSize(true)
            })
        }
    }
}
