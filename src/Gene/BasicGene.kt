package Gene

class BasicGene : AbstractGene()
{
    private var _code : BooleanArray = BooleanArray(0)

    override fun Init(code: BooleanArray) {
        _code = code
    }

    override fun getCode(): BooleanArray {
        return _code
    }

    override fun Print() {
        for(i in _code)print( if(i) 1 else 0 )
    }

    override fun toString(): String {
        var str = ""
        for (i in this._code){
            if(i)str +=1
            else str +=0
        }
        return str
    }
}