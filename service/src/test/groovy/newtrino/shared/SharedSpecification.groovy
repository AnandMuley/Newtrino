package newtrino.shared

import spock.lang.Specification

class SharedSpecification extends Specification{

    def setup(){
        enableStrictMocking()
    }

    def enableStrictMocking(){
        0 * _
    }

}
