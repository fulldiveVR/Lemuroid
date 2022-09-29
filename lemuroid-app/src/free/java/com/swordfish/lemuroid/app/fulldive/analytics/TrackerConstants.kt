/*
 * Copyright (c) 2022 FullDive
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
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.swordfish.lemuroid.app.fulldive.analytics

object TrackerConstants {

    const val PARAM_SCREEN_KEY = "screen_key"
    const val PARAM_START_TIME = "start_time"
    const val PARAM_END_TIME = "end_time"
    const val PARAM_DURATION = "duration"
    const val FLURRY_SCREEN_TIME = "Fulldive.ScreenTime"
    const val FIREBASE_SCREEN_TIME = "screen_time"

    const val EVENT_PRO_POPUP_SHOWN = "pro_popup_shown"
    const val EVENT_PRO_POPUP_CLOSED = "pro_popup_closed"
    const val EVENT_PRO_TUTORIAL_OPENED_FROM_PRO_POPUP = "pro_tutorial_opened_from_pro_popup"
    const val EVENT_PRO_TUTORIAL_OPENED_FROM_TOOLBAR = "pro_tutorial_opened_from_toolbar"
    const val EVENT_PRO_TUTORIAL_OPENED_FROM_SETTINGS = "pro_tutorial_opened_from_settings"
    const val EVENT_BUY_PRO_CLICKED = "buy_pro_clicked"
    const val EVENT_CLOUD_SAVE_SETTINGS_CLICKED = "cloud_save_settings_clicked"

    const val EVENT_DISCORD_POPUP_SHOWN = "discord_popup_shown"
    const val EVENT_DISCORD_POPUP_CLOSED = "discord_popup_closed"
    const val EVENT_DISCORD_POPUP_CLICKED = "discord_popup_clicked"
}
