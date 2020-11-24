package dad.javafx.micv.personal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

import dad.javafx.micv.model.Nacionalidad;
import dad.javafx.micv.model.Personal;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PersonalController implements Initializable {

	// model

	private ObjectProperty<Personal> personal = new SimpleObjectProperty<>();

	// view

	@FXML
	private GridPane view;

	@FXML
	private TextField identificacionText;

	@FXML
	private TextField nombreText;

	@FXML
	private TextField apellidosText;
	
	@FXML
    private DatePicker nacimientoDate;

    @FXML
    private TextArea direccionArea;

    @FXML
    private TextField postalText;

    @FXML
    private TextField localidadText;

    @FXML
    private ComboBox<String> paisCombo;

    @FXML
    private ListView<Nacionalidad> nacionalidadListview;

    @FXML
    private Button ponerNacionalidad;

    @FXML
    private Button quitarNacionalidad;
    
    @FXML
    private ChoiceDialog<String> nuevaNacionalidad;

	public PersonalController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/PersonalView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		cargarPaises();
		
		this.personal.addListener((o, ov, nv) -> onPersonalChanged(o, ov, nv));
		
	}

	private void onPersonalChanged(ObservableValue<? extends Personal> o, Personal ov, Personal nv) {
		
		if (ov != null) {
			identificacionText.textProperty().unbindBidirectional(ov.identificacionProperty());
			nombreText.textProperty().unbindBidirectional(ov.nombreProperty());
			apellidosText.textProperty().unbindBidirectional(ov.apellidosProperty());
			nacimientoDate.valueProperty().unbindBidirectional(ov.fechaNacimientoProperty());
			direccionArea.textProperty().unbindBidirectional(ov.direccionProperty());
			postalText.textProperty().unbindBidirectional(ov.codigoPostalProperty());
			localidadText.textProperty().unbindBidirectional(ov.localidadProperty());
			nacionalidadListview.itemsProperty().unbindBidirectional(ov.nacionalidadesProperty());
		}

		if (nv != null) {
			identificacionText.textProperty().bindBidirectional(nv.identificacionProperty());
			nombreText.textProperty().bindBidirectional(nv.nombreProperty());
			apellidosText.textProperty().bindBidirectional(nv.apellidosProperty());
			nacimientoDate.valueProperty().bindBidirectional(nv.fechaNacimientoProperty());
			direccionArea.textProperty().bindBidirectional(nv.direccionProperty());
			postalText.textProperty().bindBidirectional(nv.codigoPostalProperty());
			localidadText.textProperty().bindBidirectional(nv.localidadProperty());
			nacionalidadListview.itemsProperty().bindBidirectional(nv.nacionalidadesProperty());
		}
		
	}
	

	void cargarPaises()
	{
		try 
		{
			Scanner sc = new Scanner(new File("src/main/resources/csv/paises.csv"));
			List<String> paises = new ArrayList<>();
			String [] partes;
			
			while(sc.hasNext())
			{
				partes = sc.nextLine().split(",");
				paises.add(partes[0]);
			}
			
			paisCombo.getItems().add("Seleccione un país");
			paisCombo.getItems().addAll(paises);
			paisCombo.getSelectionModel().selectFirst();
			
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
    @FXML
    void eliminarNacionalidad(ActionEvent event) {

    	nacionalidadListview.getItems().remove(nacionalidadListview.getSelectionModel().getSelectedIndex());
    	
    }

    @FXML
    void insertarNacionalidad(ActionEvent event) 
    {
    	try 
		{
			Scanner sc = new Scanner(new File("src/main/resources/csv/nacionalidades.csv"));
			List<String> nacionalidad = new ArrayList<>();
			String [] partes;
			
			while(sc.hasNext())
			{
				partes = sc.nextLine().split(",");
				nacionalidad.add(partes[0]);
			}
			
			nuevaNacionalidad = new ChoiceDialog<>();
	    	nuevaNacionalidad.setTitle("Nueva nacionalidad");
	    	nuevaNacionalidad.setHeaderText("Añadir nacionalidad");
	    	nuevaNacionalidad.setContentText("Seleccione una nacionalidad");
	    	nuevaNacionalidad.getItems().addAll(nacionalidad);
	    	nuevaNacionalidad.setSelectedItem(nacionalidad.get(0));
	    	nuevaNacionalidad.showAndWait();
	    	
	    	nacionalidadListview.getItems().add(new Nacionalidad(nuevaNacionalidad.getSelectedItem()));
	    	
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println(e.getMessage());
		}
    }
	
	public GridPane getView() {
		return view;
	}

	public final ObjectProperty<Personal> personalProperty() {
		return this.personal;
	}

	public final Personal getPersonal() {
		return this.personalProperty().get();
	}

	public final void setPersonal(final Personal personal) {
		this.personalProperty().set(personal);
	}

}
