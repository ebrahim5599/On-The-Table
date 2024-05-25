package com.example.onthetableapp.ui.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.onthetableapp.MainActivity
import com.example.onthetableapp.R

class FavoriteFragment : Fragment() {

    private lateinit var viewModel : FavoriteViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_favorite, container, false)
        // Set toolbar title
        (activity as MainActivity).supportActionBar?.title = "Favorite"
        // Remove back button from toolbar
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        return view
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }


}