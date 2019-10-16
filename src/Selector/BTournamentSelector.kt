package Selector

import Individual.AbstractIndividual
import Population.AbstractPopulation
import kotlin.random.Random

class BTournamentSelector : AbstractSelector()
{
    override fun SelectNewPopulation(
        oldPop: AbstractPopulation,
        children: MutableList<AbstractIndividual>
    ): AbstractPopulation {

        if(!this.isInitialized())throw Exception("ProportionalSelector is not initialized")

        val b = children.size

        val indidsFromNewPopulation : MutableList<AbstractIndividual> = mutableListOf()
        val reproductionList : MutableList<AbstractIndividual> = oldPop.getCopyOfIndividuals()
        reproductionList += children

        for( i in 0 until oldPop.Size())
        {
            val bTournament : MutableList<Pair<AbstractIndividual , Int>> = mutableListOf()
            for(j in 0 until b)
            {
                var rndInd = Random.nextInt(0,reproductionList.size)
                while( bTournament.contains(Pair(reproductionList[rndInd],rndInd)) )
                {
                    rndInd = Random.nextInt(0 , reproductionList.size)
                }
                bTournament.add(Pair(reproductionList[rndInd],rndInd))
            }

            var subInd = bTournament.first()
            bTournament.forEach { ind -> if (ind.first.Fitness() > subInd.first.Fitness())subInd = ind  }

            reproductionList.removeAt(subInd.second)

            indidsFromNewPopulation.add(subInd.first)
        }

        val newPopulation = populationBuilder.Build()
        newPopulation.Init(indidsFromNewPopulation)

        return newPopulation
    }
}