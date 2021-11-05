package dad.rubenpablo.enviaremail;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

	private EnviarEmailController controlador;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		controlador = new EnviarEmailController();
		
		Scene escena = new Scene(controlador.getView());
		
		primaryStage.setTitle("Enviar e-mail");
		primaryStage.setScene(escena);
		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/imgs/email-send-icon-32x32.png")));
		primaryStage.show();

	}

	@Override
	public void init() throws Exception{
		System.out.println("Iniciando APP");
	}
	
	@Override
	public void stop() throws Exception{
		System.out.println("Apagando APP");
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
