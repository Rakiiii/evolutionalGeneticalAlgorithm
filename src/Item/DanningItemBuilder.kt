package Item

import Builders.ItemBuilding

class DanningItemBuilder : ItemBuilding
{
    override fun Build(): AbstractItem {
        return DanningItem()
    }
}