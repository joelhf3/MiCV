package dad.javafx.micv;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.google.gson.JsonSyntaxException;

import dad.javafx.micv.model.CV;
import dad.javafx.micv.personal.ConocimientosController;
import dad.javafx.micv.personal.ContactoController;
import dad.javafx.micv.personal.ExperienciaController;
import dad.javafx.micv.personal.FormacionController;
import dad.javafx.micv.personal.PersonalController;
import dad.javafx.micv.utils.JSONUtils;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainController implements Initializable {
	
	// controllers
	
	private PersonalController personalController = new PersonalController();
	private ContactoController contactoController = new ContactoController();
	private FormacionController formacionController = new FormacionController();
	private ExperienciaController experienciaController = new ExperienciaController();
	private ConocimientosController conocimientosController = new ConocimientosController();
	// TODO resto de controladores
	
	// model
	
	private ObjectProperty<CV> cv = new SimpleObjectProperty<>();
	
	// view
	
    @FXML
    private BorderPane view;

    @FXML
    private Tab personalTab;

    @FXML
    private Tab contactoTab;

    @FXML
    private Tab formacionTab;

    @FXML
    private Tab experienciaTab;

    @FXML
    private Tab conocimientosTab;
    
    private Alert alerta;
    
    private File archivo;

	public MainController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		personalTab.setContent(personalController.getView());
		formacionTab.setContent(formacionController.getView());
		experienciaTab.setContent(experienciaController.getView());
		conocimientosTab.setContent(conocimientosController.getView());
		contactoTab.setContent(contactoController.getView());
		
		cv.addListener((o, ov, nv) -> onCVChanged(o, ov, nv));
		
		cv.set(new CV());
	}
	
	private void onCVChanged(ObservableValue<? extends CV> o, CV ov, CV nv) {

		if (ov != null) {
			personalController.personalProperty().unbind();
			formacionController.tituloProperty().unbind();
			experienciaController.experienciaProperty().unbind();
			conocimientosController.conocimientoProperty().unbind();
			contactoController.contactoProperty().unbind();
		}
		
		if (nv != null) {
			personalController.personalProperty().bind(nv.personalProperty());
			formacionController.tituloProperty().bind(nv.tituloProperty());
			experienciaController.experienciaProperty().bind(nv.experienciaProperty());
			conocimientosController.conocimientoProperty().bind(nv.conocimientoProperty());
			contactoController.contactoProperty().bind(nv.contactoProperty());
		}
		
	}

	public BorderPane getView() {
		return view;
	}

    @FXML
    void onAbrirAction(ActionEvent event) {

    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Abrir un currículum");
    	fileChooser.getExtensionFilters().add(new ExtensionFilter("Currículum (*.cv)", "*.cv"));
    	fileChooser.getExtensionFilters().add(new ExtensionFilter("Todos los archivos (*.*)", "*.*"));
    	File cvFile = fileChooser.showOpenDialog(App.getPrimaryStage());
    	if (cvFile != null) {
    		
    		try {
    			cv.set(JSONUtils.fromJson(cvFile, CV.class));
    			App.info("Se ha abierto el fichero " + cvFile.getName() + " correctamente.", "");
    			archivo = cvFile;
			} catch (JsonSyntaxException|IOException e) {
				App.error("Ha ocurrido un error al abrir " + cvFile, e.getMessage());
			}
    		
    	}
    	
    }

    @FXML
    void onAcercaDeAction(ActionEvent event) {

    }

    @FXML
    void onCerrarAction(ActionEvent event) {
    	
    	alerta = new Alert(AlertType.CONFIRMATION);
    	alerta.setHeaderText("¿Seguro que desea salir?");
    	alerta.setContentText("Los cambios no guardados se perderán.");
    	alerta.showAndWait();
    	
    	if(alerta.getResult() == ButtonType.OK)
    	{
    		Stage stage = (Stage) getView().getScene().getWindow();
    	    stage.close();
    	}
    }

    @FXML
    void onGuardarAction(ActionEvent event) 
    {
    	if (archivo != null) 
    	{
    		try 
    		{
    			JSONUtils.toJson(archivo, cv.get());
			} 
    		catch (JsonSyntaxException|IOException e) 
    		{
				App.error("Ha ocurrido un error al guardar " + archivo, e.getMessage());
			}
    	}
    }

    @FXML
    void onGuardarComoAction(ActionEvent event) {

	    FileChooser fileChooser = new FileChooser();
	    fileChooser.setTitle("Guardar un currículum");
	    fileChooser.getExtensionFilters().add(new ExtensionFilter("Currículum (*.cv)", "*.cv"));
	    fileChooser.getExtensionFilters().add(new ExtensionFilter("Todos los archivos (*.*)", "*.*"));
	    File cvFile = fileChooser.showSaveDialog(App.getPrimaryStage());
	    if (cvFile != null) {

	    	try {
	    		JSONUtils.toJson(cvFile, cv.get());
			} catch (JsonSyntaxException|IOException e) {
				App.error("Ha ocurrido un error al guardar " + cvFile, e.getMessage());
			}
	    		
	    }
    }

    @FXML
    void onNuevoAction(ActionEvent event) 
    {
    	cv.set(new CV());
    }
    
}
