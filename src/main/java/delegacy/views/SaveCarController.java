package delegacy.views;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import delegacy.App;
import delegacy.model.Car;
import delegacy.model.Worker;
import delegacy.service.impl.CarServiceImpl;
import delegacy.service.impl.WorkerServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Az autó mentés nézetért felelős controller.
 * @author Krisztian
 *
 */
public class SaveCarController {
	private ObservableList<Worker> owners = FXCollections.observableArrayList();

	private Logger logger = LoggerFactory.getLogger(SaveCarController.class);
	
	private CarServiceImpl carService = new CarServiceImpl();
	private WorkerServiceImpl workerService = new WorkerServiceImpl();
	
	private Car car;
	
	@FXML
	private TextField plateNumberField;
	
	@FXML
	private TextField brandField;
	
	@FXML
	private TextField nameField;
	
	@FXML
	private TextField consumptionField;
	
	@FXML
	private Label errorLabel;
	
	@FXML
	private ComboBox<Worker> ownerSelect;
	
	@FXML
	private void initialize(){
		errorLabel.setText("");
		owners.addAll(workerService.getAllWorker());
		ownerSelect.setItems(owners);
	}
	
	
	@FXML
	private void saveCar(){
		try {
			if(car == null) {
				car = new Car();
			}
			if(plateNumberField.getText() != null && !plateNumberField.getText().isEmpty()) {
				car.setPlateNumber(plateNumberField.getText());
			}
			if(brandField.getText() != null && !brandField.getText().isEmpty()) {
				car.setBrand(brandField.getText());
			}
			if(nameField.getText() != null && !nameField.getText().isEmpty()) {
				car.setCarName(nameField.getText());
			}
			if(consumptionField.getText() != null && !consumptionField.getText().isEmpty()) {
				car.setConsumption(Double.valueOf(consumptionField.getText()));
			}
			if(owners.size() > 0 && ownerSelect.getItems().size()> 0) {
				car.setOwner(ownerSelect.getValue());
			}
			if(car.getCarId() == 0) {
				carService.save(car);
			}else {
				carService.update(car);
			}
			
			App.getInstance().changeView("Cars");
		}catch(IllegalArgumentException e){
			errorLabel.setText(e.getMessage());
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	@FXML
	private void cancel(){
		App.getInstance().changeView("Cars");
	}
	
	/**
	 * A módosítandó autót beállító metódus.
	 * @param car A módosítandó autó
	 */
	public void setCar(Car car){
		this.car = car;
		
		if(this.car != null) {
			plateNumberField.setText(this.car.getPlateNumber());
			brandField.setText(this.car.getBrand());
			nameField.setText(this.car.getCarName());
			consumptionField.setText(String.valueOf(this.car.getConsumption()));
			ownerSelect.setValue(this.car.getOwner());
		}
	}
	
}
