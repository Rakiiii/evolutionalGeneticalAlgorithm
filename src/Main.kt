import Builders.EvolutionalGeneticalAlgorithmBuildingDirector
import Crossover.SingleDotCrossoverBuilder
import Fitness.BasicFitnessBuilder
import Gene.BasicGeneBuilder
import Individual.BasicIndividualBuilder
import Modificator.BasicModificatorBuilder
import MutationManager.BasicMutationManagerBuilder
import Mutator.SaltationMutatorBuilder
import ParentSelector.RandomParentSelectorBuilder
import Population.BasicPopulationBuilder
import PopulationGenerator.HungryPopulationGeneratorBulder
import Selector.BasicSelectorBuilder

fun main(argc : Array<String>)
{

    val director = EvolutionalGeneticalAlgorithmBuildingDirector(
        fitnessBuilder = BasicFitnessBuilder() ,
        selectorBuilder = BasicSelectorBuilder() ,
        parentSelectorBuilder = RandomParentSelectorBuilder(),
        modificatorBuilder = BasicModificatorBuilder(),
        mutatorBuilder = SaltationMutatorBuilder() ,
        geneBuilder = BasicGeneBuilder(),
        individualBuilder = BasicIndividualBuilder(),
        populationBuilder = BasicPopulationBuilder(),
        crossoverBuilder = SingleDotCrossoverBuilder(),
        populationGeneratorBuilder = HungryPopulationGeneratorBulder(),
        mutationManagerBuilder = BasicMutationManagerBuilder()
    )

    val algorithm = director.Build()

    algorithm.SetFileWithItems(argc[0])
    algorithm.SetPopulationSize( argc[1].toInt() )
    val result = algorithm.Run(argc[2].toInt())

    println("Result:")
    result.Print()
    println()
}