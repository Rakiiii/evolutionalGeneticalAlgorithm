package Mutator

import Individual.AbstractIndividual

class InversionMutator : AbstractMutator()
{
    override fun Mutate(individual: AbstractIndividual): AbstractIndividual
    {
        if(!this.isInitialized())throw Exception("SaltationMutator is not initialized")

        val newCode = BooleanArray(individual.Gene().getCode().size , { _ -> false})

        for(i in 0 until newCode.size)
        {
            newCode[i] = !individual.Gene().getCode()[i]
        }

        val newGene = geneBuilder.Build()
        val newIndividual = individualBuilder.Build()

        newGene.Init(newCode)

        newIndividual.InitFitness(individual.GetFitness())
        newIndividual.Init(newGene)

        return newIndividual
    }
}