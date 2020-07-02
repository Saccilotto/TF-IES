package main.java.gui;

import javafx.scene.input.MouseEvent;

public interface MouseController {

	void onMouseReleased(MouseEvent event);

	void onMouseDragged(MouseEvent event);

	void onMousePressed(MouseEvent event);

}
