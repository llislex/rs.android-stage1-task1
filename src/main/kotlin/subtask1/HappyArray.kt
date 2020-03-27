package subtask1

class HappyArray {
    fun convertToHappy(sadArray: IntArray): IntArray {
        if (sadArray.size <= 2)
            return sadArray
        var result = arrayListOf<Int>()
        result.add(sadArray[0])
        var element_removed : Boolean = false;
        for (i in 1..(sadArray.size - 2))
            if (sadArray[i] > (sadArray[i - 1] + sadArray[i + 1]))
                element_removed = true;
            else
                result.add(sadArray[i])
        result.add(sadArray.last())
        var r = result.toIntArray()
        if(element_removed)
            return convertToHappy(r)
        return r
    }
}
