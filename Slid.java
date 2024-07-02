package M05_assignment3;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class Slid extends Application {

	// Main method to launch
	public static void main(String[] args) {
		launch(args);
	}

	// UI elements
	protected Text text = new Text("Show Colors");
	protected Slider Red = new Slider();
	protected Slider Green = new Slider();
	protected Slider Blue = new Slider();
	protected Slider Opacity = new Slider();

	// Start Method
	public void start(Stage primaryStage) {
		// Creating a stack pane for text
		StackPane paneForText = new StackPane(text);
		paneForText.setPadding(new Insets(20, 10, 5, 10));

		// Setting slider properties
		Red.setMin(0.0);
		Red.setMax(1.0);
		Green.setMin(0.0);
		Green.setMax(1.0);
		Blue.setMin(0.0);
		Blue.setMax(1.0);
		Opacity.setMin(0.0);
		Opacity.setMax(1.0);

		// Create listeners that are calling setColor() method
		Red.valueProperty().addListener(ov -> setColor());
		Green.valueProperty().addListener(ov -> setColor());
		Blue.valueProperty().addListener(ov -> setColor());
		Opacity.valueProperty().addListener(ov -> setColor());
		Opacity.setValue(1);

		// grid pane for labeled sliders
		GridPane paneForSliders = new GridPane();

		// Setting Alignments
		paneForSliders.setAlignment(Pos.CENTER);
		paneForSliders.setVgap(5);
		paneForSliders.setHgap(5);
		paneForSliders.add(new Label("Red"), 0, 0);
		paneForSliders.add(Red, 1, 0);
		paneForSliders.add(new Label("Green"), 0, 1);
		paneForSliders.add(Green, 1, 1);
		paneForSliders.add(new Label("Blue"), 0, 2);
		paneForSliders.add(Blue, 1, 2);
		paneForSliders.add(new Label("Opacity"), 0, 3);
		paneForSliders.add(Opacity, 1, 3);

		// Placing nodes in a border pane
		BorderPane pane = new BorderPane();
		pane.setTop(paneForText);
		pane.setCenter(paneForSliders);

		// Creating a scene and place it in the stage
		Scene scene = new Scene(pane, 250, 150);
		primaryStage.setTitle("Exercise_16_17"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	// Setting up setColor() method to set the color of text
	private void setColor() {
		text.setFill(new Color(Red.getValue(), Green.getValue(), Blue.getValue(), Opacity.getValue()));
	}
}

