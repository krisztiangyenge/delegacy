package delegacy.views;

import java.util.List;

import delegacy.model.Car;
import delegacy.service.impl.CarServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CarListController {
	
	private static final CarServiceImpl carService = new CarServiceImpl();
	
	private ObservableList<Car> cars = FXCollections.observableArrayList();
	
	@FXML
	private TableView<Car> carsTable;
	
	@FXML
	private TableColumn<Car, String> plateNumber;
	
	@FXML
	private TableColumn<Car, String> brand;
	
	@FXML
	private TableColumn<Car, String> carName;
	
	@FXML
	private TableColumn<Car, Double> carConsumption;
	
	
	@FXML
	private void initialize(){
		List<Car> list = carService.getAllCars();
		
		if(list != null && list.size() > 0){
			cars.addAll(list);
		
			carsTable.setItems(cars);
			
			plateNumber.setCellValueFactory(new PropertyValueFactory<Car, String>("plateNumber"));
			brand.setCellValueFactory(new PropertyValueFactory<Car, String>("brand"));
			carName.setCellValueFactory(new PropertyValueFactory<Car, String>("carName"));
			carConsumption.setCellValueFactory(new PropertyValueFactory<Car, Double>("consumption"));
		}
	}
}
