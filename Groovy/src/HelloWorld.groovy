
/**
 * User: APetrashkevich
 * Date: 12.04.13
 * Time: 17:01
 */


//hello.groovy
println "hello, world"
for (arg in this.args ) {
    println "Argument:" + arg;
}
// this is a comment
/* a block comment, commenting out an alternative to above:
this.args.each{ arg -> println "hello, ${arg}"}
*/

this.args.each{ arg -> println "hello, ${arg}"}

def list = ['Anton', 15, new Date()]

assert list.size()==3

list.each {arg -> print "${arg}-"}




def map = ['name':"James", 'age': 15]

println map.get('name')




for (i in list){
    println i
}


def closure = {param -> println "Hello"+param}
closure.call("Zen")

closure = {println "Hello" + it}
closure.call('Ror')

