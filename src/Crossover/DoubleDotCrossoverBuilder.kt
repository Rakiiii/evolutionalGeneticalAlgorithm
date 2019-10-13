package Crossover

import Builders.CrossoverBuilding

class DoubleDotCrossoverBuilder : CrossoverBuilding
{
    override fun Build(): AbstractCrossover {
        return DoubleDotCrossover()
    }
}