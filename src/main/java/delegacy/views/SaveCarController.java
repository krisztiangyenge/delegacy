package delegacy.views;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import delegacy.App;
import delegacy.model.Car;
import delegacy.service.impl.CarServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SaveCarController {
	private Logger logger = LoggerFactory.getLogger(SaveCarController.class);
	
	private CarServiceImpl carService = new CarServiceImpl();
	
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
	private void initialize(){
		errorLabel.setText("");
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
	
}
