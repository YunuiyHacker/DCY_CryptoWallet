package yunuiy_hacker.ryzhaya_tetenka.dcy.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {
    suspend fun saveAppEntry()

    fun readAppEntry(): Flow<Boolean>
}