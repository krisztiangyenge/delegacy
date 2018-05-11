package delegacy;



import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import delegacy.datasource.ConnectionHandler;
import delegacy.model.Admin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class App extends Application{
	
	private static App instance;
	private BorderPane view;
	private Stage primaryStage;
	private Admin admin = null;
	public App() {
		instance = this;
	}
	
	private static Logger logger = LoggerFactory.getLogger(App.class); 
	
	public static App getInstance() {
		return instance;
	}
	
	private void showView(){
		Scene scene = new Scene(view);
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		
		Initialize.initializeCar();
		Initialize.initializeAdmin();
		Initialize.initializeWorker();
		Initialize.InitializeDelegacy();
		logger.info("Adatok inicializálva");
		launch(args);
	}

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Kiküldetés rendszer");
	
		
		primaryStage.setOnCloseRequest(e -> {
			this.closeHandler();
		});
		
		try{
			changeView("Login");
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
	}
	
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public void changeView(String viewFile){
		FXMLLoader loader = new FXMLLoader();
		loadView(viewFile, loader);

		if(view != null){
			this.showView();
			logger.info("Nézet váltás történt, az új nézet a "+viewFile+".fxml");
		}
	}
	
	private void loadView(String fileName, FXMLLoader loader){
		loader.setLocation(App.class.getResource("/views/"+fileName+".fxml"));
		
		try {
			view = (BorderPane)loader.load();	
		} catch (IOException e) {
			logger.error(e.getMessage());
		}	
	}
	
	public void closeHandler(){
		ConnectionHandler.closeConnection();
		System.exit(0);
	}
}
