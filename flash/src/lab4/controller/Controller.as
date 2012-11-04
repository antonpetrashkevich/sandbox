package lab4.controller
{
import lab4.CustomDropDownListItem;
import lab4.model.AppModel;

import mx.collections.ArrayCollection;
import mx.core.UIComponent;
import mx.events.DragEvent;
import mx.events.IndexChangedEvent;
import mx.managers.DragManager;

public class Controller
	{
		[Bindable]
		public var model:AppModel = new AppModel(); 
		
		public function Controller()
		{
		}			
							
		
		public function list_acceptDropHandler(event:DragEvent):void
		{
			event.preventDefault();
			var items:Array = event.dragSource.dataForFormat("items") as Array;
			if (items[0].Visible == 1) {
				DragManager.acceptDragDrop(event.currentTarget as UIComponent);	
			}				
		}
		
		public function list_dragDropHandler(event:DragEvent):void
		{
			event.preventDefault();
			var dataProvider:ArrayCollection = new ArrayCollection();
			var items:Array = event.dragSource.dataForFormat("items") as Array;
			var item = items[0];				
			for each (var column:CustomDropDownListItem in model.visibleColumnsItems)
			{
				dataProvider.addItem(column.name + ": " + item[column.name]);	
			}
			event.currentTarget.dataProvider = dataProvider;
		}
		
		public function grid_headerShiftHandler(event:IndexChangedEvent):void
		{
			var oldIndexItem:CustomDropDownListItem = model.visibleColumnsItems.getItemAt(event.oldIndex) as CustomDropDownListItem;
			if (event.newIndex < event.oldIndex)
			{
				for (var i:int = event.oldIndex - 1; i >= event.newIndex; --i)
				{
					model.visibleColumnsItems.setItemAt(model.visibleColumnsItems.getItemAt(i), i + 1);				
				}					
			} else {
				for (var i:int = event.oldIndex; i < event.newIndex; ++i)
				{
					model.visibleColumnsItems.setItemAt(model.visibleColumnsItems.getItemAt(i + 1), i);				
				}	
			}
			model.visibleColumnsItems.setItemAt(oldIndexItem, event.newIndex);				
		}
		
		public function setNumberOfPages(recordsCount:int):void 
		{
			model.numberOfPages = 1 + (recordsCount - 1) / model.itemsPerPage;		
		}
		
		
	}
}