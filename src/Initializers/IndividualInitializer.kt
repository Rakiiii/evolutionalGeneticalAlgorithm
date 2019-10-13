package Initializers

import Builders.IndividualBuilding

open class IndividualInitializer : GeneInitializer()
{
    protected lateinit var individualBuilder : IndividualBuilding
    fun InitIndividualBuilder(indBuilder: IndividualBuilding)
    {
        if(!::individualBuilder.isInitialized)
        {
            individualBuilder = indBuilder
        }
        else
        {
            throw Exception("ReInit IndividualBuilder in BasicCrossover")
        }
    }

    override fun isInitialized(): Boolean {
        return (super.isInitialized() && ::individualBuilder.isInitialized)
    }
}