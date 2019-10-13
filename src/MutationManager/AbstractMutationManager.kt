package MutationManager

import Individual.AbstractIndividual
import Mutator.AbstractMutator

abstract class AbstractMutationManager
{
    abstract fun InitMutator(mut : AbstractMutator)
    abstract fun Mutate( childrens : MutableList<AbstractIndividual>) : MutableList<AbstractIndividual>
}