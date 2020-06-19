package Animacao;
import javafx.application.Application;

public class LifeCicleJavaFX extends Application{

	@Override
	public void start(Stage primaryStage) {
		Group root = new Group();
		Scene scene = new Scene(root,600,250);
		primarytStage.setTilte("Aplicacao JavaFX");
		primarytStage.setScene(scene);
		primaryStage.show();
	}
					
	public static void main(String[] args) {
		Launch(args);

	}

}
