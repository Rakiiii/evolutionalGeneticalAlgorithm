package Builders
import EvolutioanlGeneticalAlgorithm
import Item.BasicItemBuilder
import Parser.DefaultParserBuilder

class EvolutionalGeneticalAlgorithmBuildingDirector (
    val crossoverBuilder: CrossoverBuilding, val fitnessBuilder: FitnessBuilding, val mutatorBuilder : MutatorBuilding,
    val parentSelectorBuilder: ParentSelectorBuilding, val populationGeneratorBuilder: PopulationGeneratorBuilding,
    val selectorBuilder: SelectorBuilding, val modificatorBuilder : ModificatorBuilding,
    val geneBuilder : GeneBuilding, val individualBuilder: IndividualBuilding, val populationBuilder : PopulationBuilding,
    val itemBuilder: ItemBuilding = BasicItemBuilder(), val parserBuilder : ParserBuilding = DefaultParserBuilder() ,
    val mutationManagerBuilder: MutationManagerBuilding
    ){
    fun Build() : EvolutioanlGeneticalAlgorithm
    {
        val result = EvolutioanlGeneticalAlgorithm()

        result.InitFitness(fitnessBuilder.Build())

        val c = crossoverBuilder.Build()
        c.InitGeneBuilder(geneBuilder)
        c.InitIndividualBuilder(individualBuilder)
        result.InitCrossover(c)

        val m = mutatorBuilder.Build()
        m.InitGeneBuilder(geneBuilder)
        m.InitIndividualBuilder(individualBuilder)
        val mut = mutationManagerBuilder.Build()
        mut.InitMutator(m)
        result.InitMutatorManager(mut)


        result.InitParentSelector( parentSelectorBuilder.Build() )

        val p = populationGeneratorBuilder.Build()
        p.InitGeneBuilder(geneBuilder)
        p.InitIndividualBuilder(individualBuilder)
        p.InitPopulationBuilder(populationBuilder)
        //p.InitFitness(fitnessBuilder.Build())
        result.InitPopulationGenerator(p)

        val s = selectorBuilder.Build()
        s.InitGeneBuilder(geneBuilder)
        s.InitIndividualBuilder(individualBuilder)
        s.InitPopulationBuilder(populationBuilder)
        result.InitSelector( s )

        val mod = modificatorBuilder.Build()
        mod.InitGeneBuilder(geneBuilder)
        mod.InitIndividualBuilder(individualBuilder)
        mod.InitPopulationBuilder(populationBuilder)
        result.InitModificator(mod)

        val par = parserBuilder.Build()
        par.InitItemBuilder(itemBuilder)
        result.SetParser(par)

        return result
    }

}