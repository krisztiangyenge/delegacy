package delegacy.views;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import delegacy.App;
import delegacy.model.Car;
import delegacy.model.Delegacy;
import delegacy.model.Worker;
import delegacy.service.impl.CarServiceImpl;
import delegacy.service.impl.DelegacyServiceImpl;
import delegacy.service.impl.WorkerServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SaveDelegacyController {
	private ObservableList<Worker> workers = FXCollections.observableArrayList();
	private ObservableList<Car> cars = FXCollections.observableArrayList();
	
	private Logger logger = LoggerFactory.getLogger(SaveDelegacyController.class);
	
	private DelegacyServiceImpl delegacyService = new DelegacyServiceImpl();
	
	private CarServiceImpl carService = new CarServiceImpl();
	private WorkerServiceImpl workerService = new WorkerServiceImpl();
	
	private Delegacy delegacy;
	

	@FXML
	private ComboBox<Worker> workerSelect;
	
	@FXML
	private ComboBox<Car> carSelect;
	
	@FXML
	private TextField startAddressField;
	
	@FXML
	private TextField endAddressField;
	
	@FXML
	private TextField distanceField;
	
	@FXML
	private TextField fuelPriceField;
	
	@FXML
	private Label errorLabel;
	
	@FXML
	private void initialize(){
		errorLabel.setText("");
		workers.addAll(workerService.getAllWorker());
		workerSelect.setItems(workers);
	}
	
	@FXML
	private void workerChange(){
		Worker worker = getSelectedWorker();
		if( worker != null ){
			
			cars.addAll(carService.getCarByWorker(worker));
			carSelect.setItems(cars);
		}
	}
	
	private Worker getSelectedWorker(){
		int index = workerSelect.getSelectionModel().getSelectedIndex();
		if(index >= 0){
			return workerSelect.getItems().get(index);
		}
		
		return null;
	}
	
	@FXML
	private void saveDelegacy(){
		try {
			if(delegacy == null) {
				delegacy = new Delegacy();
			}

			if(workers.size() > 0 && workerSelect.getItems().size()> 0) {
				delegacy.setWorkerId(workerSelect.getValue());
			}
			if(cars.size() > 0 && carSelect.getItems().size()> 0) {
				delegacy.setCarId(carSelect.getValue());
			}
			if(startAddressField.getText() != null && !startAddressField.getText().isEmpty()) {
				delegacy.setStartAddress(startAddressField.getText());
			}
			if(endAddressField.getText() != null && !endAddressField.getText().isEmpty()) {
				delegacy.setEndAddress(endAddressField.getText());
			}
			if(distanceField.getText() != null && !distanceField.getText().isEmpty()) {
				delegacy.setDistance(Double.valueOf(distanceField.getText()));
			}
			if(fuelPriceField.getText() != null && !fuelPriceField.getText().isEmpty()) {
				delegacy.setFuelPrice(Double.valueOf(fuelPriceField.getText()));
			}
			if(distanceField.getText() != null && !distanceField.getText().isEmpty() && fuelPriceField.getText() != null && !fuelPriceField.getText().isEmpty()) {
				delegacy.setPay(delegacyService.getPay(Double.valueOf(distanceField.getText()), carSelect.getValue().getConsumption(), Double.valueOf(fuelPriceField.getText())));
			}
			
			if(delegacy.getDelegacyId() == 0) {
				delegacyService.save(delegacy);
			}else {
				delegacyService.update(delegacy);
			}
			
			App.getInstance().changeView("Delegacys");
		}catch(IllegalArgumentException e){
			errorLabel.setText(e.getMessage());
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	@FXML
	private void cancel(){
		App.getInstance().changeView("Delegacys");
	}
}
