package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Text;


public class ClickerExampleCode 
{
	
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("Click");
		Button btn = new Button();
		Text txt = new Text(10, 0, "Score");
		
		btn.setOnAction(new EventHandler<ActionEvent>())
		{
			@Override
			public void handle(ActionEvent event)
		}
	}

}
