package yunuiy_hacker.ryzhaya_tetenka.dcy.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import yunuiy_hacker.ryzhaya_tetenka.dcy.data.manager.LocalUserManagerImpl
import yunuiy_hacker.ryzhaya_tetenka.dcy.domain.manager.LocalUserManager
import yunuiy_hacker.ryzhaya_tetenka.dcy.domain.repository.seed.SeedPhraseRepository
import yunuiy_hacker.ryzhaya_tetenka.dcy.domain.repository.seed.SeedPhraseRepositoryImpl
import yunuiy_hacker.ryzhaya_tetenka.dcy.domain.usecase.app_entry.AppEntryUseCase
import yunuiy_hacker.ryzhaya_tetenka.dcy.domain.usecase.app_entry.ReadAppEntry
import yunuiy_hacker.ryzhaya_tetenka.dcy.domain.usecase.app_entry.SaveAppEntry
import yunuiy_hacker.ryzhaya_tetenka.dcy.domain.usecase.seed.SeedPhraseUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(application: Application): LocalUserManager =
        LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCase(localUserManager: LocalUserManager): AppEntryUseCase =
        AppEntryUseCase(
            saveAppEntry = SaveAppEntry(localUserManager),
            readAppEntry = ReadAppEntry(localUserManager)
        )

    @Provides
    @Singleton
    fun provideSeedPhraseUseCase(): SeedPhraseUseCase =
        SeedPhraseUseCase(seedPhraseRepository = SeedPhraseRepositoryImpl())
}