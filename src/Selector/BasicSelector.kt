package Selector

import Individual.AbstractIndividual
import Individual.BasicIndividual
import Population.AbstractPopulation
import Population.BasicPopulation
import Utils.WrapperBooleanArray
import kotlin.random.Random

class BasicSelector : AbstractSelector()
{
    override fun SelectNewPopulation(
        oldPop: AbstractPopulation,
        children: MutableList<AbstractIndividual>
    ): AbstractPopulation
    {
        if(!this.isInitialized())throw Exception("BasicSelector is not initialized")

        val subResult : MutableList<AbstractIndividual> = mutableListOf()

        val code = WrapperBooleanArray( oldPop.Size() + children.size)

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

        var itter = 0

        while( code.Size < oldPop.Size() )
        {
            //if all individuals checked and population is not finnished then go for the next cyrcle
            if(itter == code.getMaxSize() )itter = 0

            //check wich array is ittarable
            if(itter >= oldPop.Size())
            {
                if(
                    ( Random.nextInt(0,totalFitness)  < children[ itter - oldPop.Size() ].Fitness() ) &&
                    !code[itter]
                )
                {
                    code[itter] = true
                }
            }
            else
            {
                if(
                    (Random.nextInt(0,totalFitness)  < oldPop.Individual(itter).Fitness() ) &&
                    !code[itter]
                )
                {
                    code[itter] = true
                }
            }
            itter ++

        }

        itter = 0

        for(i in code.getBooleanArray() )
        {
            if( itter >= oldPop.Size() )
            {
                if(i)subResult.add( children[ itter - oldPop.Size() ] )
            }
            else
            {
                if(i)subResult.add( oldPop.Individual( itter ) )
            }

            itter++
        }

        val result = populationBuilder.Build()
        result.Init(subResult)

        return result

    }
}