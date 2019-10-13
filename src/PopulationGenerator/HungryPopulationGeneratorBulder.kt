package PopulationGenerator

import Builders.PopulationGeneratorBuilding

class HungryPopulationGeneratorBulder : PopulationGeneratorBuilding
{
    override fun Build(): AbstractPopulationGenerator
    {
        return HungryPopulationGenetator()
    }
}