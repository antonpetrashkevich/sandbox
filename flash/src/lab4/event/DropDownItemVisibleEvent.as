package lab4.event
{
import flash.events.Event;

import lab4.custom.CustomDropDownListItem;

public class DropDownItemVisibleEvent extends Event
	{
		
		public static const VISIBLE:String = "changeVisible";
		public var item:CustomDropDownListItem;
		
		public function DropDownItemVisibleEvent(type:String, item:CustomDropDownListItem, 
												 bubbles:Boolean=false, 
												 cancelable:Boolean=false)
		{
			super(type, bubbles, cancelable);
			this.item = item;
		}
		
		override public function clone():Event {
			return new DropDownItemVisibleEvent(type, item, bubbles, cancelable);
		}
	}
}
