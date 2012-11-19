package patapava.src.shop {

import flash.events.Event;

import lab3.custom.CustomListItem;

public class SortChangeEvent extends Event {

    public static var SORT_CHANGE:String = "SortChange";

    //private var _data:CustomListItem;

    public function SortChangeEvent(type:String, bubbles:Boolean, cancelable:Boolean, data:CustomListItem)
        //,data:CustomListItem=null)
    {
        super(type, bubbles, cancelable);
        //		_data = data;
    }

    override public function clone():Event {
        return new SortChangeEvent(type, bubbles, cancelable, data);
    }

    public function get data():CustomListItem {
        //	return _data;
    }
}
}