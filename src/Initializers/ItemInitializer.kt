package Initializers

import Builders.ItemBuilding

open class ItemInitializer
{
    protected lateinit var itemBuilder : ItemBuilding
    fun InitItemBuilder(buil : ItemBuilding)
    {
        if(!this.isInitialized())
        {
            itemBuilder = buil
        }
        else
        {
            throw Exception("ReInit ItemBuilder in ItemInitializer")
        }
    }

    open fun isInitialized() = ::itemBuilder.isInitialized
}