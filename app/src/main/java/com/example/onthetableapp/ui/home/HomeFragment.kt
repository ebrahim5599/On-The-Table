package com.example.onthetableapp.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.bumptech.glide.Glide
import com.example.onthetableapp.MainActivity
import com.example.onthetableapp.R
import com.example.onthetableapp.data.remote.entity.Meals
import com.example.onthetableapp.data.remote.entity.MealsArrayListModel
import com.example.onthetableapp.data.remote.network.MealsApiInterface
import com.example.onthetableapp.data.remote.network.RetrofitClient
import com.example.onthetableapp.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        // Set toolbar title
        (activity as MainActivity).supportActionBar?.title = "Home"

        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.overflow_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.exit -> {
                        Toast.makeText(context, "exit", Toast.LENGTH_SHORT).show()
                        return true
                    }

                    else -> false
                }
            }
        }, viewLifecycleOwner)

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.getMealsArraylist()

        homeViewModel.mealsMutableLiveData.observe(viewLifecycleOwner, Observer { m ->
            // Update the UI with the new user data
            context?.let {
                Glide
                    .with(it.applicationContext)
                    .load(m.meals.get(0).strMealThumb)
                    .fitCenter()
                    .into(binding.dishOfTheDayImageView)
            }
            binding.dishOfTheDayTextView.text = m.meals.get(0).strMeal
            binding.countryOfDishOfTheDayTextView.text = m.meals.get(0).strArea
        })

        binding.cardView.setOnClickListener {
            homeViewModel.getMealsArraylist()
        }

        return view
    }

}