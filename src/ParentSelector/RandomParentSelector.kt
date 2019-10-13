package ParentSelector

import Individual.AbstractIndividual
import Population.AbstractPopulation
import Utils.WrapperBooleanArray
import kotlin.random.Random

class RandomParentSelector : AbstractParentSelector()
{
    private var amount = 0

    override fun Init(am: Int)
    {
        amount = am
    }


    override fun SelectParentsPair(population: AbstractPopulation): MutableList<Pair<AbstractIndividual, AbstractIndividual>>
    {
        val result : MutableList< Pair<AbstractIndividual , AbstractIndividual > > = mutableListOf()

        val copyOfPopulation = population.getCopyOfIndividuals()
        //var code = WrapperBooleanArray(population.Size())

        if(2*amount > population.Size() )throw Exception("Population is too small")

        while( result.size < amount)
        {
            val rndMother = Random.nextInt(0,copyOfPopulation.size)
            val rndFather = Random.nextInt(0,copyOfPopulation.size)
            if(rndFather != rndMother)
            {
                result.add(Pair(copyOfPopulation[rndMother] , copyOfPopulation[rndFather] ))
                if(rndMother > rndFather)
                {
                    copyOfPopulation.removeAt(rndMother)
                    copyOfPopulation.removeAt(rndFather)
                }
                else
                {
                    copyOfPopulation.removeAt(rndFather)
                    copyOfPopulation.removeAt(rndMother)
                }
            }
        }

        return result
    }
}