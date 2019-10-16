package Selector

import Individual.AbstractIndividual
import Population.AbstractPopulation
import Utils.WrapperBooleanArray
import kotlin.random.Random

class ProportionalSelector : AbstractSelector()
{
    override fun SelectNewPopulation(
        oldPop: AbstractPopulation,
        children: MutableList<AbstractIndividual>
    ): AbstractPopulation
    {
        if(!this.isInitialized())throw Exception("ProportionalSelector is not initialized")

        //sum of fitnesses of all individuals
        var totalFitness = 0


        for( i in 0 until oldPop.Size() )
        {
            totalFitness += oldPop.Individual(i).Fitness()
        }
        for(i in children)
        {
            totalFitness += i.Fitness()
        }

        val subResult : MutableList<AbstractIndividual> = mutableListOf()

        val reproductionList : MutableList<AbstractIndividual> = oldPop.getCopyOfIndividuals()
        reproductionList += children

        var itter = 0
        while(subResult.size < oldPop.Size())
        {
            if( Random.nextInt(0,totalFitness) < reproductionList[itter].Fitness())
            {
                subResult.add(reproductionList[itter])
                reproductionList.removeAt(itter)
            }
            itter ++
            if(itter >= reproductionList.size)itter = 0
        }
        

        val result = populationBuilder.Build()
        result.Init(subResult)

        return result

    }
}