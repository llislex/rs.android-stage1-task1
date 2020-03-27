package subtask2

class MiniMaxSum {
    fun getResult(input: IntArray): IntArray {
        if (input.size < 2)
            throw NotImplementedError("bad input array size")
        val n = input.size - 1
        val res = intArrayOf(0, 0)
        input.sort()
        for (i in 0 .. n - 1)
        {
            res[0] += input[i]      // min
            res[1] += input[n - i]  // max
        }
        return res
    }
}
