package Selector

import Individual.AbstractIndividual
import Initializers.PopulationInitializer
import Population.AbstractPopulation

abstract class AbstractSelector : PopulationInitializer()
{
    abstract fun SelectNewPopulation(oldPop : AbstractPopulation , children : MutableList<AbstractIndividual>) : AbstractPopulation
}