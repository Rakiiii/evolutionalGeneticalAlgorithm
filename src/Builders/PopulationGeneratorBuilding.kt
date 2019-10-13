package Builders

import PopulationGenerator.AbstractPopulationGenerator

interface PopulationGeneratorBuilding
{
    fun Build():AbstractPopulationGenerator
}