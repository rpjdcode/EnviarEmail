package dad.rubenpablo.enviaremail;

import dad.rubenpablo.enviaremail.extra.AlertGen;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertasDefinidas {
	protected static final String RUTA_ICONO = "/imgs/email-send-icon-32x32.png";
    protected static final Alert SVALERT = new AlertGen(
    		AlertType.ERROR,
    		"Parámetros de servidor inválidos",
    		"Debe especificar un servidor y un puerto para establecer la conexión",
    		RUTA_ICONO).getAlert();
    protected static final Alert USRALERT = new AlertGen(
    		AlertType.ERROR,
    		"Inicio de sesión inválido",
    		"Debe especificar un e-mail y una contraseña para iniciar sesión",
    		RUTA_ICONO).getAlert();
    protected static final Alert DESTALERT = new AlertGen(
    		AlertType.ERROR,
    		"Destinatario inválido",
    		"Debe especificar un destinatario",
    		RUTA_ICONO).getAlert();
}
