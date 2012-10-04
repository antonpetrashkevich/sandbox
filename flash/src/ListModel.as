/**
 * User: Anton
 * Date: 30.09.12
 * Time: 11:16
 */
package {
import mx.collections.ArrayCollection;
import mx.collections.Sort;
import mx.collections.SortField;

public class ListModel {

    [Bindable(event="itemsChanged")]
    private var _items:ArrayCollection = new ArrayCollection();
    private static var instance:ListModel;

    public function ListModel() {
        instance = this;
    }

    /**
     * For this demo we treat this class as singletone.
     * If list is reused the component that reuse it
     * must keep reference to model and controler.
     */
    public static function getInstance():ListModel {
        if (instance == null) {
            instance = new ListModel();
        }
        return instance;
    }

    /**
     * Add a new element to the list, the model is bindable,
     * no further actions are required, the view
     * is notified automatically.
     */
    public function addElement(itm:String):void {
        _items.addItem({label:itm, data:itm});
        trace(" item added, now we have: " + _items.length + "_itemss");
    }

    public function removeAll():void {
        _items.removeAll();
    }

    public function sort():void {
        var dataSortField:SortField = new SortField();
        dataSortField.name = "data";
        dataSortField.numeric = true;
        var numericDataSort:Sort = new Sort();
        numericDataSort.fields = [dataSortField];
        _items.sort = numericDataSort;
        _items.refresh();
    }

    public function get items():ArrayCollection {
        return _items;
    }

    public function removeSort():void {
        _items.sort = null;
        _items.refresh();
    }

    public function removeItem(selectedItem:Object):void {
        var itemIndex:int = _items.getItemIndex(selectedItem);
        _items.removeItemAt(itemIndex);
    }
}
}







