/*
 * Copyright (C) 2017 Retrograde Project
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.swordfish.lemuroid.app.utils.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.Transformations
import io.reactivex.Observable

fun <T, K, S> LiveData<T>.combineLatest(
    other: LiveData<K>,
    combine: (data1: T, data2: K) -> S
): LiveData<S> {
    return CombinedLiveData(this, other, combine)
}

fun <T> LiveData<T>.throttle(delayMs: Long): LiveData<T> {
    return ThrottledLiveData(this, delayMs)
}

fun <T, K> LiveData<T>.map(mapper: (T) -> K): LiveData<K> {
    return Transformations.map(this, mapper)
}

fun <T> LiveData<T>.toObservable(lifecycleOwner: LifecycleOwner): Observable<T> {
    return LiveDataReactiveStreams.toPublisher(lifecycleOwner, this)
        .let { Observable.fromPublisher(it) }
}