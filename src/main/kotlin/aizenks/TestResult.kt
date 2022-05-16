package aizenks

class TestResult private constructor(val name: String, val group1: Int, val group2: Int, val group3: Int) {
    val personType: PersonType

    init {
        personType = when {
            group3 > 20 -> PersonType.ERROR
            group3 >= 5 -> PersonType.LIAR
            group1 <= 12 && group2 <= 12 -> PersonType.PHLEGM
            group1 <= 12 && group2 > 12 -> PersonType.MELAN
            group1 > 12 && group2 <= 12 -> PersonType.SANG
            group1 > 12 && group2 > 12 -> PersonType.CHOL
            else -> PersonType.ALCO
        }
    }

    override fun toString(): String {
        return "Pacients '$name' ir ${personType.personType.lowercase()}"
    }

    companion object {
        fun createTestResult(answers: String, name: String = "Nezināms"): TestResult {
            if(answers.length != 57 || !answers.all{c -> c == 'y' || c == 'n'}) {
                println("Kļūdains atbilžu saraksts lietotājam $name. " +
                    "Sarakstam jābūt 57 simbolus garam un jāsatur 'y' un 'n'.")
                return TestResult(name, 0, 0, 21)
            }

            var group1 = 0
            var group2 = 0
            var group3 = 0

            answers.forEachIndexed { index, answer ->
                when {
                    index+1 in AnswerGroups.GROUP_1_YES && answer == 'y' -> group1++
                    index+1 in AnswerGroups.GROUP_1_NO && answer == 'n' -> group1++
                    index+1 in AnswerGroups.GROUP_2_YES && answer == 'y' -> group2++
                    index+1 in AnswerGroups.GROUP_3_YES && answer == 'y' -> group3++
                    index+1 in AnswerGroups.GROUP_3_NO && answer == 'n' -> group3++
                }
            }

            return TestResult(name, group1, group2, group3)
        }
    }
}
