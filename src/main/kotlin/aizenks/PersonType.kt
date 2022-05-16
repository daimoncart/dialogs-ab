package aizenks

enum class PersonType(val personType: String, val description: String) {
    LIAR("Melis", "Atbilžu ticamības pakāpe ir nepietiekama"),
    PHLEGM("Flegmatiķis", "Emocionāli noturīgs introverts"),
    MELAN("Melanholiķis", "Emocionāli nenoturīgs introverts"),
    SANG("Sangviniķis", "Emocionāli noturīgs ekstroverts"),
    CHOL("Holēriķis", "Emocionāli nenoturīgs ekstroverts"),
    ERROR("Kļūda", "Ievades datu kļūda"),
    ALCO("Alkoholiķis", "Pats viedākais")
}
