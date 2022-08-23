package com.swordfish.lemuroid.app.shared.input

import android.content.Context
import android.view.InputDevice
import com.swordfish.lemuroid.app.shared.settings.GameMenuShortcut

object InputClassUnknown : InputClass {
    override fun getInputKeys(): Set<Int> = emptySet()

    override fun getAxesMap(): Map<Int, Int> = emptyMap()

    override fun getDefaultBindings(): Map<Int, Int> = emptyMap()

    override fun getCustomizableKeys(device: InputDevice): List<Int> = emptyList()

    override fun isSupported(device: InputDevice): Boolean = false

    override fun isEnabledByDefault(appContext: Context, device: InputDevice): Boolean = false

    override fun getSupportedShortcuts(): List<GameMenuShortcut> = emptyList()
}
