package Crossover

import Individual.AbstractIndividual
import Initializers.IndividualInitializer

//TODO::Add crossover manager
abstract class AbstractCrossover : IndividualInitializer()
{
    abstract fun Cross(pair: Pair<AbstractIndividual , AbstractIndividual>):AbstractIndividual
}