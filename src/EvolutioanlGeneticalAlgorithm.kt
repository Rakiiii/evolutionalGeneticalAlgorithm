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
import Utils.printlnToFile

class EvolutioanlGeneticalAlgorithm
{
    private val maxIt = 3

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

        var prevBest : AbstractIndividual? = null
        var counter = 0

        val res = parser.ParseItemsFromFile(file)

        items = res.first
        if(items.isEmpty())throw Exception("Wrong items input")

        fitness.Init(items)

        populationGenerator.Init(items , res.second)

        populationGenerator.InitFitness(fitness)

        parentSelector.Init(populationSize/2)

        population = populationGenerator.GeneratePopolation(populationSize)

        var parents : MutableList< Pair<AbstractIndividual , AbstractIndividual> >

        var childrens : MutableList<AbstractIndividual> = mutableListOf()

        for(i in 0 until amountOfItterations)
        {
            printlnToFile("population number " + i.toString() + " :\n"+population.toString())

            println("population number " + i.toString() + " :")
            population.Print()

            printlnToFile("Best individual:\n"+population.getBestIndividual().toString())



            println("Best individual:")
            population.getBestIndividual().Print()
            //println()
            //println()

            childrens.clear()

            parents = parentSelector.SelectParentsPair(population)
            //println("parents selected")

            for(j in parents)
            {
                childrens.add(crossover.Cross(j))
            }

            /*
            println("debug start")
            for(j in childrens)j.Print()
            println("debug ends")
            */
            //println("crossed")

            childrens = mutatationManager.Mutate(childrens)

            //println("childrens mutated")

            population = selector.SelectNewPopulation(population , childrens)

            //println("population selected")

            population = modificator.ModifyPopulation(population , items , res.second)

            val bestIndividual : AbstractIndividual = population.getBestIndividual()

            prevBest?.let {
                if (it.Fitness() == bestIndividual.Fitness())counter ++
                else counter = 0
                if( counter >= maxIt)return bestIndividual
            }
            prevBest = bestIndividual
        }

        val bestIndividual : AbstractIndividual =population.getBestIndividual()

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