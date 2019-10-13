package Mutator

import Builders.MutatorBuilding

class InversionMutatorBuilder : MutatorBuilding
{
    override fun Build(): AbstractMutator {
        return InversionMutator()
    }
}