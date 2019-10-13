package Selector

import Builders.SelectorBuilding

class BasicSelectorBuilder : SelectorBuilding
{
    override fun Build(): AbstractSelector {
        return BasicSelector()
    }
}