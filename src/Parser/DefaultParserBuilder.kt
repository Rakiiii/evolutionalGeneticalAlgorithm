package Parser

import Builders.ParserBuilding

class DefaultParserBuilder : ParserBuilding
{
    override fun Build(): AbstractParser {
        return DefaultParser()
    }
}