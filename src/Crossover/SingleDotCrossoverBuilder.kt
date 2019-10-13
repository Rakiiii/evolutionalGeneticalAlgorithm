package Crossover

import Builders.CrossoverBuilding

class SingleDotCrossoverBuilder : CrossoverBuilding
{
    override fun Build(): AbstractCrossover {
        return SingleDotCrossover()
    }
}