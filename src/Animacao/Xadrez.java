package Animacao;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;

public class Xadrez extends Application{

	@Override
	public void start(Stage primaryStage) {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setGridLinesVisible(true);
		
		Button butJogar = new Button("Jogar");
		grid.add(butJogar,0,0);
		
		
		Button butSair = new Button("Sair");
		grid.add(butSair,0,1);
		
		Scene scene = new Scene(grid,1200,600);
		scene.setFill(Color.AQUAMARINE);
		primaryStage.setTitle("Xadrez 1x1");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);		
	}

}
