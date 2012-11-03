/**
 * User: Anton
 * Date: 09.10.12
 * Time: 17:22
 */
package lab2.receiver {
import flash.events.MouseEvent;
import flash.events.StatusEvent;
import flash.net.LocalConnection;

import mx.controls.Alert;

public class Controller {
    private static var instance:Controller;
    private var _model:Model = new Model();
    private var connectionSender:LocalConnection;
    private var connectionReceiver:LocalConnection;


    public static function getInstance():Controller {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public function Controller() {
        connectionSender = new LocalConnection();
        connectionSender.addEventListener(StatusEvent.STATUS, onStatus);

        connectionReceiver = new LocalConnection();
        connectionReceiver.allowDomain("*");
        connectionReceiver.client = this;
        try {
            connectionReceiver.connect("app2conn");
        } catch(error:ArgumentError) {
            Alert.show("Unable to connect");
        }
    }

    public function updateExternalData(message:String):void
    {
        this._model.externalData = message;
    }

    public function sendMessageClickHandler(event:MouseEvent):void
    {
        connectionSender.send("app1conn", "updateExternalData", this._model.dataToSend);
    }


    public function get model():Model {
        return _model;
    }

    private function onStatus(event:StatusEvent):void {
        switch (event.level) {
            case "error":
                Alert.show("Unable to send message to App 1");
                break;
        }
    }
}
}
