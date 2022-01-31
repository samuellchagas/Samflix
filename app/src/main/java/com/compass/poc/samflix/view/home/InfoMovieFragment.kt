package com.compass.poc.samflix.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.compass.poc.samflix.databinding.FragmentInfoMovieBinding
import com.compass.poc.samflix.presentation.home.InfoMovieViewModel
import com.compass.poc.samflix.utils.snackBar
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class InfoMovieFragment : Fragment(){

    private val binding: FragmentInfoMovieBinding by lazy {
        FragmentInfoMovieBinding.inflate(layoutInflater)
    }
    private val viewModel: InfoMovieViewModel by viewModel()
    private val arguments: InfoMovieFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onResume() {
        super.onResume()

        viewModel.getDetailsMovie(movieId = arguments.movieId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.infoMovieToobar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        viewModel.loading.observe(viewLifecycleOwner, { visibility ->
            with(binding) {
                backgroundLoading.isVisible = visibility
                loading.isVisible = visibility
            }
        })

        viewModel.sucessResponseDetailsMovie.observe(viewLifecycleOwner, { detailsMovie ->
            Picasso.get().load(detailsMovie.urlImage).into(binding.imageInfoMovie)
            binding.titleInfoMovie.text = detailsMovie.title
            binding.popularityInfoMovie.text = detailsMovie.popularity.toString()
            binding.dateInfoMovie.text = detailsMovie.date
            binding.runtimeInfoMovie.text = detailsMovie.runtime
            if (detailsMovie.tagline.isNullOrEmpty()) {
                binding.taglineInfoMovie.isVisible = false
            } else {
                binding.taglineInfoMovie.text = detailsMovie.tagline
            }
            binding.textSinopseInfoMovie.text = detailsMovie.sinopse
        })

        viewModel.errorResponseDetailsMovie.observe(viewLifecycleOwner, { message ->
            view.snackBar(message = message, duration = Snackbar.LENGTH_LONG)
        })

        viewModel.errorGenericApp.observe(viewLifecycleOwner, { message ->
            view.snackBar(message = message, duration = Snackbar.LENGTH_LONG)
        })

    }


}