package Modificator

import Individual.AbstractIndividual
import Item.AbstractItem
import Population.AbstractPopulation


class BasicModificator : AbstractModificator()
{
    override fun ModifyPopulation(population: AbstractPopulation, items : MutableList<AbstractItem> , maxWeight: Int): AbstractPopulation {
        val subResult : MutableList<AbstractIndividual> = mutableListOf()
        for(i in 0 until population.Size())
        {
            if(population.Individual(i).TotalWeight() > maxWeight)
            {
                val subCode = population.Individual(i).Gene().getCode().copyOf()
                val newCode = BooleanArray(subCode.size)
                var weight = 0
                for(j in 0 until  subCode.size)
                {
                    if(subCode[j] && (weight + items[j].Weight()) <= maxWeight)
                    {
                        weight += items[j].Weight()
                        newCode[j] = subCode[j]
                    }
                }
                val newGene = geneBuilder.Build()
                newGene.Init(newCode)

                val newIndividual = individualBuilder.Build()
                newIndividual.Init(newGene)
                newIndividual.InitFitness(population.Individual(i).GetFitness())

                subResult.add(newIndividual)
            }
            else
            {
                subResult.add(population.Individual(i))
            }
        }

        val newPopulation = populationBuilder.Build()
        newPopulation.Init(subResult)
        return newPopulation
    }
}