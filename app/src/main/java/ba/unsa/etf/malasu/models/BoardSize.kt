package ba.unsa.etf.malasu.models

enum class BoardSize (val numCards: Int ) {
    EASY(numCards = 8),
    MEDIUM(numCards = 18),
    HARD(numCards = 24);

    fun getWidht(): Int {
        return when (this) {
        EASY->2
        MEDIUM->3
        HARD->4
        }
    }
    fun getHeight(): Int {
        return numCards / getWidht()
    }

    fun numCardPairs(): Int {
        return numCards / 2
    }
}