package Animacao;


import java.io.File;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.Arrays;



public class Xadrez extends Application{		
	private Stage primaryStage;
	
	private void setIcons(Stage st) {
		  ObservableList<Image> icons = st.getIcons();
		  
		  final String dir = "icones/";
		  //final String fileInit = "ic";
		  
		  ArrayList<Image> ic = new ArrayList<Image>();					
		  
		  File folder = new File(dir);
		  File[] icones = folder.listFiles();
		  
		  ArrayList<String> paths = new ArrayList<String>();  		  
		  for (File f:icones) {
				String fileName = f.getName();
				//Image imagem = new Image(fileName);	
				//ic.add(imagem);	
				paths.add(fileName);
		  		}
		  
		  // List<String> imageNames
		  List<String> imageNames = Arrays.asList();
		  List<Image> images = imageNames.stream()
		                  .map(s -> dir + s)
		                  .map(s -> getClass().getResourceAsStream(s))
		                  .filter(Objects::nonNull)
		                  .map(Image::new)
		                  .collect(Collectors.toList());
		  icons.addAll(images);
		  
		  
	  st.getIcons().addAll();  
	}
	
    @Override
    public void start(Stage primaryStage) {
    	
    	//metodo de Configuracao do palco
        configura(primaryStage);
	}
    
    
	
	public void configura(Stage primaryStage){
		this.primaryStage = primaryStage;
		//criacao de gerenciador de layout Flowpane :
		FlowPane root = new FlowPane();
		root.setPadding(new Insets(25,25,25,25));		
		root.setAlignment(Pos.CENTER);		
		root.setHgap(10);
		root.setVgap(10);
		root.setStyle("-fx-background-color: aquamarine; -fx-text-fill: aquamarine;");
	
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
		//adiciona o hbBut configrado com dois botoes ao Flowpane.
		root.getChildren().add(hbBut);
					
		Scene scene = new Scene(root);	
		//adiconar icones da janela:		
		//primaryStage.getIcons.addIcons("C:\\Users\\Andre\\Desktop\\TF-IES\\src\\Animacao\\icones","ic"))
		setIcons(primaryStage);
		primaryStage.setTitle("Chess Battles");
		primaryStage.setScene(scene);				
		primaryStage.show();
	}
		
	//acessa o jogo a partir do botao "Jogar"
	private void disparaJogo() {
		telaJogo(primaryStage);
	}
	
	//fecha o jogo a partir do botao "Sair"
		private void saidaJogo() {
			stop();
				
	}
		
	
	//tela do Jogo acionada pelo botao Jogar:
    public void telaJogo(Stage st){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setStyle("-fx-background-color: BURLYWOOD; -fx-text-fill: BURLYWOOD;");
        
        /*
        // Poe o tabuleiro:
        
        
        
        // Poe as pecas no tabuleiro:

        }
        */
        
        // Monta a cena e exibe 

        
        Scene scene = new Scene(grid);
        st.setScene(scene);
        st.show();
     }
    
    @Override
    public void stop() {
    	//salvar jogo(opcional)
    	primaryStage.close();
    }

	public static void main(String[] args) {
		launch(args);		
	}

}
