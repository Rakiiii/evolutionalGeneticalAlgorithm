package Selector

import Builders.SelectorBuilding

class ProportionalSelectorBuilder : SelectorBuilding
{
    override fun Build(): AbstractSelector {
        return ProportionalSelector()
    }
}