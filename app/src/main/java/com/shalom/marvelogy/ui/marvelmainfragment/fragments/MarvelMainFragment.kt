package com.shalom.marvelogy.ui.marvelmainfragment.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.shalom.marvelogy.R
import com.shalom.marvelogy.ui.marvelmainfragment.state.MainStateEvent.GetCharacters
import com.shalom.marvelogy.ui.marvelmainfragment.viewmodel.MarvelMainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

@AndroidEntryPoint
class MarvelMainFragment : Fragment(R.layout.fragment_first) {
    private val viewModel: MarvelMainViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.dataState.observe(viewLifecycleOwner, Observer { it ->
            it?.loading?.let { loading ->
                if (loading) progress_bar.visibility = View.VISIBLE
                else progress_bar.visibility = View.GONE
            }
            it?.message?.let { error ->
                textview_first.text = error
            }
        })

        viewModel.viewState.observe(viewLifecycleOwner, Observer {
            it.charactersApiResponse?.let { characters ->
                textview_first.text = characters.data.results.first().name
            }
        })
        button_first.setOnClickListener {
            viewModel.updateStateEvent(GetCharacters)
        }

    }

}