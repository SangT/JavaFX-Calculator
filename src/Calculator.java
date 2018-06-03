import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Arrays;


/**
 * Created by Sang To on 12/22/2016.
 */
public class Calculator extends Application {
    Stage window;
    Scene scene;
    Button[] digits;
    Button bdot,badd,bsub,bmult,bdiv,bequal,bclear;
    TextField input;


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        window.setTitle("Calculator");
        bdot = new Button(".");
        badd = new Button("+");
        bsub = new Button("-");
        bmult = new Button("x");
        bdiv = new Button("/");
        bclear = new Button("C");
        bclear.setOnAction( e -> input.clear() );
        bequal = new Button("=");
        bequal.setOnAction( e -> {
            //isDouble(input, input.getText());
            char[] text = input.getText().toCharArray();
            /*
            3+2x4-2/1
             */
            ArrayList<String> equation = new ArrayList<>();
            for (int i = 0; i < text.length; i++) {


            }

        } );

        //number of rows and columns
        int nocol = 4;
        int norow = 5;

        // array of 10 buttons
        digits = new Button[10];
        for (int i = 0; i < 10; i++)
        {
            digits[i] = new Button("" + i);
        }

        // create Gridpane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(15));
        grid.setMinSize(300, 380);
        grid.setGridLinesVisible(false);
        for (int i = 0; i < nocol; i++)
        {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(1.0 / nocol * 100);
            col.setHalignment(HPos.CENTER);
            grid.getColumnConstraints().add(col);
        }

        for (int i = 0; i < norow; i++)
        {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(1.0 / norow * 100);
            row.setValignment(VPos.CENTER);
            grid.getRowConstraints().add(row);
        }

        input = new TextField();

        grid.add(input, 0,0,3,1);
        // add all number buttons to grid
        int c = 0;
        for (int y = nocol; y >= 1; y--)
        {
            for (int x = 0; x <= 2; x++)
            {
                if ( y == nocol && x != 0)
                    continue;
                if (c == digits.length)
                    break;
                grid.add(digits[c++], x, y);
            }
        }

        // add buttons
        grid.add(bdot, 1,4);
        grid.add(bclear, 2,4);
        grid.add(bequal,3,4);
        grid.add(badd,3,3);
        grid.add(bsub,3,2);
        grid.add(bmult,3,1);
        grid.add(bdiv,3,0);

        ArrayList<Button> allButtons = new ArrayList<>(Arrays.asList(digits));
        allButtons.addAll(Arrays.asList(bdot, badd, bsub, bmult, bdiv));
        for (Button i : allButtons) {
            i.setOnAction( e -> {
                input.setText(input.getText().concat(i.getText()));
            } );
        }

        /* VBox layout = new VBox(30);
        layout.setAlignment(Pos.TOP_CENTER);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(result, grid); */

        /*
       {       } C
        7  8  9  /
        4  5  6  x
        1  2  3  -
        0  .  =  +

         */

        scene = new Scene(grid, 350, 400);

        window.setScene(scene);
        window.show();

    }

    /* private boolean isDouble(TextField input, String text) {
        try {
            double number = Double.parseDouble(input.getText());
            return true;

        }catch(NumberFormatException e) {
            System.out.println("Error!");
            return false;
        }
    } */

    public static void main(String[] args)
    {
        launch(args);
    }

}
