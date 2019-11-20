package Individual

import Fitness.AbstractFitness
import Gene.AbstractGene

class BasicIndividual : AbstractIndividual()
{
    private lateinit var _gene : AbstractGene

    private lateinit var _fitness : AbstractFitness

    override fun Fitness(): Int
    {
        if(::_fitness.isInitialized) return _fitness.Fitness(_gene.getCode())
        else throw Exception("BasicIndividual is not Initialized")
    }

    override fun Gene(): AbstractGene
    {
        if(::_gene.isInitialized) return _gene
        else throw Exception("BasicIndividual is not Initialized")
    }

    override fun Init(gene: AbstractGene)
    {
        _gene = gene
    }

    override fun InitFitness(fit: AbstractFitness)
    {
        _fitness = fit
    }

    override fun GetFitness(): AbstractFitness
    {
        return _fitness
    }

    override fun TotalWeight(): Int {
        if(::_fitness.isInitialized) return _fitness.TotalWeight(_gene.getCode())
        else throw Exception("BasicIndividual is not Initialized")
    }

    override fun Print() {
        if(::_gene.isInitialized && ::_fitness.isInitialized)
        {
            print("Code:")
            _gene.Print()
            print(" | ")
            print(this.Fitness().toString())
            print(" | ")
            print(this.TotalWeight())
        }
        else throw Exception("BasicIndividual is not Initialized")
    }

    override fun toString(): String {
        if(::_gene.isInitialized && ::_fitness.isInitialized)
        {
            var str = "Code:"
            str += _gene.toString()+" | "+this.Fitness().toString()+" | "+this.TotalWeight().toString()
            return str
        }
        else throw Exception("BasicIndividual is not Initialized")
    }
}