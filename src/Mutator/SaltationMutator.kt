package Mutator

import Gene.BasicGene
import Individual.AbstractIndividual
import Individual.BasicIndividual
import kotlin.random.Random

class SaltationMutator : AbstractMutator()
{
    override fun Mutate(individual: AbstractIndividual): AbstractIndividual
    {
        if(!this.isInitialized())throw Exception("SaltationMutator is not initialized")
        val rndFirst = Random.nextInt(0 ,individual.Gene().getCode().size)
        var rndSecond = rndFirst
        while( rndSecond == rndFirst)
        {
            rndSecond = Random.nextInt(0 ,individual.Gene().getCode().size)
        }

        val newCode = individual.Gene().getCode().copyOf()

        newCode[rndFirst] = newCode[rndSecond]
        newCode[rndSecond] = individual.Gene().getCode()[rndFirst]

        val newGene = geneBuilder.Build()
        val newIndividual = individualBuilder.Build()

        newGene.Init(newCode)

        newIndividual.InitFitness(individual.GetFitness())
        newIndividual.Init(newGene)

        return newIndividual
    }
}