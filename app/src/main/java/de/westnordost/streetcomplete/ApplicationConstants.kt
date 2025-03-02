package de.westnordost.streetcomplete

import de.westnordost.streetcomplete.data.osm.edits.split_way.SplitWayAction

object ApplicationConstants {
    const val NAME = "StreetComplete"
    const val USER_AGENT = NAME + " " + BuildConfig.VERSION_NAME
    const val QUESTTYPE_TAG_KEY = NAME + ":quest_type"

    const val MAX_DOWNLOADABLE_AREA_IN_SQKM = 12.0
    const val MIN_DOWNLOADABLE_AREA_IN_SQKM = 0.1

    const val COPYRIGHT_YEARS = "2016-2024"

    const val DATABASE_NAME = "streetcomplete_v2.db"
    const val OLD_DATABASE_NAME = "streetcomplete.db"

    /** tile zoom at which the app downloads automatically and remembers which tiles have already
     *  been downloaded */
    const val DOWNLOAD_TILE_ZOOM = 16

    /** a "best before" duration for downloaded data. OSM data, notes, a tile will not be
     *  downloaded again before the time expired  */
    const val REFRESH_DATA_AFTER = 12L * 60 * 60 * 1000 // 12 hours in ms

    /** the duration after which OSM data, notes, quest meta data etc. will be deleted from the
     *  database if not used anymore and have not been refreshed in the meantime  */
    const val DELETE_OLD_DATA_AFTER = 14L * 24 * 60 * 60 * 1000 // 14 days in ms

    /** the duration after which logs will be deleted from the database */
    const val DELETE_OLD_LOG_AFTER = 14L * 24 * 60 * 60 * 1000 // 14 days in ms

    /** the duration after which logs won't be attached to the crash report */
    const val DO_NOT_ATTACH_LOG_TO_CRASH_REPORT_AFTER = 5L * 60 * 1000 // 5 minutes in ms

    const val NOTE_MIN_ZOOM = 15

    /** when new quests that are appearing due to download of an area, show the hint that he can
     *  disable quests in the settings if more than X quests did appear */
    const val QUEST_COUNT_AT_WHICH_TO_SHOW_QUEST_SELECTION_HINT = 600

    /** the max age of the undo history - one cannot undo changes older than X  */
    const val MAX_UNDO_HISTORY_AGE = 12L * 60 * 60 * 1000 // 12 hours in ms

    /** The creation of some quests is dependent on surrounding geometry. This constant describes
     *  the maximum distance surrounding elements may affect whether a quest is created or not */
    //  e.g. AddRecyclingContainerMaterials, AddCycleway
    const val QUEST_FILTER_PADDING = 20.0 // m

    const val AVATARS_CACHE_DIRECTORY = "osm_user_avatars"

    const val SC_PHOTO_SERVICE_URL = "https://westnordost.de/streetcomplete/photo-upload/" // must have trailing /

    const val ATTACH_PHOTO_QUALITY = 80
    const val ATTACH_PHOTO_MAXWIDTH = 1280 // WXGA
    const val ATTACH_PHOTO_MAXHEIGHT = 1280 // WXGA

    // name is "downloading" for historic reasons, not sure if it has any side-effects if it is changed now
    const val NOTIFICATIONS_CHANNEL_SYNC = "downloading"
    const val NOTIFICATIONS_ID_SYNC = 1

    const val STREETMEASURE = "de.westnordost.streetmeasure"

    val IGNORED_RELATION_TYPES = setOf(
        // could be useful, but sometimes/often very very large
        "route", "route_master", "superroute", "network", "disused:route",
        // very large, not useful for SC
        "boundary",
        // can easily span very large areas, not useful for SC
        "water", "waterway", "watershed", "collection",
        // questionable relation type: members could easily span multiple continents
        "person",
        // no wiki entry, sounds like it could span large areas
        "power", "pipeline", "railway"
    )

    val EDIT_ACTIONS_NOT_ALLOWED_TO_USE_LOCAL_CHANGES = setOf(
        /* because this action may edit route relations but route relations are not persisted
           locally for performance reasons */
        SplitWayAction::class
    )
}
