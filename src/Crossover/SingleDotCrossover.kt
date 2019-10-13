package Crossover

import Builders.GeneBuilding
import Builders.IndividualBuilding
import Gene.BasicGene
import Individual.AbstractIndividual
import Individual.BasicIndividual
import kotlin.random.Random

class SingleDotCrossover : AbstractCrossover()
{

    override fun Cross(pair: Pair<AbstractIndividual, AbstractIndividual>): AbstractIndividual
    {
        if(!this.isInitialized())throw Exception("Crossover is not initialized")

        val dot = Random.nextInt( 0 , pair.first.Gene().getCode().size - 1)

        val subCode = BooleanArray(pair.first.Gene().getCode().size , { _ -> false } )

        for( i in 0 until dot)
        {
            subCode[i] = pair.first.Gene().getCode()[i]
        }

        for(i in dot until pair.second.Gene().getCode().size )
        {
            subCode[i] = pair.second.Gene().getCode()[i]
        }

        val subGene = geneBuilder.Build()
        subGene.Init(subCode)

        val newIndividual = individualBuilder.Build()

        newIndividual.InitFitness(pair.first.GetFitness())
        newIndividual.Init(subGene)

        return newIndividual
    }
}