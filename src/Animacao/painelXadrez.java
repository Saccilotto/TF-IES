package Animacao;

import javafx.application.Application;
import javafx.event.Event;
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

public class painelXadrez extends Application{
	private Stage primaryStage;
	
	//acessa o jogo a partir do botao "Jogar"
	private void disparaJogo(Event e) {
		System.out.println("Acao a ser concluida");
		System.out.println(e.toString());
	}
	
	private void saidaJogo() {
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		//criacao do gerenciador de layout gridpane:
		GridPane root = new GridPane();
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(25,25,25,25));
		//root.setGridLinesVisible(true);
		
		//criacao de caixas horizontais pra armazenar botoes e texto, respectivamente:
		HBox hbBut = new HBox();
		HBox hbText = new HBox();
		
		//Edicao da caixa horizontal de texto:
		hbText.setAlignment(Pos.CENTER);
		Text login = new Text("Bem Vindo à Chess Battles!");
		login.setFont(Font.font("Tahoma",FontWeight.EXTRA_BOLD,35));
		hbText.getChildren().add(login);
		root.add(hbText,0,0);
		
		//Edicao da caixa horizontal de botoes:
		hbBut.setAlignment(Pos.BOTTOM_CENTER);
		hbBut.setSpacing(100);
		
		//botao jogar dispara uma nova cena onde o jogo comeca:
		Button butJogar = new Button("Jogar");
		butJogar.autosize();		
		butJogar.setOnAction(e->disparaJogo(e));
		hbBut.getChildren().add(butJogar);
		//botao sair fecha a janela inicial e termina o jogo:
		Button butSair = new Button("Sair");
		butSair.autosize();
		hbBut.getChildren().add(butSair);
		//adiciona o hbBut configrado com dois botoes ao gridpane.
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
