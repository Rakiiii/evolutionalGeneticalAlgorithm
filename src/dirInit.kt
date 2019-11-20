import Builders.EvolutionalGeneticalAlgorithmBuildingDirector
import Crossover.DoubleDotCrossoverBuilder
import Crossover.SingleDotCrossoverBuilder
import Fitness.BasicFitnessBuilder
import Gene.BasicGeneBuilder
import Individual.BasicIndividualBuilder
import Item.BasicItemBuilder
import Item.DanningItem
import Item.DanningItemBuilder
import Modificator.BasicModificatorBuilder
import MutationManager.BasicMutationManagerBuilder
import Mutator.InversionMutatorBuilder
import Mutator.SaltationMutatorBuilder
import ParentSelector.RandomParentSelectorBuilder
import Population.BasicPopulationBuilder
import PopulationGenerator.HungryPopulationGeneratorBulder
import PopulationGenerator.RandomPopulationGeneratorBuilder
import Selector.BTournamentSelectorBuilder
import Selector.ProportionalSelectorBuilder

fun directorGen(code : String) : EvolutionalGeneticalAlgorithmBuildingDirector
{
    val director = EvolutionalGeneticalAlgorithmBuildingDirector(
        fitnessBuilder = BasicFitnessBuilder(),
        selectorBuilder = ProportionalSelectorBuilder(),
        parentSelectorBuilder = RandomParentSelectorBuilder(),
        modificatorBuilder = BasicModificatorBuilder(),
        mutatorBuilder = SaltationMutatorBuilder(),
        geneBuilder = BasicGeneBuilder(),
        individualBuilder = BasicIndividualBuilder(),
        populationBuilder = BasicPopulationBuilder(),
        crossoverBuilder = SingleDotCrossoverBuilder(),
        populationGeneratorBuilder = HungryPopulationGeneratorBulder(),
        mutationManagerBuilder = BasicMutationManagerBuilder()
    )

    when ( code[0].toString())
    {
        "1" -> director.populationGeneratorBuilder = HungryPopulationGeneratorBulder()
        "2" -> director.populationGeneratorBuilder = RandomPopulationGeneratorBuilder()
        else -> throw Exception("Wrong input")
    }


    when ( code[1].toString())
    {
        "1" -> director.crossoverBuilder = DoubleDotCrossoverBuilder()
        "2" -> director.crossoverBuilder = SingleDotCrossoverBuilder()
        else -> throw Exception("Wrong input")
    }

    when ( code[2].toString())
    {
        "1" -> director.mutatorBuilder = InversionMutatorBuilder()
        "2" -> director.mutatorBuilder = SaltationMutatorBuilder()
        else -> throw Exception("Wrong input")
    }

    when ( code[3].toString())
    {
        "1" -> director.selectorBuilder = BTournamentSelectorBuilder()
        "2" -> director.selectorBuilder = ProportionalSelectorBuilder()
        else -> throw Exception("Wrong input")
    }
    when (code[4].toString())
    {
        "1"->director.itemBuilder = BasicItemBuilder()
        "2"->director.itemBuilder = DanningItemBuilder()
        else -> throw Exception("Wrong input")
    }

    return director
}