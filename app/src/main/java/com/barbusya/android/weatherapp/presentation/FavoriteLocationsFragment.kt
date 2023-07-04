package com.barbusya.android.weatherapp.presentation

import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.barbusya.android.weatherapp.R
import com.barbusya.android.weatherapp.databinding.FragmentFavoriteLocationsBinding

class FavoriteLocationsFragment : Fragment(R.layout.fragment_favorite_locations) {

    private val binding by viewBinding(FragmentFavoriteLocationsBinding::bind)
}