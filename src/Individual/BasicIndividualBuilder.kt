package Individual

import Builders.IndividualBuilding

class BasicIndividualBuilder : IndividualBuilding
{
    override fun Build(): AbstractIndividual {
        return BasicIndividual()
    }
}