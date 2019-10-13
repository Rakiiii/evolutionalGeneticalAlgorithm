package Parser

import Initializers.ItemInitializer
import Item.AbstractItem

abstract class AbstractParser : ItemInitializer()
{
    abstract fun ParseItemsFromFile(path : String) : Pair<MutableList<AbstractItem>,Int>
}