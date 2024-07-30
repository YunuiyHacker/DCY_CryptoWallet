package yunuiy_hacker.ryzhaya_tetenka.dcy.domain.repository.seed

interface SeedPhraseRepository {
    fun generate(): MutableList<String>
}