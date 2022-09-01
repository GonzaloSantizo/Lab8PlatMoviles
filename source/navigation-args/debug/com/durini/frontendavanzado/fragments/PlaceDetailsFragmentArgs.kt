package com.durini.frontendavanzado.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.durini.frontendavanzado.entities.Place
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class PlaceDetailsFragmentArgs(
  public val place: Place
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(Place::class.java)) {
      result.set("place", this.place as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(Place::class.java)) {
      result.set("place", this.place as Serializable)
    } else {
      throw UnsupportedOperationException(Place::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): PlaceDetailsFragmentArgs {
      bundle.setClassLoader(PlaceDetailsFragmentArgs::class.java.classLoader)
      val __place : Place?
      if (bundle.containsKey("place")) {
        if (Parcelable::class.java.isAssignableFrom(Place::class.java) ||
            Serializable::class.java.isAssignableFrom(Place::class.java)) {
          __place = bundle.get("place") as Place?
        } else {
          throw UnsupportedOperationException(Place::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__place == null) {
          throw IllegalArgumentException("Argument \"place\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"place\" is missing and does not have an android:defaultValue")
      }
      return PlaceDetailsFragmentArgs(__place)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): PlaceDetailsFragmentArgs {
      val __place : Place?
      if (savedStateHandle.contains("place")) {
        if (Parcelable::class.java.isAssignableFrom(Place::class.java) ||
            Serializable::class.java.isAssignableFrom(Place::class.java)) {
          __place = savedStateHandle.get<Place?>("place")
        } else {
          throw UnsupportedOperationException(Place::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__place == null) {
          throw IllegalArgumentException("Argument \"place\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"place\" is missing and does not have an android:defaultValue")
      }
      return PlaceDetailsFragmentArgs(__place)
    }
  }
}
