package delegacy;



import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import delegacy.datasource.ConnectionHandler;
import delegacy.model.Admin;
import delegacy.model.Car;
import delegacy.model.Delegacy;
import delegacy.model.Worker;
import delegacy.views.SaveCarController;
import delegacy.views.SaveDelegacyController;
import delegacy.views.SaveWorkerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Az alkalmazás fő controllere.
 * @author Krisztian
 *
 */

public class App extends Application{
	
	
	/**
	 * Az App osztály példánya.
	 */
	private static App instance;
	
	/**
	 * Az alkalmazás nézete.
	 */
	private BorderPane view;
	
	/**
	 * Az alkalmazás Stage-e.
	 */
	private Stage primaryStage;
	private Admin admin = null;
	
	/**
	 * Az aktuális példányt beállító praméter nélküli konstruktor.
	 */
	public App() {
		instance = this;
	}
	
	/**
	 * Az osztályon belüli logolást végző osztály.
	 */
	private static Logger logger = LoggerFactory.getLogger(App.class); 
	
	/**
	 * Az alkalmazás aktuális példányát visszaadó metódus.
	 * @return Az alkalmazás aktulális példánya
	 */
	public static App getInstance() {
		return instance;
	}
	
	private void showView(){
		Scene scene = new Scene(view);
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}
	
	/**
	 * Az alkalmazás belépési pontja.
	 * @param args parancssori argumentumok
	 */
	public static void main(String[] args) {

		Initialize.initializeAdmin();
		Initialize.initializeWorker();
		Initialize.initializeCar();
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
	
	/**
	 * Beállítja az alkalmazást használó Admin-t.
	 * @param admin az alkalmazást használó admin
	 */
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	/**
	 * A dolgozó módosítás nézetet betöltő metódus.
	 * @param worker A módosítandó {@link delegacy.model.Worker} objektum
	 */
	public void showModifyWorker(Worker worker) {
		FXMLLoader loader = new FXMLLoader();
		loadView("saveWorker", loader);
		((SaveWorkerController)loader.getController()).setWorker(worker);
		this.showView();
	}
	
	/**
	 * Az autó módosítás nézetet betöltő metódus.
	 * @param car A módosítandó {@link delegacy.model.Car} objektum
	 */
	public void showModifyCar(Car car) {
		FXMLLoader loader = new FXMLLoader();
		loadView("saveCar", loader);
		((SaveCarController)loader.getController()).setCar(car);
		this.showView();
	}
	
	/**
	 * A kiküldetés módosítás nézetet betöltő metódus.
	 * @param delegacy A módosítandó {@link delegacy.model.Delegacy} objektum
	 */
	public void showModifyDelegacy(Delegacy delegacy) {
		FXMLLoader loader = new FXMLLoader();
		loadView("saveDelegacy", loader);
		((SaveDelegacyController)loader.getController()).setDelegacy(delegacy);
		this.showView();
	}
	
	/**
	 * A nézetek váltásáért felelős metódus.
	 * @param viewFile A nézet file
	 */
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
	
	/**
	 * Az alkalmazás bezárását végző metódus.
	 */
	public void closeHandler(){
		ConnectionHandler.closeConnection();
		System.exit(0);
	}
}
