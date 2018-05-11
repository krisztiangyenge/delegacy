package delegacy.views;

import java.util.List;

import delegacy.model.Car;
import delegacy.model.Delegacy;
import delegacy.model.Worker;
import delegacy.service.impl.CarServiceImpl;
import delegacy.service.impl.DelegacyServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DelegacyListController {
	
	private static final DelegacyServiceImpl delegacyService = new DelegacyServiceImpl();
	
	private ObservableList<Delegacy> delegacys = FXCollections.observableArrayList();
	
	@FXML
	private TableView<Delegacy> delegacysTable;
	
	@FXML
	private TableColumn<Delegacy, String> car;
	
	@FXML
	private TableColumn<Delegacy, String> worker;
	
	@FXML
	private TableColumn<Delegacy, String> startAddress;
	
	@FXML
	private TableColumn<Delegacy, String> endAddress;
	
	
	@FXML
	private void initialize(){
		List<Delegacy> list = delegacyService.getAllDelegacy();
		
		if(list != null && list.size() > 0){
			delegacys.addAll(list);
		
			delegacysTable.setItems(delegacys);
			
			car.setCellValueFactory(new PropertyValueFactory<Delegacy, String>("carBrandName"));
			worker.setCellValueFactory(new PropertyValueFactory<Delegacy, String>("workerFullName"));
			startAddress.setCellValueFactory(new PropertyValueFactory<Delegacy, String>("startAddress"));
			endAddress.setCellValueFactory(new PropertyValueFactory<Delegacy, String>("endAddress"));
		}
	}
}
