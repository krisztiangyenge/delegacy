package delegacy.views;

import java.util.List;

import delegacy.App;
import delegacy.model.Worker;
import delegacy.service.impl.WorkerServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class WorkerListController {
	
	private static final WorkerServiceImpl workerService = new WorkerServiceImpl();
	
	private ObservableList<Worker> workers = FXCollections.observableArrayList();
	
	@FXML
	private TableView<Worker> workersTable;
	
	@FXML
	private TableColumn<Worker, String> firstName;
	
	@FXML
	private TableColumn<Worker, String> lastName;
	
	
	@FXML
	private void initialize(){
		List<Worker> list = workerService.getAllWorker();
		
		if(list != null && list.size() > 0){
			workers.addAll(list);
		
			workersTable.setItems(workers);
			
			firstName.setCellValueFactory(new PropertyValueFactory<Worker, String>("firstName"));
			lastName.setCellValueFactory(new PropertyValueFactory<Worker, String>("lastName"));
			
			workersTable.getSelectionModel().selectedItemProperty().addListener((o, oldvalue, newvalue) -> modify(newvalue));
		}
	}
	
	private void modify(Worker worker) {
			App.getInstance().showModifyWorker(worker);
	}
}
