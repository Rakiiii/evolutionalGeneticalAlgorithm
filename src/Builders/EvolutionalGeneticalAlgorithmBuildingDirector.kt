package Builders
import EvolutioanlGeneticalAlgorithm
import Item.BasicItemBuilder
import Parser.DefaultParserBuilder

class EvolutionalGeneticalAlgorithmBuildingDirector (
    var crossoverBuilder: CrossoverBuilding? = null,
    var fitnessBuilder: FitnessBuilding? = null,
    var mutatorBuilder : MutatorBuilding? = null,

    var parentSelectorBuilder: ParentSelectorBuilding? = null,
    var populationGeneratorBuilder: PopulationGeneratorBuilding? = null,
    var selectorBuilder: SelectorBuilding? = null,
    var modificatorBuilder : ModificatorBuilding? = null,
    var geneBuilder : GeneBuilding? = null,
    var individualBuilder: IndividualBuilding? = null,
    var populationBuilder : PopulationBuilding? = null,
    var itemBuilder: ItemBuilding = BasicItemBuilder(),
    var parserBuilder : ParserBuilding = DefaultParserBuilder() ,
    var mutationManagerBuilder : MutationManagerBuilding? = null
    ){
    fun Build() : EvolutioanlGeneticalAlgorithm
    {
        if(crossoverBuilder != null ||
                fitnessBuilder != null ||
                mutatorBuilder != null ||
                parentSelectorBuilder != null ||
                populationGeneratorBuilder != null ||
                selectorBuilder != null ||
                    modificatorBuilder != null ||
                    geneBuilder != null ||
                    individualBuilder != null ||
                    populationBuilder != null ||
                    mutationManagerBuilder != null
                ) {
            val result = EvolutioanlGeneticalAlgorithm()

            result.InitFitness(fitnessBuilder!!.Build())

            val c = crossoverBuilder!!.Build()
            c.InitGeneBuilder(geneBuilder as GeneBuilding)
            c.InitIndividualBuilder(individualBuilder as IndividualBuilding)
            result.InitCrossover(c)

            val m = mutatorBuilder!!.Build()
            m.InitGeneBuilder(geneBuilder as GeneBuilding)
            m.InitIndividualBuilder(individualBuilder as IndividualBuilding)
            val mut = mutationManagerBuilder!!.Build()
            mut.InitMutator(m)
            result.InitMutatorManager(mut)


            result.InitParentSelector(parentSelectorBuilder!!.Build())

            val p = populationGeneratorBuilder!!.Build()
            p.InitGeneBuilder(geneBuilder as GeneBuilding)
            p.InitIndividualBuilder(individualBuilder as IndividualBuilding)
            p.InitPopulationBuilder(populationBuilder as PopulationBuilding)
            //p.InitFitness(fitnessBuilder.Build())
            result.InitPopulationGenerator(p)

            val s = selectorBuilder!!.Build()
            s.InitGeneBuilder(geneBuilder as GeneBuilding)
            s.InitIndividualBuilder(individualBuilder as IndividualBuilding)
            s.InitPopulationBuilder(populationBuilder as PopulationBuilding)
            result.InitSelector(s)

            val mod = modificatorBuilder!!.Build()
            mod.InitGeneBuilder(geneBuilder as GeneBuilding)
            mod.InitIndividualBuilder(individualBuilder as IndividualBuilding)
            mod.InitPopulationBuilder(populationBuilder as PopulationBuilding)
            result.InitModificator(mod)

            val par = parserBuilder.Build()
            par.InitItemBuilder(itemBuilder)
            result.SetParser(par)

            return result
        }
        else throw Exception("EvolutionalGeneticalAlgorithmDirector is not initialized")
    }
}