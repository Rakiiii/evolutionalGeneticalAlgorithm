package Builders

import Parser.AbstractParser


interface ParserBuilding
{
    fun Build():AbstractParser
}