package Item

abstract class AbstractItem
{
    abstract fun Price():Int

    abstract fun Weight():Int

    abstract fun Number():Int

    abstract fun Init( number : Int , price : Int ,weight : Int)

    abstract fun Value():Int
}