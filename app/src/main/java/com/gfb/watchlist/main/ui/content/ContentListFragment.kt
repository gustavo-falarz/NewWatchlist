package com.gfb.watchlist.main.ui.content

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.gfb.watchlist.R
import com.gfb.watchlist.databinding.FragmentContentListBinding
import com.gfb.watchlist.main.model.ContentModel


class ContentListFragment : Fragment() {

    private val viewModel: ContentListViewModel by lazy {
        val activity = requireNotNull(this.activity)
        ViewModelProvider(this, ContentListViewModel.Factory(activity.application))
            .get(ContentListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentContentListBinding>(
            inflater,
            R.layout.fragment_content_list,
            container,
            false
        )

        bindViews(binding)

        return binding.root
    }

    private fun bindViews(binding: FragmentContentListBinding) {

        val adapter = ContentAdapter {
            viewModel.onContentSelected(it)
        }

        binding.contentList.adapter = adapter

        viewModel.contentList.observe(viewLifecycleOwner, {
            updateList(it, adapter)
        })

        viewModel.navigateToContentDetail.observe(viewLifecycleOwner, {
            navigateToDetails(it)
        })
    }

    private fun navigateToDetails(content: ContentModel) {
        val action =
            ContentListFragmentDirections.actionContentListFragmentToDetailsFragment(content)
        this.findNavController().navigate(action)
    }

    private fun updateList(it: List<ContentModel>, adapter: ContentAdapter) {
        it.let {
            adapter.submitList(it)
        }
    }

}
