package dad.rubenpablo.enviaremail;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import dad.rubenpablo.enviaremail.extra.AlertGen;
import dad.rubenpablo.enviaremail.model.EnviarEmailModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EnviarEmailController implements Initializable{
	
	// Model
	private EnviarEmailModel model = new EnviarEmailModel();
	
    @FXML
    private Button clearButton;

    @FXML
    private Button closeButton;

    @FXML
    private VBox controlsVbox;

    @FXML
    private HBox fromHbox;

    @FXML
    private Label fromLabel;

    @FXML
    private TextField fromText;

    @FXML
    private TextArea msgText;

    @FXML
    private PasswordField passField;

    @FXML
    private TextField portText;

    @FXML
    private Button sendButton;

    @FXML
    private TextField serverText;

    @FXML
    private HBox smtpHbox;

    @FXML
    private Label smtpLabel;

    @FXML
    private CheckBox sslCheck;

    @FXML
    private Label sslLabel;

    @FXML
    private HBox subjectHbox;

    @FXML
    private Label subjectLabel;

    @FXML
    private TextField subjectText;

    @FXML
    private HBox toHbox;

    @FXML
    private Label toLabel;

    @FXML
    private TextField toText;

    @FXML
    private GridPane view;
    
    public EnviarEmailController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/EnviarEmail.fxml"));
		loader.setController(this);
		loader.load();
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		bindAll();
	}
    
    @FXML
    void onClearAction(ActionEvent event) {
    	serverText.textProperty().set("");
    	fromText.textProperty().set("");
    	toText.textProperty().set("");
    	sslCheck.setSelected(false);
    	subjectText.textProperty().set("");
    	msgText.textProperty().set("");
    	portText.textProperty().set("");
    	passField.textProperty().set("");
    }

    @FXML
    void onCloseAction(ActionEvent event) {
    	Stage escenario = (Stage)closeButton.getScene().getWindow();
    	escenario.close();
    }

    @FXML
    void onSendAction(ActionEvent event) {
    	if (model.getServer().equals("") || model.getPuerto().equals("")) {
    		AlertasDefinidas.SVALERT.showAndWait();
    	} else if (model.getFrom().equals("") || model.getPass().equals("")) {
    		AlertasDefinidas.USRALERT.showAndWait();
    	} else if (model.getTo().equals("")) {
    		AlertasDefinidas.DESTALERT.showAndWait();
    	} else {
        	Email email = new SimpleEmail();
        	email.setHostName(model.getServer());
        	email.setSmtpPort(Integer.parseInt(model.getPuerto()));
        	email.setAuthenticator(new DefaultAuthenticator(model.getFrom(), model.getPass()));
        	email.setSSLOnConnect(model.isCheck());
        	try {
    			email.setFrom(model.getFrom());
    	    	email.setMsg(model.getMsg());
    	    	email.addTo(model.getTo());
    	    	email.send();
    	    	
    	    	AlertGen exito = new AlertGen(AlertType.INFORMATION, "Mensaje enviado con éxito a '" + model.getTo()+"'.", null, AlertasDefinidas.RUTA_ICONO);
    	    	exito.getAlert().showAndWait();
    	    	
    	    	toText.textProperty().set("");
    	    	subjectText.textProperty().set("");
    	    	msgText.textProperty().set("");
    		} catch (EmailException e) {
    			AlertGen error = new AlertGen(AlertType.ERROR, "No se pudo enviar el e-mail", e.getLocalizedMessage(), AlertasDefinidas.RUTA_ICONO);
    			error.getAlert().showAndWait();
    		}
    	}

    }
    
    private void bindAll() {
		model.serverProperty().bind(serverText.textProperty());
		model.puertoProperty().bind(portText.textProperty());
		model.checkProperty().bind(sslCheck.selectedProperty());
		model.fromProperty().bind(fromText.textProperty());
		model.passProperty().bind(passField.textProperty());
		model.toProperty().bind(toText.textProperty());
		model.subjectProperty().bind(subjectText.textProperty());
		model.msgProperty().bind(msgText.textProperty());
    }
    
    public GridPane getView() {
		return view;
	}



}