package ParentSelector

import Individual.AbstractIndividual
import Population.AbstractPopulation

abstract class AbstractParentSelector
{
    abstract fun SelectParentsPair(population : AbstractPopulation) : MutableList< Pair<AbstractIndividual , AbstractIndividual> >
    abstract fun Init(am : Int)
}