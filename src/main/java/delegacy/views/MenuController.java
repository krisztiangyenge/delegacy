package delegacy.views;

import delegacy.App;
import javafx.fxml.FXML;

/**
 * Az menüt megjelenítő nézetért felelős controller.
 * @author Krisztian
 *
 */
public class MenuController {
	@FXML
	private void openCars(){
		App.getInstance().changeView("Cars");
	}
	
	@FXML
	private void newCar(){
		App.getInstance().changeView("saveCar");
	}
	
	@FXML
	private void openWorkers(){
		App.getInstance().changeView("Workers");
	}
	
	@FXML
	private void newWorker(){
		App.getInstance().changeView("saveWorker");
	}
	
	@FXML
	private void openDelegacys(){
		App.getInstance().changeView("Delegacys");
	}
	
	@FXML
	private void newDelegacy(){
		App.getInstance().changeView("saveDelegacy");
	}
}
