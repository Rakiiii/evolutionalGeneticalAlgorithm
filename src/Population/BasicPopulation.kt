package Population

import Individual.AbstractIndividual

class BasicPopulation : AbstractPopulation()
{
    private lateinit var _individuals : MutableList<AbstractIndividual>

    override fun Size(): Int
    {
        if(::_individuals.isInitialized) return _individuals.size
        else throw Exception("BasicPopulation is not initialized")
    }

    override fun Individual(number: Int): AbstractIndividual
    {
        if(::_individuals.isInitialized) return _individuals[number]
        else throw Exception("BasicPopulation is not Initialized")
    }

   /* override fun SetIndividual(number: Int, individual: AbstractIndividual) {
        if(::_individuals.isInitialized)_individuals[number] = individual
        else throw Exception("Population is not initialized")
    }*/

    override fun Init(ind: MutableList<AbstractIndividual>) {
        _individuals = ind
    }

    override fun Copy(): AbstractPopulation
    {
        val copy : MutableList<AbstractIndividual> = mutableListOf()
        for(i in _individuals)
        {
            copy.add(i)
        }

        val result = BasicPopulation()
        result.Init(copy)

        return result
    }

    override fun getCopyOfIndividuals(): MutableList<AbstractIndividual>
    {
        val copy : MutableList<AbstractIndividual> = mutableListOf()
        for(i in _individuals)
        {
            copy.add(i)
        }
        return copy
    }

    override fun Print() {
        if(::_individuals.isInitialized)
        {
            for(i in _individuals)
            {
                i.Print()
                println()
            }
        }
        else
        {
            throw Exception("Population is not initialized")
        }
    }

    override fun getBestIndividual(): AbstractIndividual {
        var bestInd = _individuals.first()
        _individuals.forEach { ind -> if(ind.Fitness() > bestInd.Fitness()) bestInd = ind }
        return bestInd
    }

    override fun toString(): String {
        if(::_individuals.isInitialized)
        {
            var str : String = ""
            for(i in _individuals)
            {
                str += i.toString()+"\n"
            }
            return str
        }
        else
        {
            throw Exception("Population is not initialized")
        }
    }
}