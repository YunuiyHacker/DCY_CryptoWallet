package yunuiy_hacker.ryzhaya_tetenka.dcy.domain.usecase.app_entry

import kotlinx.coroutines.flow.Flow
import yunuiy_hacker.ryzhaya_tetenka.dcy.domain.manager.LocalUserManager

class ReadAppEntry(val localUserManager: LocalUserManager) {

    operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}