package patapava.src.shop {
import mx.collections.ArrayCollection;

public class Model {
    [Bindable]
    public var kt:ArrayCollection = new ArrayCollection(
            /*[
             {Num:67333, Name:'Готика 3', Category:'RPG', Year:2006, Price:10000},
             {Num:67899, Name:'Heroes V', Category:'Стратегии', Year:2006, Price:10000},
             {Num:67443, Name:'Симс 2', Category:'Симуляторы', Year:2006, Price:10000},
             ]*/
    );
    [Bindable]
    public var ksp:ArrayCollection = new ArrayCollection();

    var externalXML:XML = new XML();

    var movies:ArrayCollection = new ArrayCollection();
    var games:ArrayCollection = new ArrayCollection();
    var courses:ArrayCollection = new ArrayCollection();


    public function Model() {
    }
}
}