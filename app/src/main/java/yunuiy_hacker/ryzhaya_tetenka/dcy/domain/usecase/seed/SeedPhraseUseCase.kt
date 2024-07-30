package yunuiy_hacker.ryzhaya_tetenka.dcy.domain.usecase.seed

import yunuiy_hacker.ryzhaya_tetenka.dcy.domain.repository.seed.SeedPhraseRepository

class SeedPhraseUseCase(val seedPhraseRepository: SeedPhraseRepository) {
    fun invoke(): MutableList<String> {
        return seedPhraseRepository.generate()
    }
}