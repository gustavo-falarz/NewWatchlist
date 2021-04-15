package com.gfb.watchlist.main.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.gfb.watchlist.R
import com.gfb.watchlist.databinding.FragmentDetailsBinding
import com.gfb.watchlist.main.model.ContentModel

class DetailsFragment : Fragment() {

    private lateinit var viewModel: DetailsViewModel
    private lateinit var viewModelFactory: DetailsViewModelFactory
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentDetailsBinding>(
            inflater,
            R.layout.fragment_details,
            container,
            false
        )

        viewModelFactory = DetailsViewModelFactory(args.content)
        viewModel = ViewModelProvider(this, viewModelFactory).get(DetailsViewModel::class.java)

        binding.detailsViewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val activity = requireActivity()
        activity.setContent{
            Details()
        }

        return binding.root
    }

    @Composable
    fun Details(){
        val content by viewModel.content.observeAsState()
            Text(content.plot)
    }
}