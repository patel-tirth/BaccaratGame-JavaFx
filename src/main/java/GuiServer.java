import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import com.sun.javafx.event.EventHandlerManager;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import projectThreeServer.Server;

public class GuiServer extends Application {
	
	HashMap<String, Scene> sceneMap;
	Button serverOn;
	TextField portNum;
	Server serverConnection;
	String inputPortNum;
	int portNumber;
	ListView<String> listItems, listItems2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		primaryStage.setTitle("Server side Bacarrat Gamne");
		Pane root=new Pane();	
		root.setPrefSize(800,600);
		
		this.serverOn = new Button("Connect to Server");
		this.serverOn.setStyle("-fx-pref-width: 100px");
		this.serverOn.setStyle("-fx-pref-height: 20px");
		this.serverOn.setLayoutX(400);
		this.serverOn.setLayoutY(60);
		
		this.portNum = new TextField();
		this.portNum.setPromptText("Enter the port number");
		this.portNum.setStyle("-fx-pref-width: 20px");	
		this.portNum.setStyle("-fx-pref-height: 20px");
		this.portNum.setLayoutX(200);
		this.portNum.setLayoutY(60);
		
				
		this.serverOn.setOnAction(e-> {
			primaryStage.setScene(sceneMap.get("server"));
			primaryStage.setTitle("Game Information");
			inputPortNum = this.portNum.getText();
			portNumber = Integer.parseInt(inputPortNum);

			serverConnection = new Server(data -> {
				Platform.runLater(()->{
					listItems.getItems().add(data.toString());
				});

			},portNumber);
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Text title = new Text();

		title.setText("Bacarrat game server side");
		title.setTranslateX(325);
		title.setTranslateY(50);
		root.getChildren().addAll(title,serverOn,portNum);	
		Scene scene = new Scene(root);
		
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		sceneMap = new HashMap<String, Scene>();
		sceneMap.put("server",  createServerGui());

	
		listItems = new ListView<String>();
		listItems2 = new ListView<String>();
			
   }

	
         public Scene createServerGui() {
		
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(70));
		pane.setStyle("-fx-background-color: white");
		
		pane.setCenter(listItems);
	
		return new Scene(pane, 500, 400);
		
		
	}


}
