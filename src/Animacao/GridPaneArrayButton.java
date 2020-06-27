package Animacao;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class GridPaneArrayButton extends Application  {	
	private Position p;
	
    @Override
    public void start(Stage primaryStage) {

        Image[][] img1 = new Image[9][9];
        Image[][] img2 = new Image[9][9];

        GridPane root = new GridPane();
        root.setPadding(new Insets(5));
        root.setAlignment(Pos.CENTER);

        Label label = new Label("CHESS TABLE 8X8");
        label.setFont(Font.font("Cambria", FontWeight.BOLD, 18));
        GridPane.setColumnSpan(label, 10);
        GridPane.setRowSpan(label, 2);
        root.add(label, 0, 0);
        GridPane.setHalignment(label, HPos.CENTER);

        TextArea text = new TextArea();
        GridPane.setColumnSpan(text, 10);
        GridPane.setRowSpan(text, 2);
        root.setVgap(1);
        root.add(text, 0, 25);
        GridPane.setHalignment(text, HPos.CENTER);
        text.getStyleClass().add("text-area");

        Button[][] btn = new Button[8][8];

        boolean changeColor = false;

        //p = new Position(0,0);
        for (int i = 0; i < btn.length; i++) {
            for (int j = 0; j < btn.length; j++) {
                btn[i][j] = new Button("", new ImageView(img1[i][j]));              
                
                btn[1][j] = new Button("", new ImageView(img1[0][8]));                
                
                btn[6][j] = new Button("", new ImageView(img2[7][8]));               
                
                btn[7][j] = new Button("", new ImageView(img2[i][j]));
                
                if (changeColor == false) {
                    btn[i][j].getStyleClass().add("btn_color_lightgrey");
                } else {
                    btn[i][j].getStyleClass().add("btn_color_grey");
                }
                btn[i][j].setPrefSize(65, 65);
                root.add(btn[i][j], j, i + 2);
                
              	btn[i][j].setOnMouseClicked((MouseEvent e) -> {
                StringBuilder str = new StringBuilder();

                str.append("Position Gridpane X: ").append(e.getX()).append("\n");
                str.append("Position Gridpane Y: ").append(e.getY()).append("\n");

                int x = (int) e.getX();
                int y = (int) e.getY();

                int rx = ((int) e.getX() % 8);
                int ry = ((int) e.getY() % 8);

                int lin = (x - rx) / 8;
                int col = (y - ry) / 8;

                str.append("Line X: ").append(lin).append("\n");
                str.append("Col Y: ").append(convCol(col)).append("\n");
                str.append("Position XY : ").append(new Position(lin, convCol(col))).append("\n");
                str.append("\n-----------------------------------------------------------------------------\n\n");

                text.appendText(str.toString());
              	});                
            changeColor = !changeColor;
            }
        Scene scene = new Scene(root, 900, 900);
        scene.getStylesheets().add(this.getClass().getResource("styles.css").toExternalForm());
        
        primaryStage.setTitle("Grid Pane Example");
        primaryStage.setScene(scene);
        primaryStage.show();  
        }
    }
    
    public static char convCol(int col) {
        switch (col) {
            case 1:
                return 'A';
            case 2:
                return 'B';
            case 3:
                return 'C';
            case 4:
                return 'D';
            case 5:
                return 'E';
            case 6:
                return 'F';
            case 7:
                return 'G';
            case 8:
                return 'H';
            default:
                return ' ';
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}