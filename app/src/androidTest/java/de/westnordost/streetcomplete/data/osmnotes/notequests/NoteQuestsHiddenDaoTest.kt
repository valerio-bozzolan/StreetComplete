package de.westnordost.streetcomplete.data.osmnotes.notequests

import de.westnordost.streetcomplete.data.ApplicationDbTestCase
import de.westnordost.streetcomplete.ktx.containsExactlyInAnyOrder
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class NoteQuestsHiddenDaoTest : ApplicationDbTestCase() {
    private lateinit var dao: NoteQuestsHiddenDao

    @Before fun createDao() {
        dao = NoteQuestsHiddenDao(dbHelper)
    }

    @Test fun getButNothingIsThere() {
        assertFalse(dao.contains(123L))
    }

    @Test fun addAndGet() {
        dao.add(123L)
        assertTrue(dao.contains(123L))
    }

    @Test fun getAll() {
        dao.add(1L)
        dao.add(2L)
        assertTrue(dao.getAll().containsExactlyInAnyOrder(listOf(1L,2L)))
    }

    @Test fun deleteAll() {
        assertEquals(0, dao.deleteAll())
        dao.add(1L)
        dao.add(2L)
        assertEquals(2, dao.deleteAll())
        assertFalse(dao.contains(1L))
        assertFalse(dao.contains(2L))
    }
}
