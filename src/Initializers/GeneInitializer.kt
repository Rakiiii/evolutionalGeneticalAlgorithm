package Initializers

import Builders.GeneBuilding

open class GeneInitializer
{
    protected lateinit var geneBuilder: GeneBuilding

    fun InitGeneBuilder(gBuilder: GeneBuilding)
    {
        if(!::geneBuilder.isInitialized)
        {
            geneBuilder = gBuilder
        }
        else
        {
            throw Exception("ReInit GeneBuilder in BasicCrossover")
        }
    }

    open fun isInitialized() = (::geneBuilder.isInitialized)
}