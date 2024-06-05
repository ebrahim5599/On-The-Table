package com.example.onthetableapp.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.onthetableapp.MainActivity
import com.example.onthetableapp.R

class SearchFragment : Fragment() {

    lateinit var searchViewModel: SearchViewModel
    lateinit var searchCountryAdapter: SearchCountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_search, container, false)

        // Set toolbar title
        (activity as MainActivity).supportActionBar?.title = "Search"
        // Remove back button from toolbar
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        searchViewModel.getCuisine()
        searchViewModel.cuisineMutableLiveData.observe(viewLifecycleOwner, Observer { s ->
            searchCountryAdapter = SearchCountryAdapter(s)
        })

        return view
    }

    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search_menu, menu)
    }

    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.search -> {
                Toast.makeText(context, "Search", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}