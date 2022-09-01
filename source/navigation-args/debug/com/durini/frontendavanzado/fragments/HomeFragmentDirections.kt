package com.durini.frontendavanzado.fragments

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.durini.frontendavanzado.R

public class HomeFragmentDirections private constructor() {
  public companion object {
    public fun actionHomeFragmentToDetailsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_detailsFragment)
  }
}
