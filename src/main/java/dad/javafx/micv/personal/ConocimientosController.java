package dad.javafx.micv.personal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.micv.model.Conocimiento;
import dad.javafx.micv.model.Experiencia;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class ConocimientosController implements Initializable {

	private ObjectProperty<Conocimiento> conocimiento = new SimpleObjectProperty<>();
	
	@FXML
	private GridPane view;

	@FXML
	private TableView<Conocimiento> tablaConocimientos;

	@FXML
	private Button nuevoConocimiento;

	@FXML
	private Button nuevoIdioma;

	@FXML
	private Button quitarConocimiento;

	public ConocimientosController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ConocimientosView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	void eliminarConocimiento(ActionEvent event) {

	}

	@FXML
	void insertarConocimiento(ActionEvent event) {

	}

	@FXML
	void insertarIdioma(ActionEvent event) {

	}

	public GridPane getView() {
		return view;
	}

	public final ObjectProperty<Conocimiento> conocimientoProperty() {
		return this.conocimiento;
	}
	

	public final Conocimiento getConocimiento() {
		return this.conocimientoProperty().get();
	}
	

	public final void setConocimiento(final Conocimiento conocimiento) {
		this.conocimientoProperty().set(conocimiento);
	}
}
