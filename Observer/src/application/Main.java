package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			VBox mivbox = Main.crearContenido();
			Scene scene = new Scene(mivbox,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static VBox crearContenido() {
		VBox vbox = new VBox(15);
		vbox.setAlignment(Pos.CENTER);
		Button boton1 = new Button("Cambiar fondo a azul");
		Button boton2 = new Button("Cambiar fondo a rojo");
		Button boton3 = new Button("Cambiar fondo a amarillo");
		
		boton1.setOnAction((event1)->{
		vbox.setStyle("-fx-background-color: blue;");
		});
		boton2.setOnAction((event1)->{
		vbox.setStyle("-fx-background-color: red;");
		});
		boton3.setOnAction((event1)->{
		vbox.setStyle("-fx-background-color: yellow;");
		});
		vbox.getChildren().addAll(boton1,boton2,boton3);
	
	return vbox;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
