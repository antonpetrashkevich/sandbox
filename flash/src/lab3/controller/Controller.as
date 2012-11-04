package lab3.controller
{
import lab3.model.Model;

public class Controller
	{
		
		private var appModel:Model = new Model();
		
		public function Controller()
		{
		}
		
		public function get model():Model
		{
			return appModel;
		}
		
	}
}