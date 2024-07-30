package yunuiy_hacker.ryzhaya_tetenka.dcy.domain.usecase.app_entry

import yunuiy_hacker.ryzhaya_tetenka.dcy.domain.manager.LocalUserManager

class SaveAppEntry(val localUserManager: LocalUserManager) {

    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}