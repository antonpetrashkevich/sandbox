package lab3.events
{
	import flash.events.Event;

	public class SyncEvent extends Event
	{
		
		public static var SORT_CHANGE:String = "Sync";
		
		public var data : CustomListItem;
				
		public function SyncEvent(type:String, bubbles:Boolean=false, cancelable:Boolean=false, data:CustomListItem = null)
		{
			super(type, bubbles, cancelable);
			this.data = data;
		}
		
		override public function clone():Event
		{
			return new SyncEvent(type, bubbles, cancelable,data);
		}
	 
	}
}