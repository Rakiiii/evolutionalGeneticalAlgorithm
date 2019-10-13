package Gene

import Builders.GeneBuilding

class BasicGeneBuilder : GeneBuilding
{
    override fun Build(): AbstractGene {
        return BasicGene()
    }
}