//**************************************************************************************************************************
// QR Code Generator								Author: Jason Huggy
// 
// This app will generate a randomized QR code each time the app is run. This is a 300 x 300 pixel scene. 
// Each individual square is 12 x 12. Additional personalized symbols can be added in order to associate
// the QR code with a specific brand. 
//
//**************************************************************************************************************************


import java.util.Random;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;


public class Main extends Application {

	public void start(Stage primaryStage) {
    	
    	//***************************************************************************************************
    	// Produces 2 Squares at each corner at the top of the QR Code, with a Black Square in the middle.  
    	// White Border. Bottom left square has to be created separately. 
    	//***************************************************************************************************
    	
    	Paint white = Color.WHITE;
    	Paint black = Color.BLACK; 
    	
    	Pane root = new Pane();
	    for (int x = -12 ; x <= 300 ; x+= 216) {
	            Rectangle square = new Rectangle(x, -12, 108, 108);
	            square.setFill(white);
	            root.getChildren().add(square);
	    }
    	
    	Pane root1 = new Pane();
        for (int x = 0 ; x <= 300 ; x+= 216) {
                Rectangle square = new Rectangle(x, 0, 84, 84);
                square.setFill(black);
                root1.getChildren().add(square);
        }
        
        Pane root2 = new Pane();
        for (int x = 12 ; x <= 300 ; x+= 216) {
                Rectangle square = new Rectangle(x, 12, 60, 60);
                square.setFill(white);
                root2.getChildren().add(square);  
        }
        
        Pane root3 = new Pane();
        for (int x = 24 ; x <= 300 ; x+= 216) {
                Rectangle square = new Rectangle(x, 24, 36, 36);
                square.setFill(black);
                root3.getChildren().add(square);
        }
        
        
        //*************************************************************************************
        // This creates the bottom left square. Personalized branding symbols may also be added
        // at this point. 
        //*************************************************************************************
        
        Rectangle rect1 = new Rectangle(-12, 204, 108, 108);
		rect1.setFill(white); 
		
        Rectangle rect2 = new Rectangle(0, 216, 84, 84);
		rect2.setFill(black); 
		
		Rectangle rect3 = new Rectangle(12, 228, 60, 60);
		rect3.setFill(white); 
		
		Rectangle rect4 = new Rectangle(24, 240, 36, 36);
		rect4.setFill(black);
        
        
        //*************************************************************************************
        // This produces black squares at random spots on the QR Code. These will change
		// each time the code is run. The squares are listed first on the scene, so they will
        // not cover up the main squares. 
        //*************************************************************************************
        
        Pane small = new Pane();
        Paint squareColor = black ;
        
        Random rand = new Random(); //Utilized to randomize each square.
        
        for (int x = 0; x <= 300; x+=12) {
			for (int y = 0; y <= 300; y+=12) {
				int n = rand.nextInt(2);   // Chooses a random number between 0 and 1. 
				if (n == 0){
				squareColor = white;
				} else {
					squareColor = black;
				}
	            Rectangle rec = new Rectangle(x, y , 12, 12);
	            rec.setFill(squareColor);
	            small.getChildren().add(rec);	        
			}
        }
		
		
		Group group = new Group(small, root, root1, root2, root3, rect1, rect2, rect3, rect4);
        Scene scene  = new Scene(group, 300, 300, Color.WHITE);
	
		
		primaryStage.setTitle("QR Code");
		primaryStage.setScene(scene);
		primaryStage.show();
				
	}
	
}
