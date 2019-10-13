package Population

import Builders.PopulationBuilding

class BasicPopulationBuilder : PopulationBuilding
{
    override fun Build(): AbstractPopulation {
        return BasicPopulation()
    }
}