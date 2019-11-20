package Item

class DanningItem : AbstractItem()
{
    private var price : Int = 0

    private var weight : Int = 0

    private var number : Int = 0

    override fun Init(number: Int, price: Int, weight: Int)
    {
        this.price = price
        this.number = number
        this.weight = weight
    }

    override fun Number(): Int
    {
        return number
    }

    override fun Price(): Int
    {
        return price
    }

    override fun Value(): Int
    {
        return price/weight
    }

    override fun Weight(): Int
    {
        return weight
    }
}