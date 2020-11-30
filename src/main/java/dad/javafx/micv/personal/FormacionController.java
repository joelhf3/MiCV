package dad.javafx.micv.personal;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import dad.javafx.micv.App;
import dad.javafx.micv.model.Personal;
import dad.javafx.micv.model.Titulo;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.util.Callback;

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
		Dialog<Titulo> dialogo = new Dialog<>();
		dialogo.setTitle("Nuevo título");
		dialogo.initOwner(App.getPrimaryStage());

		GridPane dialogoGrid = new GridPane();

		Label denominacionLabel = new Label("Denominación");
		Label organizadorLabel = new Label("Organizador");
		Label desdeLabel = new Label("Desde");
		Label hastaLabel = new Label("Hasta");

		TextField denominacionText = new TextField();
		TextField organizadorText = new TextField();

		DatePicker desdeDate = new DatePicker();
		DatePicker hastaDate = new DatePicker();

		ButtonType aceptarButton = new ButtonType("Crear", ButtonData.OK_DONE);

		dialogoGrid.setVgap(5);
		dialogoGrid.setHgap(5);
		dialogoGrid.setPrefWidth(500);
		dialogoGrid.add(denominacionLabel, 0, 0);
		dialogoGrid.add(denominacionText, 1, 0);
		dialogoGrid.add(organizadorLabel, 0, 1);
		dialogoGrid.add(organizadorText, 1, 1);
		dialogoGrid.add(desdeLabel, 0, 2);
		dialogoGrid.add(desdeDate, 1, 2);
		dialogoGrid.add(hastaLabel, 0, 3);
		dialogoGrid.add(hastaDate, 1, 3);
		dialogoGrid.setHgrow(denominacionText, Priority.ALWAYS);
		dialogoGrid.setHgrow(organizadorText, Priority.ALWAYS);

		dialogo.getDialogPane().setContent(dialogoGrid);
		dialogo.getDialogPane().getButtonTypes().addAll(aceptarButton, ButtonType.CANCEL);
		
		dialogo.setResultConverter(respuesta -> {

			if (respuesta == ButtonType.OK) 
			{
				Titulo nuevoTitulo = new Titulo();
				nuevoTitulo.setDenominacion(denominacionText.getText());
				nuevoTitulo.setOrganizador(organizadorText.getText());
				nuevoTitulo.setDesde(desdeDate.getValue());
				nuevoTitulo.setHasta(hastaDate.getValue());

				return nuevoTitulo;
			}

			return null;

		});
		
		dialogo.showAndWait().ifPresent(titulo -> {});;
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
