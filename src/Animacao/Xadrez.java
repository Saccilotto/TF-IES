package Animacao;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Xadrez extends Application{

	@Override
	public void start(Stage primaryStage) {
		
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(25,25,25,25));
		//root.setGridLinesVisible(true);
		
		HBox hbBut = new HBox();
		HBox hbText = new HBox();
			
		hbText.setAlignment(Pos.CENTER);
		Text login = new Text("Bem Vindo à Chess Battles!");
		login.setFont(Font.font("Tahoma",FontWeight.EXTRA_BOLD,35));
		hbText.getChildren().add(login);
		root.add(hbText,0,0);

		hbBut.setAlignment(Pos.BOTTOM_CENTER);
		hbBut.setSpacing(100);
		Button butJogar = new Button("Jogar");
		butJogar.autosize();
		hbBut.getChildren().add(butJogar);				
		Button butSair = new Button("Sair");
		hbBut.getChildren().add(butSair);
		root.add(hbBut,0,3);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Chess Battles");
		primaryStage.setScene(scene);						
		primaryStage.show();	
	}

	public static void main(String[] args) {
		launch(args);		
	}

}
