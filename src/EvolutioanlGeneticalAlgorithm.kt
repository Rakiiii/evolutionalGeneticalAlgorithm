import Crossover.AbstractCrossover
import Fitness.AbstractFitness
import Individual.AbstractIndividual
import Item.AbstractItem
import Modificator.AbstractModificator
import MutationManager.AbstractMutationManager
import ParentSelector.AbstractParentSelector
import Parser.AbstractParser
import Population.AbstractPopulation
import PopulationGenerator.AbstractPopulationGenerator
import Selector.AbstractSelector
import kotlin.random.Random

class EvolutioanlGeneticalAlgorithm
{
    private var items : MutableList<AbstractItem> = mutableListOf()

    private lateinit var population: AbstractPopulation

    private lateinit var fitness : AbstractFitness

    fun InitFitness(fit : AbstractFitness)
    {
        if(!::fitness.isInitialized)
        {
            fitness = fit
        }
        else
        {
            throw Exception("ReInit Fitness object in EvolutionalGenetical Algorithm")
        }
    }

    private lateinit var crossover: AbstractCrossover

    fun InitCrossover( cross: AbstractCrossover)
    {
        if(!::crossover.isInitialized)
        {
            crossover = cross
        }
        else
        {
            throw Exception("ReInit Crossover object in EvolutionalGeneticalAlgorithm")
        }
    }

    private lateinit var parentSelector: AbstractParentSelector

    fun InitParentSelector(par : AbstractParentSelector)
    {
        if(!::parentSelector.isInitialized)
        {
            parentSelector = par
        }
        else
        {
            throw Exception("ReInit ParentSelector object in EvolutionalGeneticalAlgorithm")
        }
    }

    private lateinit var mutatationManager: AbstractMutationManager

    fun InitMutatorManager(mut : AbstractMutationManager)
    {
        if(!::mutatationManager.isInitialized)
        {
            mutatationManager = mut
        }
        else
        {
            throw Exception("ReInit MutationManager object in EvolutionalGeneticalAlgorithm")
        }
    }

    private lateinit var populationGenerator: AbstractPopulationGenerator

    fun InitPopulationGenerator(popGen : AbstractPopulationGenerator)
    {
        if(!::populationGenerator.isInitialized)
        {
            populationGenerator = popGen
        }
        else
        {
            throw Exception("ReInit PopulationGenerator object in EvolutionalGeneticalAlgorithm")
        }
    }

    private lateinit var selector: AbstractSelector

    fun InitSelector(sel : AbstractSelector)
    {
        if(!::selector.isInitialized)
        {
            selector = sel
        }
        else
        {
            throw Exception("ReInit Selector object in EvolutionalGeneticalAlgorithm")
        }
    }

    private lateinit var modificator: AbstractModificator
    fun InitModificator(mod:AbstractModificator)
    {
        if(!::modificator.isInitialized)
        {
            modificator = mod
        }
        else
        {
            throw Exception("ReInit Modificator object in EvolutionalGeneticalAlgorithm")
        }
    }

    private lateinit var parser: AbstractParser

    fun SetParser( par : AbstractParser)
    {
        parser = par
    }

    private lateinit var file : String
    fun SetFileWithItems(f : String)
    {
        file = f
    }

    private var populationSize : Int = 0
    fun SetPopulationSize( size : Int)
    {
        if(size > 0)
        {
            populationSize = size
        }
        else throw Exception("PopulationSize cannot be below zero")
    }

    fun Run(amountOfItterations : Int):AbstractIndividual
    {
        if(!this.IsInitialized())throw Exception("EvolutionalGeneticalAlgorithm is not Initialized")

        val res = parser.ParseItemsFromFile(file)

        items = res.first
        if(items.isEmpty())throw Exception("Wrong items input")

        fitness.Init(items)

        populationGenerator.Init(items , res.second)

        populationGenerator.InitFitness(fitness)

        parentSelector.Init(populationSize/2)

        population = populationGenerator.GeneratePopolation(populationSize)

        //debug
        population.Print()
        //debug

        var parents : MutableList< Pair<AbstractIndividual , AbstractIndividual> >

        var childrens : MutableList<AbstractIndividual> = mutableListOf()

        for(i in 0 until amountOfItterations)
        {
            childrens.clear()

            parents = parentSelector.SelectParentsPair(population)

            for(j in parents)
            {
                childrens.add(crossover.Cross(j))
            }

            childrens = mutatationManager.Mutate(childrens)

            population = selector.SelectNewPopulation(population , childrens)

            population = modificator.ModifyPopulation(population , items , res.second)
        }

        var bestIndividual : AbstractIndividual = population.Individual(0)
        for(i in 1 until population.Size())
        {
            if(population.Individual(i).Fitness() > bestIndividual.Fitness())bestIndividual = population.Individual(i)
        }

        return bestIndividual
    }

    fun IsInitialized():Boolean
    {
        return (
                ::selector.isInitialized &&
                        ::populationGenerator.isInitialized &&
                        ::parentSelector.isInitialized &&
                        ::modificator.isInitialized &&
                        ::crossover.isInitialized &&
                        ::mutatationManager.isInitialized &&
                        ::fitness.isInitialized &&
                        ::parser.isInitialized &&
                        ::file.isInitialized &&
                        populationSize > 0
                )
    }

}