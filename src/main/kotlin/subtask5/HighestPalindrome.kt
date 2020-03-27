package subtask5

class HighestPalindrome
{
    fun diff(s1: String, s2: String): Int
    {
        var res = 0
        for(i in s1.indices)
            if (s1[i] != s2[i])
                res += 1
        return res
    }

    // s[i] = ch
    fun set(s: String, i: Int, ch: Char): String
    {
        return s.substring(0, i) + ch + s.substring(i + 1)
    }

    fun build_the_best_palindrome(_s: String, middle: String, _credit: Int): String
    {
        var s: String = _s
        var credit = _credit / 2
        var i : Int = 0
        while (i < s.length && credit > 0)
        {
            if (s[i] != '9') {
                s = set(s, i, '9')
                credit -= 1
            }
            else
                i += 1
        }
        return s + middle + s.reversed()
    }

    // TODO: Complete the following function
    fun highestValuePalindrome(n: Int, k: Int, digitString: String): String {
        if (k >= n)
            return "9".repeat(n)
        val m = n / 2
        val middle: String = if ((n % 2) == 0) "" else digitString[m].toString()
        var credit: Int = k
        var s1 = digitString.substring(0, m)
        var s2 = digitString.substring(n - m).reversed()
        var d = diff(s1, s2)
        if (d > 0 && d > credit)
        {
            return "-1"
        }
        while (d > 0 && credit > 0)
        {
            for(i in 0..m-1)
            {
                if (s1[i] != s2[i])
                {
                    if(credit - d > 0)
                    {
                        s2 = set(s2, i, '9')
                        s1 = set(s1, i, '9')
                        credit -= 2
                    }
                    else
                    {
                        val d1 = s1[i].toString().toInt()
                        val d2 = s2[i].toString().toInt()
                        if (d1 > d2)
                            s2 = set(s2, i, s1[i])
                        else
                            s1 = set(s1, i, s2[i])
                        credit -= 1
                        d = diff(s1, s2)
                    }
                    break
                }
            }
        }
        return build_the_best_palindrome(s1, middle, credit)
    }
}