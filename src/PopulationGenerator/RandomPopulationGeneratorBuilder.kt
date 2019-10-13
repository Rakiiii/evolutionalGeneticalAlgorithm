package PopulationGenerator

import Builders.PopulationGeneratorBuilding

class RandomPopulationGeneratorBuilder : PopulationGeneratorBuilding
{
    override fun Build(): AbstractPopulationGenerator {
        return RandomPopulationGenerator()
    }
}