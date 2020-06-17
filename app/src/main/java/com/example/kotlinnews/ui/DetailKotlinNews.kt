package com.example.kotlinnews.ui

import android.os.Bundle
import android.view.*
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.kotlinnews.MainActivity

import com.example.kotlinnews.R
import com.example.kotlinnews.databinding.DetailKotlinNewsFragmentBinding

class DetailKotlinNews : Fragment() {

    companion object {
        fun newInstance() = DetailKotlinNews()
    }

    private lateinit var binding: DetailKotlinNewsFragmentBinding
    private val args: DetailKotlinNewsArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.detail_kotlin_news_fragment,
            container,
            false
        )
        onBackPressed()
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.requiredInfo = args.requiredInfo
        (activity as MainActivity).supportActionBar?.title = args.requiredInfo?.title
    }

    private fun onBackPressed() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.wv.canGoBack()) {
                    binding.wv.goBack()
                } else {
                    isEnabled = false
                    requireActivity().onBackPressed()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }
}
