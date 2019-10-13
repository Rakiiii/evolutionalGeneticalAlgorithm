package Fitness

import Item.AbstractItem

abstract class AbstractFitness
{
    abstract fun Init(ites : MutableList<AbstractItem>)
    abstract fun Fitness(c:BooleanArray):Int
    abstract fun TotalWeight(c:BooleanArray):Int
}