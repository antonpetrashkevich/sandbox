package patapava.src.shop {
import flash.events.Event;
import flash.net.URLLoader;
import flash.net.URLRequest;

import mx.events.FlexEvent;

public class Controller {
    public var model:Model = new Model();

    private static var instance:Controller;

    public static function getInstance():Controller {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public function Controller() {
    }


    private function onXmlLoad(event:Event):void {
        model.externalXML = new XML(event.target.data);

        for each (var e:XML in model.externalXML..movies) {
            for each(var d:XML in e.item) {
                model.movies.addItem(new MyItem(d.@id, d.@title, d.@type, d.@year, d.@price));
                model.kt.addItem(new MyItem(d.@id, d.@title, d.@type, d.@year, d.@price));
            }
        }
        for each (var e:XML in model.externalXML..games) {
            for each(var d:XML in e.item) {
                model.games.addItem(new MyItem(d.@id, d.@title, d.@type, d.@year, d.@price));
                model.kt.addItem(new MyItem(d.@id, d.@title, d.@type, d.@year, d.@price));
            }
        }
        for each (var e:XML in model.externalXML..courses) {
            for each(var d:XML in e.item) {
                model.courses.addItem(new MyItem(d.@id, d.@title, d.@type, d.@year, d.@price));
                model.kt.addItem(new MyItem(d.@id, d.@title, d.@type, d.@year, d.@price));
            }
        }
    }

    public function creationCompleteHandler(event:FlexEvent):void {
        //model.kt = model.movies;
    }

    public function initialize():void {
        var loader:URLLoader = new URLLoader();
        loader.load(new URLRequest("data.xml"));
        loader.addEventListener(Event.COMPLETE, onXmlLoad);

    }
}
}