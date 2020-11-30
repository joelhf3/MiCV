package dad.javafx.micv.personal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.micv.model.Personal;
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

public class FormacionController implements Initializable {

	private ObjectProperty<Titulo> titulo = new SimpleObjectProperty<>();
	
	@FXML
    private GridPane view;

    @FXML
    private TableView<Titulo> tablaFormacion;

    @FXML
    private Button nuevaFormacion;

    @FXML
    private Button quitarFormacion;
	
    public FormacionController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/FormacionView.fxml"));
		loader.setController(this);
		loader.load();
	}
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		

	}

	@FXML
    void eliminarFormacion(ActionEvent event) {

    }

    @FXML
    void insertarFormacion(ActionEvent event) {

    }

	public GridPane getView() {
		return view;
	}

	public final ObjectProperty<Titulo> tituloProperty() {
		return this.titulo;
	}
	
	public final Titulo getTitulo() {
		return this.tituloProperty().get();
	}
	

	public final void setTitulo(final Titulo titulo) {
		this.tituloProperty().set(titulo);
	}
}
