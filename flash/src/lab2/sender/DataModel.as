/**
 * User: Anton
 * Date: 10.10.12
 * Time: 15:10
 */
package lab2.sender {
import flash.events.Event;
import flash.net.URLLoader;
import flash.net.URLRequest;

[Bindable]
public class DataModel {

    private var xmlData:XML = new XML();
    private var dataFileURL:String = "D:/Projects/sandbox/Flash/src/lab2/sender/data.xml";
    private var xmlDataRequest:URLRequest = new URLRequest(dataFileURL);
    private var xmlDataLoader:URLLoader = new URLLoader(xmlDataRequest);

    public function DataModel() {
        xmlDataLoader.addEventListener(Event.COMPLETE, xmlLoaded);
    }

    private function xmlLoaded(event:Event):void {
        trace(event);
    }

    public function loadData():void {
        xmlDataLoader.load(xmlDataRequest);
        trace("Data loaded.");
    }
}
}
