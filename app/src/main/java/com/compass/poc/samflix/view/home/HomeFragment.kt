package com.compass.poc.samflix.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.compass.poc.samflix.databinding.FragmentHomeBinding
import com.compass.poc.samflix.model.MovieItemAdapter
import com.compass.poc.samflix.presentation.home.HomeViewModel
import com.compass.poc.samflix.view.home.adapter.HomeMovieLinearAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment(), HomeMovieLinearAdapter.HomeMovieClickListener {

    private val binding: FragmentHomeBinding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }
    private val viewModel: HomeViewModel by viewModel()
    private val adapter = HomeMovieLinearAdapter(this@HomeFragment)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.listMovies.adapter = adapter

        viewModel.getTopMovies()

        viewModel.sucessResponseListTopMovies.observe(viewLifecycleOwner,{ listMovies ->
            adapter.setData(listMovies)
        })

        viewModel.errorResponseListTopMovies.observe(viewLifecycleOwner,{ message ->
            Toast.makeText(requireContext(), "$message", Toast.LENGTH_SHORT).show()
        })

    }

    override fun movieClickedListener(data: MovieItemAdapter) {
        Toast.makeText(requireContext(), "clicou em um filme", Toast.LENGTH_SHORT).show()
    }

}