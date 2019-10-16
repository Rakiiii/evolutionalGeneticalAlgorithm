package Crossover

import Individual.AbstractIndividual
import kotlin.random.Random

class DoubleDotCrossover : AbstractCrossover()
{
    override fun Cross(pair: Pair<AbstractIndividual, AbstractIndividual>): AbstractIndividual
    {
        if(!this.isInitialized())throw Exception("Crossover is not initialized")

        val firstDot = Random.nextInt( 0 , pair.first.Gene().getCode().size/2)

        val secondDot = Random.nextInt( pair.first.Gene().getCode().size/2, pair.first.Gene().getCode().size - 1)

        val subCode = BooleanArray(pair.first.Gene().getCode().size , { false } )

        for(i in 0 until firstDot)
        {
            subCode[i] = pair.first.Gene().getCode()[i]
        }
        for(i in firstDot until secondDot)
        {
            subCode[i] = pair.second.Gene().getCode()[i]
        }
        for(i in secondDot until pair.first.Gene().getCode().size)
        {
            subCode[i] = pair.first.Gene().getCode()[i]
        }

        val subGene = geneBuilder.Build()
        subGene.Init(subCode)

        val newIndividual = individualBuilder.Build()

        newIndividual.InitFitness(pair.first.GetFitness())
        newIndividual.Init(subGene)

        return newIndividual
    }
}
