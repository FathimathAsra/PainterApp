
package painterapp;


import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class FXMLDocumentController {
    
    private enum PenSize{
        SMALL(2),
        MEDIUM(4),
        LARGE(6);
        
    private final int radius;
        PenSize(int radius) {this.radius = radius;}
    public int getRadius() {return radius;}
    };
    
    @FXML private Pane drawingAreaPane;
    @FXML private RadioButton blackRadioButton;
    @FXML private ToggleGroup colortogglegroup;
    @FXML private RadioButton blueRadioButton;
    @FXML private RadioButton redRadioButton;
    @FXML private RadioButton greenRadioButton;
    @FXML private Button undoButton;
    @FXML private Button clearButton;
    @FXML private RadioButton smallRadioButton;
    @FXML private ToggleGroup sizetogglegroup;
    @FXML private RadioButton mediumRadioButton;
    @FXML private RadioButton largeRadioButton;


    private PenSize radius = PenSize.MEDIUM;
    private Paint brushColor = Color.BLACK;
    
    public void initialize(){
        blackRadioButton.setUserData(Color.BLACK);
        blueRadioButton.setUserData(Color.BLUE);
        redRadioButton.setUserData(Color.RED);
        greenRadioButton.setUserData(Color.GREEN);
        smallRadioButton.setUserData(PenSize.SMALL);
        mediumRadioButton.setUserData(PenSize.MEDIUM);
        largeRadioButton.setUserData(PenSize.LARGE);   
    }

    
    @FXML void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();

    }

    @FXML void colorRadioButtonSelected(ActionEvent event) {
        brushColor= (Color) colortogglegroup.getSelectedToggle().getUserData();
    }

    @FXML void drawingAreaMouseDragged(MouseEvent e) {
       Circle newCircle = new Circle(e.getX(), e.getY(), radius.getRadius(), brushColor);
        drawingAreaPane.getChildren().add(newCircle);
        
    }

    @FXML void sizeRadioButtonSelected(ActionEvent event ) {
        radius= (PenSize) sizetogglegroup.getSelectedToggle().getUserData();
    }

    @FXML void undoButtonPressed(ActionEvent event) {
        int count = drawingAreaPane.getChildren().size();
        
        if (count > 0){
            drawingAreaPane.getChildren().remove(count - 1);
            
        }

    }

}
