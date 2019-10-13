package ParentSelector

import Builders.ParentSelectorBuilding

class RandomParentSelectorBuilder: ParentSelectorBuilding
{
    override fun Build(): AbstractParentSelector {
        return RandomParentSelector()
    }
}