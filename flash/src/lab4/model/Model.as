package lab4.model
{
import mx.collections.ArrayCollection;

public class Model
	{
		
		[Bindable]
		public var numberOfPages:int = 1;					
		
		[Bindable]
		public var currentPage:int = 1;
		
		[Bindable]
		public var gridData:Object;
		
		[Bindable]
		public var itemsPerPage:int = 10;
		
		[Bindable]
		public var totalNumberOfRecords:String;
		
		[Bindable]
		public var typeOfConnection:String = "Remote";
		
		[Bindable]
		public var visibleColumnsItems:ArrayCollection;
		
		[Bindable]
		public var gridDataProvider:Object;
		
		public function Model()
		{
		}
	}
}