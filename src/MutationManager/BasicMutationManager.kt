package MutationManager

import Individual.AbstractIndividual
import Mutator.AbstractMutator
import kotlin.random.Random

class BasicMutationManager : AbstractMutationManager()
{
    private lateinit var mutator : AbstractMutator
    override fun InitMutator(mut: AbstractMutator)
    {
        if(!::mutator.isInitialized)
        {
            mutator = mut
        }
        else throw Exception("ReInit Mutator in BasicMutatorManager")
    }

    override fun Mutate(childrens: MutableList<AbstractIndividual>): MutableList<AbstractIndividual>
    {
        if(!::mutator.isInitialized)throw Exception("Mutator in BasicMutatorManager is not initialized")

        val mutants : HashSet<Int> = hashSetOf()
        val amountOfMutants = Random.nextInt(0,childrens.size/2)
        for(j in 0 until amountOfMutants)
        {
            var rndChildren = Random.nextInt(0 , childrens.size)
            while(!mutants.add(rndChildren))
            {
                rndChildren = Random.nextInt(0 , childrens.size)
            }
        }

        for(j in mutants)
        {
            childrens[j] = mutator.Mutate(childrens[j])
        }

        return childrens

    }
}