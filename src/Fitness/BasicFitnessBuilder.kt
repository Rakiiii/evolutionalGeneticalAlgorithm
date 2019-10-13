package Fitness

import Builders.FitnessBuilding


class BasicFitnessBuilder : FitnessBuilding
{
    override fun Build(): AbstractFitness
    {
        return BasicFitness()
    }
}