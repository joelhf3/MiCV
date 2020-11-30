package dad.javafx.micv.personal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.micv.model.Experiencia;
import dad.javafx.micv.model.Titulo;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;

public class ExperienciaController implements Initializable {

	private ObjectProperty<Experiencia> experiencia = new SimpleObjectProperty<>();
	
	@FXML
	private GridPane view;

	@FXML
	private TableView<Experiencia> tablaExperiencia;

	@FXML
	private Button nuevaExperiencia;

	@FXML
	private Button quitarExperiencia;

	public ExperienciaController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ExperienciaView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	void eliminarExperiencia(ActionEvent event) {

	}

	@FXML
	void insertarExperiencia(ActionEvent event) {

	}

	public GridPane getView() {
		return view;
	}

	public final ObjectProperty<Experiencia> experienciaProperty() {
		return this.experiencia;
	}
	

	public final Experiencia getExperiencia() {
		return this.experienciaProperty().get();
	}
	

	public final void setExperiencia(final Experiencia experiencia) {
		this.experienciaProperty().set(experiencia);
	}
}
