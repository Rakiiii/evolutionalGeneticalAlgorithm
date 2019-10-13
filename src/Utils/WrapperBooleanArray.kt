package Utils

class WrapperBooleanArray(s:Int = 0)
{
    private var arr : BooleanArray = BooleanArray( s , { m -> false})

    var Size : Int = 0
    private set

    operator fun get(i : Int) : Boolean
    {
        if(arr.size > i) return arr[i]
        else return false
    }

    operator fun set(i : Int , value : Boolean)
    {
        if(value && !arr[i])Size++
        else if( !value && arr[i])Size--
        arr[i] = value
    }

    fun getBooleanArray() = arr

    fun getMaxSize() = arr.size
}