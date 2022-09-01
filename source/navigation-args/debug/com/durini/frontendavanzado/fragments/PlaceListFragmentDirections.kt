package com.durini.frontendavanzado.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.durini.frontendavanzado.R
import com.durini.frontendavanzado.entities.Place
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class PlaceListFragmentDirections private constructor() {
  private data class ActionPlaceListFragmentToPlaceDetailsFragment(
    public val place: Place
  ) : NavDirections {
    public override val actionId: Int = R.id.action_placeListFragment_to_placeDetailsFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Place::class.java)) {
          result.putParcelable("place", this.place as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(Place::class.java)) {
          result.putSerializable("place", this.place as Serializable)
        } else {
          throw UnsupportedOperationException(Place::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionPlaceListFragmentToPlaceDetailsFragment(place: Place): NavDirections =
        ActionPlaceListFragmentToPlaceDetailsFragment(place)
  }
}
