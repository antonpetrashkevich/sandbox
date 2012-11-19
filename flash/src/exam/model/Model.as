/**
 * User: Anton
 * Date: 06.11.12
 * Time: 5:48
 */
package exam.model {
import mx.collections.ArrayCollection;

public class Model {
    [Bindable]
    private var _items:ArrayCollection = new ArrayCollection();

    private var _data:XML;

    public function Model() {
    }

    public function sort():void {

    }


    public function get items():ArrayCollection {
        return _items;
    }

    public function set items(value:ArrayCollection):void {
        _items = value;
    }


    public function get data():XML {
        return _data;
    }

    public function set data(value:XML):void {
        _data = value;
        for each (var flower:String in value..@flower) {
            items.addItem(new Flower(1, flower, flower));
        }
    }
}
}
