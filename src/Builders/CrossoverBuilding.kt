package Builders

import Crossover.AbstractCrossover

interface CrossoverBuilding
{
    fun Build() : AbstractCrossover
}