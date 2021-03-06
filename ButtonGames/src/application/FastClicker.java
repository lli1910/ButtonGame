//Lily Li & Alyssa Ma
//March 23 2018
package application;
 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.text.Font;
import javafx.util.Duration;
import javafx.animation.AnimationTimer;
 
public class FastClicker extends Application 
{
	private static final int startTime = 10;
	private Timeline timeline;
	private int seconds = startTime;
	private Label timerlabel = new Label ();
	
    public static void main(String[] args) {
        extracted(args);
    }
	public int count = 0;
	private long timeStep;
	private boolean scoring;

	private static void extracted(String[] args) {
		launch(args);
	}
    
    @Override
    public void start(Stage primaryStage) 
    {
    	Label newLabel = new Label();
        primaryStage.setTitle("Click-O-Mania");
        Button btn = new Button();
        btn.setText("Click me!");
        btn.setOnAction(new EventHandler<ActionEvent>() {
        
            @Override
            public void handle(ActionEvent event) {
            	if(scoring) {
            		count++;
            	}
            	else
            	{
            		count--;
            	}
                System.out.println(count);
            }
            
        });
        
        timeStep = System.nanoTime() + 1000000000L;
        new AnimationTimer()
        {
        	private Labeled txt;

			public void handle(long now) {
        		if(now > timeStep)
        		{
        			timeStep = now + 1000000000L;
        			scoring = !scoring;
        		}
        		if(!scoring) {
        			btn.setText("Don't Click");
        		}
        		else {
        			btn.setText("Click Me!");
        		}
        		txt.setText("Score:" + Integer.toString(count));
        	}
        }.start();
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}