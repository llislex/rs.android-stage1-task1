package subtask3

class BillCounter {
    // TODO: Complete the following function
    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {
        val shared = bill.sum() - bill[k]
        return if (shared == b * 2) "Bon Appetit" else (b - shared / 2).toString()
    }
}
