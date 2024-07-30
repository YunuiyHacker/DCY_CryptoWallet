package yunuiy_hacker.ryzhaya_tetenka.dcy.domain.repository.seed

import yunuiy_hacker.ryzhaya_tetenka.dcy.utils.SeedWordList

class SeedPhraseRepositoryImpl() : SeedPhraseRepository {
    override fun generate(): MutableList<String> {
        val seed = mutableListOf<String>()
        for (i in 0..11) {
            seed.add(SeedWordList.SEED_WORDS.get((0..SeedWordList.SEED_WORDS.size - 1).random()))
        }
        return seed
    }
}