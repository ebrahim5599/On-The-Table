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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onthetableapp.MainActivity
import com.example.onthetableapp.R
import com.example.onthetableapp.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private lateinit var searchViewModel: SearchViewModel
    private lateinit var searchCountryAdapter: SearchCountryAdapter
    private lateinit var searchCategoryAdapter: SearchCategoryAdapter
    private lateinit var searchIngredientAdapter: SearchIngredientAdapter


    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val view = binding.root

        // Set toolbar title
        (activity as MainActivity).supportActionBar?.title = "Search"
        // Remove back button from toolbar
        (activity as MainActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)

        searchViewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        searchViewModel.getCuisine()
        searchViewModel.cuisineMutableLiveData.observe(viewLifecycleOwner, Observer { s ->
            searchCountryAdapter = SearchCountryAdapter(s.meals)
            binding.countriesRecyclerView.adapter = searchCountryAdapter
            binding.countriesRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        })

        searchViewModel.getCategory()
        searchViewModel.categoryMutableLiveData.observe(viewLifecycleOwner, Observer { o ->
            searchCategoryAdapter = SearchCategoryAdapter(o.categories, context)
            binding.categoriesRecyclerView.adapter = searchCategoryAdapter
            binding.categoriesRecyclerView.layoutManager = LinearLayoutManager(context)

        })

        searchViewModel.getIngredient()
        searchViewModel.ingredientMutableLiveData.observe(viewLifecycleOwner, Observer { i ->
            searchIngredientAdapter = SearchIngredientAdapter(i.meals, context)
            binding.ingredientsRecyclerView.adapter = searchIngredientAdapter
            binding.ingredientsRecyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
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