/**
 * User: Anton
 * Date: 09.10.12
 * Time: 17:22
 */
package lab2.sender {
import flash.events.Event;
import flash.events.MouseEvent;
import flash.events.StatusEvent;
import flash.net.LocalConnection;
import flash.net.URLLoader;
import flash.net.URLRequest;

import mx.controls.Alert;


public class Controller {
    private static var instance:Controller;

    private var _model:DataModel = new DataModel();
    private var connectionSender:LocalConnection;
    private var connectionReceiver:LocalConnection;


    private static const DATA_FILE_URL:String = "D:/Projects/sandbox/Flash/src/lab2/sender/data.xml";


    public static function getInstance():Controller {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }


    public function Controller() {
        var xmlDataRequest:URLRequest = new URLRequest(DATA_FILE_URL);
        var xmlDataLoader:URLLoader = new URLLoader(xmlDataRequest);
        xmlDataLoader.addEventListener(Event.COMPLETE, xmlLoaded);


        initializeConnections();
    }

    private function initializeConnections():void {
        connectionSender = new LocalConnection();
        connectionSender.addEventListener(StatusEvent.STATUS, onStatus);

        connectionReceiver = new LocalConnection();
        connectionReceiver.allowDomain("*");
        connectionReceiver.client = this;
        try {
            connectionReceiver.connect("app1conn");
        } catch (error:ArgumentError) {
            Alert.show("Unable to connect");
        }
    }

    public function updateExternalData(message:String):void
    {
        this.model.externalData = message;
    }

    private function xmlLoaded(event:Event):void {
       _model.xmlData = new XML(event.currentTarget.data);
       updateTypes();
    }

    private function updateTypes():void {
        var typeStr:String;
        for each (var type in model.xmlData..@type)
        {
            typeStr = type.toString();
            if (!model.types.contains(typeStr))
            {
                model.types.addItem(typeStr);
            }
        }
    }


    public function get model():DataModel {
        return _model;
    }

    public function selectSquareClickHandler(event:MouseEvent):void {
        var selection:XML = <selection></selection>;
        var square:int = parseInt(model.selectedSquare);
        for each (var pod:XML in model.xmlData..pod.(isValidSquare(square, @height, @width)))
        {
            selection.appendChild(pod);
        }
        model.messageToSend = selection.toString();
    }

    private function isValidSquare(square:int, height:int, width:int):Boolean
    {

        switch(model.selectedOperation)
        {
            case "<":
                return height * width < square;
            case "<=":
                return height * width <= square;
            case "=":
                return height * width == square;
            case ">=":
                return height * width >= square;
            case ">":
                return height * width > square;
        }
        return false;
    }

    public function selectSquareTypeHandler(event:MouseEvent):void {
        var selection:XML = <selection></selection>;
        for each (var pod:XML in model.xmlData..pod.(@type == model.selectedType))
        {
            selection.appendChild(pod);
        }
        model.messageToSend = selection.toString();
    }

    public function sendSelectionClickHandler(event:MouseEvent):void {
        connectionSender.send("app2conn", "updateExternalData", this.model.messageToSend);
    }

    private function onStatus(event:StatusEvent):void {
        switch (event.level) {
            case "error":
                Alert.show("Unable to send message to App 2");
                break;
        }
    }

}
}
