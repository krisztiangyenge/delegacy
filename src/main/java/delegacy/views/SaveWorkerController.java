package delegacy.views;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import delegacy.App;
import delegacy.model.Worker;
import delegacy.service.impl.WorkerServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SaveWorkerController {
	private Logger logger = LoggerFactory.getLogger(SaveWorkerController.class);
	
	private WorkerServiceImpl workerService = new WorkerServiceImpl();
	
	private Worker worker;
	
	@FXML
	private TextField lastNameField;
	
	@FXML
	private TextField firstNameField;
	
	@FXML
	private Label errorLabel;
	
	@FXML
	private void initialize(){
		errorLabel.setText("");
	}
	
	@FXML
	private void saveWorker(){
		try {
			if(worker == null) {
				worker = new Worker();
			}
			if(lastNameField.getText() != null && !lastNameField.getText().isEmpty()) {
				worker.setLastName(lastNameField.getText());
			}
			if(firstNameField.getText() != null && !firstNameField.getText().isEmpty()) {
				worker.setFirstName(firstNameField.getText());
			}
			
			if(worker.getWorkerId() == 0) {
				workerService.save(worker);
			}else {
				workerService.update(worker);
			}
			
			App.getInstance().changeView("Workers");
		}catch(IllegalArgumentException e){
			errorLabel.setText(e.getMessage());
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
		}
	}
	
	@FXML
	private void cancel(){
		App.getInstance().changeView("Workers");
	}
	
}
