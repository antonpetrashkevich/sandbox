/**
 * User: Anton
 * Date: 06.11.12
 * Time: 6:31
 */
package exam.model {
public class Flower {
    private var _id:int;
    private var _name:String;
    private var _description:String;


    public function Flower(id:int, name:String, description:String) {
        _id = id;
        _name = name;
        _description = description;
    }

    public function get id():int {
        return _id;
    }

    public function set id(value:int):void {
        _id = value;
    }

    public function get name():String {
        return _name;
    }

    public function set name(value:String):void {
        _name = value;
    }

    public function get description():String {
        return _description;
    }

    public function set description(value:String):void {
        _description = value;
    }
}
}
