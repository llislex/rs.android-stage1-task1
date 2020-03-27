package subtask4

class StringParser {
    class Sequence{
        var start: Int = 0
        var end : Int = 0
        var startToken: Char = ' '
        var endToken: Char = ' '
        constructor(start: Int, startToken: Char, endToken: Char)
        {
            this.start = start
            this.startToken = startToken
            this.endToken = endToken
        }
    }

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        val token = "<(["
        val back_token = ">)]"
        val lut = mapOf<Char, Char>('[' to ']', '<' to '>', '(' to ')')
        val open_list = mutableListOf<Sequence>()
        val final_list = mutableListOf<Sequence>()
        for (i in inputString.indices)
        {
            val x = inputString[i]
            if(x in token)
                open_list.add(0, Sequence ( i, x, lut[x]!!))
            else if (x in back_token)
                for (s in open_list)
                    if(s.endToken == x)
                    {
                        s.end = i
                        open_list.remove(s)
                        final_list.add(s)
                        break;
                    }
        }
        final_list.sortBy{it.start}
        val result = arrayListOf<String>()
        for(s in final_list)
        {
            val st = inputString.substring(s.start + 1, s.end)
            result.add(st)
        }
        return result.toTypedArray()
    }
}
