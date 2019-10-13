package Initializers

import Builders.PopulationBuilding

open class PopulationInitializer : IndividualInitializer()
{
    protected lateinit var populationBuilder : PopulationBuilding
    fun InitPopulationBuilder( pop : PopulationBuilding)
    {
        if(!::populationBuilder.isInitialized)
        {
            populationBuilder = pop
        }
        else throw Exception("ReInit PopulationBuilder in PopulationInitializer")
    }

    override fun isInitialized(): Boolean {
        return (super.isInitialized() && ::populationBuilder.isInitialized)
    }
}