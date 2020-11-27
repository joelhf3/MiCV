package dad.javafx.micv.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Contacto {

	private ObjectProperty<Telefono> telefono = new SimpleObjectProperty<Telefono>(new Telefono());
	private ObjectProperty<Email> email = new SimpleObjectProperty<Email>(new Email());
	private ObjectProperty<Web> web = new SimpleObjectProperty<Web>(new Web());
	
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
