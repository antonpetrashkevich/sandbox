/**
 * User: Anton
 * Date: 06.11.12
 * Time: 5:48
 */
package exam.controller {
import exam.model.Model;

import flash.events.Event;
import flash.net.URLLoader;
import flash.net.URLRequest;

public class Controller {
    public var model:Model = new Model();

    public function Controller() {
        readDataFromExternalFile();
    }

    private static const DATA_XML:String = "D:/Projects/sandbox/Flash/src/exam/data.xml";

    private function readDataFromExternalFile():void {
        var request:URLRequest = new URLRequest(DATA_XML);
        var loader:URLLoader = new URLLoader(request);
        loader.addEventListener(Event.COMPLETE, xmlLoaded);
    }

    private function xmlLoaded(event:Event):void {
        model.data = new XML(event.currentTarget.data);
    }

    public function sort():void {
        model.sort();
    }
}
}
