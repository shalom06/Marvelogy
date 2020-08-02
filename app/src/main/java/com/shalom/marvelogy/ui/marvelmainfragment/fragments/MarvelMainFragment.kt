package com.shalom.marvelogy.ui.marvelmainfragment.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.shalom.marvelogy.R
import com.shalom.marvelogy.ui.marvelmainfragment.viewmodel.MarvelMainViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class MarvelMainFragment : Fragment(R.layout.fragment_first) {
    private val viewModel: MarvelMainViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}