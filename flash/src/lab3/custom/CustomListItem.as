package lab3.custom
{
	[Bindable]
	public class CustomListItem
	{
		
		public var id : int;
		public var name : String;		
		public var isVisible : Boolean = true;
		public var isSort : Boolean = false;
		public var isDescending : Boolean = false;
		
		public function CustomListItem(id:int, name:String)
		{
			this.id = id;
			this.name = name;
		}
	}
}