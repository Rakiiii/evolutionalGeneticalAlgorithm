package Modificator

import Builders.ModificatorBuilding

class BasicModificatorBuilder : ModificatorBuilding
{
    override fun Build(): AbstractModificator {
        return BasicModificator()
    }
}