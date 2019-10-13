package MutationManager

import Builders.MutationManagerBuilding
import Builders.MutatorBuilding
import Mutator.AbstractMutator

class BasicMutationManagerBuilder : MutationManagerBuilding
{
    override fun Build(): AbstractMutationManager {
        return BasicMutationManager()
    }
}