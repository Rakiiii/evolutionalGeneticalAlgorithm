package Gene

abstract class AbstractGene
{
    abstract fun getCode() : BooleanArray
    abstract fun Init(code : BooleanArray)
    abstract fun Print()
}