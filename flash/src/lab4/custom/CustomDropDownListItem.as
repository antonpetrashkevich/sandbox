package lab4.custom
{
	[Bindable]
	public class CustomDropDownListItem
	{
		
		public var name : String;		
				
		public var isVisible : Boolean = true;
		
		public function CustomDropDownListItem(name:String, isVisible:Boolean)
		{
			this.name = name;
			this.isVisible = isVisible;
		}
	}
}