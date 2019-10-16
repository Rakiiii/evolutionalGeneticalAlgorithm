package Selector

import Builders.SelectorBuilding

class BTournamentSelectorBuilder : SelectorBuilding
{
    override fun Build(): AbstractSelector {
        return BTournamentSelector()
    }
}