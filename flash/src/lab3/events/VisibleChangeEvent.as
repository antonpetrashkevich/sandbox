package lab3.events
{
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;	
	
	public class VisibleChangeEvent extends Event
	{
		
		public static var VISIBLE_CHANGE:String = "VisibleChange";
		
		private var _data:CustomListItem;
		
		public function VisibleChangeEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false, data:CustomListItem=null)
		{
			super(type, bubbles, cancelable);
			_data = data;
		}
		
		override public function clone():Event
		{
			return new VisibleChangeEvent(type, bubbles, cancelable, data);
		}
		
		public function get data():CustomListItem
		{
			return _data;
		}
	}
	
}