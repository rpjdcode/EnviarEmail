package dad.rubenpablo.enviaremail.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EnviarEmailModel {
	
	private StringProperty server = new SimpleStringProperty();
	private StringProperty puerto = new SimpleStringProperty();
	private BooleanProperty check = new SimpleBooleanProperty();
	private StringProperty from = new SimpleStringProperty();
	private StringProperty pass = new SimpleStringProperty();
	private StringProperty to = new SimpleStringProperty();
	private StringProperty subject = new SimpleStringProperty();
	private StringProperty msg = new SimpleStringProperty();
	public final StringProperty serverProperty() {
		return this.server;
	}
	
	public final String getServer() {
		return this.serverProperty().get();
	}
	
	public final void setServer(final String server) {
		this.serverProperty().set(server);
	}
	
	public final StringProperty puertoProperty() {
		return this.puerto;
	}
	
	public final String getPuerto() {
		return this.puertoProperty().get();
	}
	
	public final void setPuerto(final String puerto) {
		this.puertoProperty().set(puerto);
	}
	
	public final BooleanProperty checkProperty() {
		return this.check;
	}
	
	public final boolean isCheck() {
		return this.checkProperty().get();
	}
	
	public final void setCheck(final boolean check) {
		this.checkProperty().set(check);
	}
	
	public final StringProperty fromProperty() {
		return this.from;
	}
	
	public final String getFrom() {
		return this.fromProperty().get();
	}
	
	public final void setFrom(final String from) {
		this.fromProperty().set(from);
	}
	
	public final StringProperty passProperty() {
		return this.pass;
	}
	
	public final String getPass() {
		return this.passProperty().get();
	}
	
	public final void setPass(final String pass) {
		this.passProperty().set(pass);
	}
	
	public final StringProperty toProperty() {
		return this.to;
	}
	
	public final String getTo() {
		return this.toProperty().get();
	}
	
	public final void setTo(final String to) {
		this.toProperty().set(to);
	}
	
	public final StringProperty subjectProperty() {
		return this.subject;
	}
	
	public final String getSubject() {
		return this.subjectProperty().get();
	}
	
	public final void setSubject(final String subject) {
		this.subjectProperty().set(subject);
	}
	
	public final StringProperty msgProperty() {
		return this.msg;
	}
	
	public final String getMsg() {
		return this.msgProperty().get();
	}
	
	public final void setMsg(final String msg) {
		this.msgProperty().set(msg);
	}
	
	
	
	
	
}
