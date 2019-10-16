import Builders.EvolutionalGeneticalAlgorithmBuildingDirector
import Crossover.DoubleDotCrossoverBuilder
import Crossover.SingleDotCrossoverBuilder
import Fitness.BasicFitnessBuilder
import Gene.BasicGeneBuilder
import Individual.BasicIndividualBuilder
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

fun main(argc : Array<String>)
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

    if(! (argc[0] == "-debug"))
    {
        println("choose first population generator:")
        println("1.Hungry population generator")
        println("2.Random population generator")
        when ( readLine())
        {
            "1" -> director.populationGeneratorBuilder = HungryPopulationGeneratorBulder()
            "2" -> director.populationGeneratorBuilder = RandomPopulationGeneratorBuilder()
            else -> throw Exception("Wrong input")
        }

        println("choose crossover:")
        println("1.Double dot crossover")
        println("2.Single dot crossover")
        when ( readLine())
        {
            "1" -> director.crossoverBuilder = DoubleDotCrossoverBuilder()
            "2" -> director.crossoverBuilder = SingleDotCrossoverBuilder()
            else -> throw Exception("Wrong input")
        }

        println("choose way of mutation:")
        println("1.Inversion mutationr")
        println("2.Saltation mutation")
        when ( readLine())
        {
            "1" -> director.mutatorBuilder = InversionMutatorBuilder()
            "2" -> director.mutatorBuilder = SaltationMutatorBuilder()
            else -> throw Exception("Wrong input")
        }

        println("choose way of selection:")
        println("1.BTournamnet selection")
        println("2.Proportional selection")
        when ( readLine())
        {
            "1" -> director.selectorBuilder = BTournamentSelectorBuilder()
            "2" -> director.selectorBuilder = BTournamentSelectorBuilder()
            else -> throw Exception("Wrong input")
        }

    }

    val algorithm = director.Build()

    algorithm.SetFileWithItems(argc[argc.size - 3])
    algorithm.SetPopulationSize(argc[argc.size - 2].toInt())
    val result = algorithm.Run(argc[argc.size - 1].toInt())

    println("Result:")
    result.Print()
    println()
}