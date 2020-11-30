package dad.javafx.micv.personal;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.javafx.micv.model.Conocimiento;
import dad.javafx.micv.model.Contacto;
import dad.javafx.micv.model.Email;
import dad.javafx.micv.model.Telefono;
import dad.javafx.micv.model.Web;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableView;

public class ContactoController implements Initializable {

	private ObjectProperty<Contacto> contacto = new SimpleObjectProperty<>();
	private ObjectProperty<Telefono> telefono = new SimpleObjectProperty<>();
	private ObjectProperty<Email> email = new SimpleObjectProperty<>();
	private ObjectProperty<Web> web = new SimpleObjectProperty<>();
	
	@FXML
	private SplitPane view;

	@FXML
	private Button nuevoTelefono;

	@FXML
	private Button quitarTelefono;

	@FXML
	private TableView<Telefono> tablaTelefono;

	@FXML
	private Button nuevoEmail;

	@FXML
	private Button quitarEmail;

	@FXML
	private TableView<Email> tablaEmail;

	@FXML
	private Button nuevaURL;

	@FXML
	private Button quitarURL;

	@FXML
	private TableView<Web> tablaURL;

	public ContactoController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ContactoView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	void eliminarEmail(ActionEvent event) {

	}

	@FXML
	void eliminarTelefono(ActionEvent event) {

	}

	@FXML
	void eliminarURL(ActionEvent event) {

	}

	@FXML
	void insertarEmail(ActionEvent event) {

	}

	@FXML
	void insertarTelefono(ActionEvent event) {

	}

	@FXML
	void insertarURL(ActionEvent event) {

	}

	public SplitPane getView() {
		return view;
	}

	public final ObjectProperty<Contacto> contactoProperty() {
		return this.contacto;
	}
	

	public final Contacto getContacto() {
		return this.contactoProperty().get();
	}
	

	public final void setContacto(final Contacto contacto) {
		this.contactoProperty().set(contacto);
	}
	

	public final ObjectProperty<Telefono> telefonoProperty() {
		return this.telefono;
	}
	

	public final Telefono getTelefono() {
		return this.telefonoProperty().get();
	}
	

	public final void setTelefono(final Telefono telefono) {
		this.telefonoProperty().set(telefono);
	}
	

	public final ObjectProperty<Email> emailProperty() {
		return this.email;
	}
	

	public final Email getEmail() {
		return this.emailProperty().get();
	}
	

	public final void setEmail(final Email email) {
		this.emailProperty().set(email);
	}
	

	public final ObjectProperty<Web> webProperty() {
		return this.web;
	}
	

	public final Web getWeb() {
		return this.webProperty().get();
	}
	

	public final void setWeb(final Web web) {
		this.webProperty().set(web);
	}
}
