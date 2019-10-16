package MutationManager

import Builders.MutationManagerBuilding

class BasicMutationManagerBuilder : MutationManagerBuilding
{
    override fun Build(): AbstractMutationManager {
        return BasicMutationManager()
    }
}