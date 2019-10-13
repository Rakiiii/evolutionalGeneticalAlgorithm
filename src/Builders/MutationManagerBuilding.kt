package Builders

import MutationManager.AbstractMutationManager

interface MutationManagerBuilding
{
    fun Build():AbstractMutationManager
}