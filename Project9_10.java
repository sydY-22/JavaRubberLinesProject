package project9_10;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Project9_10 extends Application {
	private Line currentLine;
	private Group root;
	private ColorPicker colorpicker;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		root = new Group();
		// set the default Color to Cyan
		colorpicker = new ColorPicker(Color.CYAN);
		// add colorpicker to Group root
		root.getChildren().add(colorpicker);
		
		Scene scene = new Scene(root, 700, 500, Color.BLACK);
		
		scene.setOnMousePressed(this::processMousePress);
		scene.setOnMouseDragged(this::processMouseDrag);
		
		primaryStage.setTitle("Rubber Lines");
		primaryStage.setScene(scene);
		primaryStage.show();
		

	}
	
	public void processMousePress(MouseEvent event) {
		currentLine = new Line(event.getX(), event.getY(), event.getX(), event.getY());
		// set the color that was chosen for the line
		currentLine.setStrokeWidth(3);
		currentLine.setStroke(colorpicker.getValue());
		root.getChildren().add(currentLine);
	}
	
	public void processMouseDrag(MouseEvent event) {
		currentLine.setEndX(event.getX());
		currentLine.setEndY(event.getY());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
