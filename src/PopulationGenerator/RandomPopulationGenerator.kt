package PopulationGenerator

import Fitness.AbstractFitness
import Individual.AbstractIndividual
import Item.AbstractItem
import Population.AbstractPopulation
import kotlin.random.Random

class RandomPopulationGenerator : AbstractPopulationGenerator()
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
        else throw Exception("ReInit items in RandomPopulationGenerator")
    }


    override fun InitFitness(fit: AbstractFitness)
    {
        if(!::fitness.isInitialized)
        {
            fitness = fit
        }
        else throw Exception("ReInit Fitness in RandomPopulationGenerator")
    }

    override fun GeneratePopolation(size: Int): AbstractPopulation
    {
        if(!::items.isInitialized && !::fitness.isInitialized && !this.isInitialized())throw Exception("RandomPopulationGenerator is not initialized")
        val result = populationBuilder.Build()
        val subResult : MutableList<AbstractIndividual> = mutableListOf()

        for(i in 0 until size)
        {
            val subCode = BooleanArray( items.size , { false})
            val chosed : HashSet<Int> = hashSetOf()
            var rndItem = Random.nextInt(0 , items.size)
            var total = 0

            chosed.add(rndItem)
            //subCode[rndItem] = true

            //rndItem = Random.nextInt(0 , items.size)

            while(total + items[rndItem].Weight() < maxWeight)
            {
                total += items[rndItem].Weight()
                chosed.add(rndItem)
                subCode[rndItem] = true

                while (!chosed.add(rndItem))
                {
                    rndItem = Random.nextInt(0, items.size)
                }
            }

            val newGene = geneBuilder.Build()
            val newIndividual = individualBuilder.Build()

            newGene.Init(subCode)
            newIndividual.Init(newGene)
            newIndividual.InitFitness(fitness)

            subResult.add(newIndividual)
        }

        result.Init(subResult)

        return result


    }
}