package dad.rubenpablo.enviaremail.extra;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class AlertGen {
	
	private Alert alerta;
	
	public AlertGen(AlertType tipo, String cabecera, String contenido) {
		alerta = new Alert(tipo);
		alerta.setHeaderText(cabecera);
		alerta.setContentText(contenido);
	}
	
	public AlertGen(AlertType tipo, String cabecera, String contenido, String icon) {
		alerta = new Alert(tipo);
		alerta.setHeaderText(cabecera);
		alerta.setContentText(contenido);
		Stage escenario = (Stage)alerta.getDialogPane().getScene().getWindow();
		escenario.getIcons().add(new Image(getClass().getResourceAsStream(icon)));
	}
	
	public Alert getAlert() {
		return this.alerta;
	}
	
}
