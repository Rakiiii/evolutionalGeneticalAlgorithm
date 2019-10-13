package Item

import Builders.ItemBuilding

class BasicItemBuilder : ItemBuilding
{
    override fun Build(): AbstractItem {
        return BasicItem()
    }
}