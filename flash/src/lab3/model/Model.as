package lab3.model
{
	import mx.collections.ArrayCollection;

	public class Model
	{
		
		[Bindable]
		public var sourceRows:ArrayCollection = new ArrayCollection([
			{Num:1, Title: 'Buildings', ReferenceId: 165001, DocumentId: 'BR-001', Link:'link 1'},
			{Num:2, Title: 'Progress Reports', ReferenceId: 165002, DocumentId: 'BR-002', Link:'link 2'},
			{Num:3, Title: 'Extras', ReferenceId: 165003, DocumentId: 'BR-003', Link:'link 3'},
			{Num:4, Title: 'General', ReferenceId: 165004, DocumentId: 'BR-004', Link:'link 4'},
			{Num:5, Title: 'Cost Reports', ReferenceId: 165005, DocumentId: 'BR-005', Link:'link 5'},
			{Num:6, Title: 'Administration', ReferenceId: 165006, DocumentId: 'BR-006', Link:'link 6'},
		]);

		[Bindable]
		public var destinationRows:ArrayCollection = new ArrayCollection();
		
		[Bindable]
		public var columns:ArrayCollection = new ArrayCollection([
			new CustomListItem(1, 'Title'),
			new CustomListItem(2, 'Reference ID'),
			new CustomListItem(3, 'Document ID'),
			new CustomListItem(4, 'Link'),
		])
		
		public function Model()
		{
		}
	}
}