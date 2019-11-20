package PopulationGenerator

import Fitness.AbstractFitness
import Individual.AbstractIndividual
import Item.AbstractItem
import Population.AbstractPopulation
import kotlin.random.Random

class HungryPopulationGenetator : AbstractPopulationGenerator()
{
    private lateinit var items : MutableList<AbstractItem>

    private var maxWeight : Int = 0

    private lateinit var fitness: AbstractFitness

    override fun Init(_items: MutableList<AbstractItem> , _maxWeight : Int)
    {
        if (!::items.isInitialized)
        {
            items = _items
            maxWeight = _maxWeight
        }
        else throw Exception("ReInit items in HungryPopulationGenerator")
    }


    override fun InitFitness(fit: AbstractFitness)
    {
        if(!::fitness.isInitialized)
        {
            fitness = fit
        }
        else throw Exception("ReInit Fitness in HungryPopulationGenerator")
    }

    override fun GeneratePopolation(size: Int): AbstractPopulation
    {
        if(!::items.isInitialized && !::fitness.isInitialized && !this.isInitialized())throw Exception("HungryPopulationGenerator is not initialized")
        if( size > items.size)throw Exception("Incorrect population size for HungryPopulationGenerator")
        val result = populationBuilder.Build()
        val subResult : MutableList<AbstractIndividual> = mutableListOf()
        val choosed : HashSet<Int> = hashSetOf()

        items.sortedWith(compareBy { it.Value() })

        for(i in 0 until size)
        {
            var rndItem = Random.nextInt(0 , items.size)
            while(!choosed.add(rndItem))
            {
                rndItem = Random.nextInt(0 , items.size)
            }
            var total = items[rndItem].Weight()
            val subCode = BooleanArray( items.size , { false})
            var counter = 1
            subCode[rndItem] = true

            while(rndItem+counter < items.size && total + items[rndItem+counter].Weight() < maxWeight)
            {
                subCode[rndItem+counter] = true
                total += items[rndItem + counter].Weight()
                counter++
            }

            val newGene = geneBuilder.Build()
            val newIndividual = individualBuilder.Build()

            newGene.Init(subCode)
            newIndividual.Init(newGene)
            newIndividual.InitFitness(fitness)
            //println(newIndividual.Fitness())
            subResult.add(newIndividual)
        }

        result.Init(subResult)

        return result
    }

}