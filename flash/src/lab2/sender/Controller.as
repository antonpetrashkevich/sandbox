/**
 * User: Anton
 * Date: 09.10.12
 * Time: 17:22
 */
package lab2.sender {
public class Controller {
    private static var instance:Controller;

    private var model:DataModel = new DataModel();

    public function Controller() {
        model.loadData();
    }

    public function getDataString():String {
        return "Hello World";
    }


    public static function getInstance():Controller {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }
}
}
