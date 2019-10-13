package Mutator

import Individual.AbstractIndividual
import Initializers.IndividualInitializer

//TODO::Add mutatorManager
abstract class AbstractMutator : IndividualInitializer()
{
    abstract fun Mutate(individual: AbstractIndividual):AbstractIndividual
}