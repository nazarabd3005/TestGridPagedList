package com.nazar.testgridandroid.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.nazar.testgridandroid.R
import com.nazar.testgridandroid.databinding.FragmentMainBinding
import com.nazar.testgridandroid.util.ViewModelFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MainFragment : Fragment(){

    private lateinit var adapter: MainAdapter
    private lateinit var mainViewModel: MainViewModel
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : FragmentMainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main,container,false)
        mainViewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        binding.model = mainViewModel
        adapter = MainAdapter()
        binding.adapter = adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mainViewModel.getImageList().observe(viewLifecycleOwner, Observer {
            it?.let { adapter.submitList(it)  }
        })
    }
}