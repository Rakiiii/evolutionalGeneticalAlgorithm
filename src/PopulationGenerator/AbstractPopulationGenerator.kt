package PopulationGenerator

import Fitness.AbstractFitness
import Initializers.PopulationInitializer
import Item.AbstractItem
import Population.AbstractPopulation

abstract class AbstractPopulationGenerator : PopulationInitializer()
{
    abstract fun InitFitness( fit : AbstractFitness)
    abstract fun Init(_items : MutableList<AbstractItem> , _maxWeight : Int)
    abstract fun GeneratePopolation(size : Int ):AbstractPopulation
}