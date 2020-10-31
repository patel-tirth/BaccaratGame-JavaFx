import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import com.sun.javafx.event.EventHandlerManager;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import projectThreeClient.BaccaratInfo;
import projectThreeClient.Client;



//
public class GuiClient extends Application {
	
	
	
	TextField IpAddress; // user entered ip address
	TextField portNum;
	Button play;
	TextField bidAmount2;
	int bidAmount;
	String bidOnPerson;
	ComboBox<String> comboBox;
	HashMap<String, Scene> sceneMap;
	Button proceed = new Button("Proceed");
//	String binOnPerson;
//	String bidAmount;
	
	Client clientConnection;
	ListView<String> listItems, listItems2;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
	
		primaryStage.setTitle("Client side Bacarrat Gamne");
		Pane root=new Pane();	
		root.setPrefSize(800,600);
		
		
		
		this.play = new Button("Play");
		this.play.setStyle("-fx-pref-width: 100px");
		this.play.setStyle("-fx-pref-height: 20px");
		this.play.setLayoutX(500);
		this.play.setLayoutY(60);
		
		this.portNum = new TextField();
		this.portNum.setPromptText("Enter the port number");
		this.portNum.setStyle("-fx-pref-width: 20px");	
		this.portNum.setStyle("-fx-pref-height: 20px");
		this.portNum.setLayoutX(300);
		this.portNum.setLayoutY(60);
		
		this.IpAddress = new TextField();
		this.IpAddress.setPromptText("Enter the ip address");
		this.IpAddress.setStyle("-fx-pref-width: 20px");
		this.IpAddress.setStyle("-fx-pref-height: 20px");
		this.IpAddress.setLayoutX(75);
		this.IpAddress.setLayoutY(60);
		
		
		this.play.setOnAction(e->{
			primaryStage.setScene(sceneMap.get("playScene"));
			primaryStage.setTitle("Baccarat Game");
			
			clientConnection = new Client(data->{
//				info.bidAmount = Integer.parseInt(bidAmount2.getText());
//				info.bidOnPerson = (String) comboBox.getValue();	
				primaryStage.setScene(sceneMap.get("playScene"));
				primaryStage.setTitle("Baccarat Game");
				Platform.runLater(()->{listItems2.getItems().add(data.toString());
								});
				});
			clientConnection.start();
		});
		
		proceed.setOnAction(e->{
			bidAmount = Integer.parseInt(bidAmount2.getText());
			bidOnPerson = (String) comboBox.getValue();	
			 BaccaratInfo info = new BaccaratInfo(bidOnPerson,bidAmount);
			clientConnection.send(info); 
			
		}); 
		
		
		
		root.getChildren().addAll(IpAddress,portNum,play);	
		
	    Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		sceneMap = new HashMap<String, Scene>();
		sceneMap.put("playScene",  createPlaySceneGui());
		
	}
	
	 public Scene createPlaySceneGui() {
		
			
			BorderPane pane = new BorderPane();
			pane.setPadding(new Insets(70));
			pane.setStyle("-fx-background-color: white");
			Label bidAmount = new Label("Enter Bid Amount:");
			 bidAmount2 = new TextField();
			Label bidOn = new Label("Choose whom to bid on: ");
			ObservableList<String> options = 
				    FXCollections.observableArrayList(
				        "Player",
				        "Banker",
				        "Draw"
				    );
			 comboBox = new ComboBox(options);
			
			
		
		
			
			HBox hb = new HBox(bidAmount,bidAmount2,bidOn,comboBox,proceed);
			pane.setBottom(hb);
			
			
			return new Scene(pane, 500, 400);
			
			
		}
	
	
	

}
