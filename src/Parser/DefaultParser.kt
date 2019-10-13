package Parser

import Item.AbstractItem
import java.io.File

class DefaultParser : AbstractParser()
{
    override fun ParseItemsFromFile(path: String): Pair<MutableList<AbstractItem>, Int>
    {
        if(!this.isInitialized())throw Exception("DefaultParser is not Initialized")
        val reader = File(path).bufferedReader()

        val result : MutableList<AbstractItem> = mutableListOf()
        var subString = reader.readLine()

        do
        {
            val item = itemBuilder.Build()
            item.Init( number = subString.substringBefore(' ').trim().toInt() ,
                    price = subString.substringAfter(' ').trim().substringBefore(' ').trim().toInt() ,
                    weight = subString.substringAfterLast(' ').toInt() )

            result.add(item)

            subString = reader.readLine()
        }while(!subString.contains("Max Weight:"))

        return Pair(result , subString.substringAfter(':').toInt())
    }
}