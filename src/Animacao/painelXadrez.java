package Animacao;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.control.Button;;

public class painelXadrez extends Application{
	private Stage primaryStage;	

	//acessa o jogo a partir do botao "Jogar"
	private void disparaJogo() {
		System.out.println("botao Jogar");
	}
	
	//fecha o jogo a partir do botao "Sair"
	private void saidaJogo() {
		stop();		
	}
	
	@Override
	public void init() {	
		
	}
		
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		
		//criacao de gerenciador de layout Flowpane :
		FlowPane root = new FlowPane();		
		root.setPadding(new Insets(25,25,25,25));		
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
		
		//criacao de caixas horizontais pra armazenar botoes e texto, respectivamente:
		HBox hbBut = new HBox();
		HBox hbText = new HBox();
		
		//Edicao da caixa horizontal de texto:
		hbText.setAlignment(Pos.TOP_CENTER);
		Text entrada = new Text("Bem Vindo à Chess Battles!");
		entrada.setFont(Font.font("Tahoma",FontWeight.EXTRA_BOLD,35));
		hbText.getChildren().add(entrada);
		root.getChildren().add(hbText);
		
		//Edicao da caixa horizontal de botoes:
		hbBut.setAlignment(Pos.BOTTOM_CENTER);
		hbBut.setSpacing(90);
		
		//botao jogar dispara uma nova cena onde o jogo comeca:
		Button butJogar = new Button("Jogar");
		butJogar.setOnAction(e->disparaJogo());		
		hbBut.getChildren().add(butJogar);
		//botao sair fecha a janela inicial e termina o jogo:
		Button butSair = new Button("Sair");
		butSair.setOnAction(e->saidaJogo());
		hbBut.getChildren().add(butSair);
		//adiciona o hbBut configrado com dois botoes ao gridpane.
		root.getChildren().add(hbBut);
		
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Chess Battles");
		primaryStage.setScene(scene);				
		primaryStage.show();
	}
	
	public void stop() {
		primaryStage.close();
	}

	public static void main(String[] args) {
		launch(args);		
	}

}
