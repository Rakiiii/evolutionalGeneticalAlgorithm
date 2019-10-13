package Population

import Individual.AbstractIndividual

abstract class AbstractPopulation
{
    //abstract fun SetIndividual(number : Int , individual : AbstractIndividual)
    abstract fun Individual(number : Int):AbstractIndividual
    abstract fun Init(ind : MutableList<AbstractIndividual>)
    abstract fun Size():Int
    abstract fun Copy():AbstractPopulation
    abstract fun getCopyOfIndividuals() : MutableList<AbstractIndividual>
    abstract fun Print()
}