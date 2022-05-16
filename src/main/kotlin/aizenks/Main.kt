package aizenks

import aizenks.TestResult.Companion.createTestResult
import java.io.File

fun main() {
    val lines = File("src\\main\\resources\\testfile.txt").reader().readLines()
    val results = lines.map {
        val data = it.split(',')
        createTestResult(data[0], data[1])
    }
    results.forEach { println(it) }
}
