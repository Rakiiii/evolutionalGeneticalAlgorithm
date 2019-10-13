package Mutator

import Builders.MutatorBuilding

class SaltationMutatorBuilder : MutatorBuilding
{
    override fun Build(): AbstractMutator
    {
        return SaltationMutator()
    }
}