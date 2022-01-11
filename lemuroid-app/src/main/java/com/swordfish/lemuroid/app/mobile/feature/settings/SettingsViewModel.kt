/*
 *  RetrogradeApplicationComponent.kt
 *
 *  Copyright (C) 2017 Retrograde Project
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.swordfish.lemuroid.app.mobile.feature.settings

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.f2prateek.rx.preferences2.RxSharedPreferences
import com.swordfish.lemuroid.R
import com.swordfish.lemuroid.app.shared.library.LibraryIndexMonitor

class SettingsViewModel(
    context: Context,
    directoryPreference: String,
    rxSharedPreferences: RxSharedPreferences
) : ViewModel() {

    class Factory(
        private val context: Context,
        private val rxSharedPreferences: RxSharedPreferences
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            val directoryPreference = context.getString(R.string.pref_key_extenral_folder)
            return SettingsViewModel(context, directoryPreference, rxSharedPreferences) as T
        }
    }

    val currentFolder = rxSharedPreferences.getString(directoryPreference)
        .asObservable()
        .filter { it.isNotBlank() }

    val indexingInProgress = LibraryIndexMonitor(context).getLiveData()
}
