package main.java.gui;

//import org.w3c.dom.Text;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class Menu {

	private static Menu instance;
	private Scene scene;

	public Menu() {
		// criacao de gerenciador de layout Flowpane :
		FlowPane root = new FlowPane();
		root.setPadding(new Insets(25, 25, 25, 25));
		root.setAlignment(Pos.CENTER);
		root.setHgap(10);
		root.setVgap(10);
		root.setStyle("-fx-background-color: aquamarine; -fx-text-fill: aquamarine;");

		// criacao de caixas horizontais pra armazenar botoes e texto, respectivamente:
		HBox hbBut = new HBox();
		HBox hbText = new HBox();

		// Edicao da caixa horizontal de texto:
		hbText.setAlignment(Pos.TOP_CENTER);
		Text entrada = new Text("Bem Vindo � Chess Battles!");
		entrada.setFont(Font.font("Tahoma", FontWeight.EXTRA_BOLD, 35));
		hbText.getChildren().add(entrada);
		root.getChildren().add(hbText);

		// Edicao da caixa horizontal de botoes:
		hbBut.setAlignment(Pos.BOTTOM_CENTER);
		hbBut.setSpacing(90);

		Jogo jogo = Jogo.getInstance();

		// botao jogar dispara uma nova cena onde o jogo comeca:
		Button butJogar = new Button("Jogar");
		butJogar.setOnAction(e -> JanelaFX.setScene(jogo.getScene()));
		hbBut.getChildren().add(butJogar);

		// botao sair fecha a janela inicial e termina o jogo:
		Button butSair = new Button("Sair");
		butSair.setOnAction(e -> JanelaFX.close());
		hbBut.getChildren().add(butSair);

		// adiciona o hbBut configrado com dois botoes ao Flowpane.
		root.getChildren().add(hbBut);

		this.scene = new Scene(root);
	}

	public Scene getScene() {
		return this.scene;
	}

	public static Menu getInstance() {
		if (instance == null) {
			instance = new Menu();
		}

		return instance;
	}
}
