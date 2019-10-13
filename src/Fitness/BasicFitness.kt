package Fitness

import Item.AbstractItem

class BasicFitness : AbstractFitness()
{
    private lateinit var items : MutableList<AbstractItem>

    override fun Init(ites: MutableList<AbstractItem>)
    {
        if(!::items.isInitialized)
        {
            items = ites
        }
        else
        {
            throw Exception("ReInit items object in BasicFitness")
        }
    }


    override fun Fitness(c: BooleanArray): Int
    {
        if(!::items.isInitialized )throw Exception("Fitness is not Initialized")

        var result = 0
        var counter  = 0

        for (i in c)
        {
            if (i)
            {
                result += items[counter].Price()
            }
            counter++
        }

        return result
    }

    override fun TotalWeight( c : BooleanArray): Int
    {
        if(!::items.isInitialized )throw Exception("Fitness is not Initialized")
        var result = 0
        var counter  = 0

        for (i in c)
        {
            if (i)
            {
                result += items[counter].Weight()
            }
            counter++
        }

        return result
    }
}