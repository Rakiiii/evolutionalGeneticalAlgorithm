package Individual

import Builders.GeneBuilding
import Fitness.AbstractFitness
import Gene.AbstractGene

abstract class AbstractIndividual
{
    abstract fun Gene():AbstractGene
    abstract fun Init(gene : AbstractGene)
    abstract fun Fitness():Int
    abstract fun InitFitness(fit : AbstractFitness)
    abstract fun GetFitness():AbstractFitness
    abstract fun TotalWeight():Int
    abstract fun Print()
}