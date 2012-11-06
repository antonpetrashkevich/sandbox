/**
 * User: Anton
 * Date: 30.09.12
 * Time: 11:16
 */
package lab1 {
import mx.collections.ArrayCollection;
import mx.utils.StringUtil;

public class Controller {

    private static var instance:Controller;
    private var model:ListModel = ListModel.getInstance();
    private var selectedDates:Array = new Array();

    /**
     * Glue the interaction between view and model.
     */
    public function Controller() {
    }


    public static function getInstance():Controller {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }


    /*** add a new item into the list model.*/
    public function addNumber(name:String):void {
        if (dateAlreadyPicked(name)) {
            var itemId:int = findItemIdByName(name);
            for each (var object:Object in model.items) {
                if (object.data == itemId) {
                    removeItem(object)
                }
            }
            return;
        }
        if (name == null || StringUtil.trim(name).length == 0) {
            trace("emptyname");
        } else {
            var number:String = randomizeNumberBasedOnDate(name);
            model.addElement(number);
            selectedDates[number] = name;
        }
    }

    private function findItemIdByName(name:String):int {
        for (var i:int = 0; i < selectedDates.length; i++) {
            var object:Object = selectedDates[i];
            if (object == name)
                return i;
        }
        return null;
    }

    private function randomizeNumberBasedOnDate(name:String):String {
        return (uint(Math.random() * 10)).toString();
    }

    private function dateAlreadyPicked(name:String):Boolean {
        for (var date:String in selectedDates) {
            if (selectedDates[date] == name)
                return true;
        }
        return false;
    }

    public function clear():void {
        model.removeAll();
        model.removeSort();
        selectedDates = new Array();
    }

    public function getItems():ArrayCollection {
        return model.items;
    }

    public function sort():void {
        model.sort();
    }

    public function removeItem(selectedItem:Object):void {
        if (selectedItem == null) {
            trace("Nothing is selected");
            return;
        }

        model.removeItem(selectedItem);
        selectedDates[selectedItem.data] = null;
//        selectedDates.splice(selectedItem.data, 1);
    }

    public function getItemsCount():int {
        return model.items.length;
    }
}
}
