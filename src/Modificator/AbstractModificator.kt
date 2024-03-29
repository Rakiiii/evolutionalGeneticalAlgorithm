package Modificator

import Initializers.PopulationInitializer
import Item.AbstractItem
import Population.AbstractPopulation

abstract class AbstractModificator : PopulationInitializer()
{
    abstract fun ModifyPopulation(population : AbstractPopulation, items : MutableList<AbstractItem>, maxWeight: Int) : AbstractPopulation
}