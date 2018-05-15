package delegacy.views;

import java.util.List;

import delegacy.App;
import delegacy.model.Delegacy;
import delegacy.service.impl.DelegacyServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * Az kiküldetéseket megjelenítő nézetért felelős controller.
 * @author Krisztian
 *
 */
public class DelegacyListController {
	
	private static final DelegacyServiceImpl delegacyService = new DelegacyServiceImpl();
	
	private ObservableList<Delegacy> delegacys = FXCollections.observableArrayList();
	
	@FXML
	private TableView<Delegacy> delegacysTable;
	
	@FXML
	private TableColumn<Delegacy, String> cars;
	
	@FXML
	private TableColumn<Delegacy, String> worker;
	
	@FXML
	private TableColumn<Delegacy, String> startAddress;
	
	@FXML
	private TableColumn<Delegacy, String> endAddress;
	
	@FXML
	private TableColumn<Delegacy, String> distance;
	
	@FXML
	private TableColumn<Delegacy, Double> pay;
	
	@FXML
	private void initialize(){
		List<Delegacy> list = delegacyService.getAllDelegacy();
		
		if(list != null && list.size() > 0){
			delegacys.addAll(list);
		
			delegacysTable.setItems(delegacys);
			cars.setCellValueFactory(new PropertyValueFactory<Delegacy, String>("carId"));
			worker.setCellValueFactory(new PropertyValueFactory<Delegacy, String>("workerId"));
			startAddress.setCellValueFactory(new PropertyValueFactory<Delegacy, String>("startAddress"));
			endAddress.setCellValueFactory(new PropertyValueFactory<Delegacy, String>("endAddress"));
			distance.setCellValueFactory(new PropertyValueFactory<Delegacy, String>("distance"));
			pay.setCellValueFactory(new PropertyValueFactory<Delegacy, Double>("pay"));
			
			delegacysTable.getSelectionModel().selectedItemProperty().addListener((o, oldvalue, newvalue) -> modify(newvalue));
		}
	}
	private void modify(Delegacy delegacy) {
		App.getInstance().showModifyDelegacy(delegacy);
	}
}
