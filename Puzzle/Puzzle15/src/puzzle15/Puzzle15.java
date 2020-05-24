/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle15;

import java.io.File;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author gabriele
 */
public class Puzzle15 extends Application {
    
    public static int getIndexButtonByPosition(Position[] positions, int c, int r){
        for(int i=0; i<positions.length; i++){
            if(positions[i].getC() == c && positions[i].getR() == r)
                return i;
        }
        return -1;
    }
    
    @Override
    public void start(Stage primaryStage){
        
        Button[] buttons = new Button[16];
        Position[] posizioni = new Position[16];
        
        GridPane root = new GridPane();
        root.setStyle("-fx-background: red");
        
        buttons[0] = new Button("");
        buttons[0].setStyle("-fx-color: black");
        buttons[0].setMinSize(150, 150);
        buttons[0].setMaxSize(150, 150);
        root.add(buttons[0],3,3);
        posizioni[0] = new Position(3,3);
        
        buttons[1] = new Button("1");
        buttons[1].setMinSize(150, 150);
        buttons[1].setMaxSize(150, 150);
        buttons[1].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[1], 2, 0);
        posizioni[1] = new Position(2,0);
        
        buttons[2] = new Button("2");
        buttons[2].setMinSize(150, 150);
        buttons[2].setMaxSize(150, 150);
        buttons[2].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[2], 1, 0);
        posizioni[2] = new Position(1, 0);
        
        
        buttons[3] = new Button("3");
        buttons[3].setMinSize(150, 150);
        buttons[3].setMaxSize(150, 150);
        buttons[3].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[3], 0, 3);
        posizioni[3] = new Position(0,  3);
        
        buttons[4] = new Button("4");
        buttons[4].setMinSize(150, 150);
        buttons[4].setMaxSize(150, 150);
        buttons[4].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[4], 0, 2);
        posizioni[4] = new Position(0, 2);
        
        buttons[5] = new Button("5");
        buttons[5].setMinSize(150, 150);
        buttons[5].setMaxSize(150, 150);
        buttons[5].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[5], 1, 1);
        posizioni[5] = new Position(1, 1);
        
        buttons[6] = new Button("6");
        buttons[6].setMinSize(150, 150);
        buttons[6].setMaxSize(150, 150);
        buttons[6].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[6], 2, 1);
        posizioni[6] = new Position(2,1);
        
        buttons[7] = new Button("7");
        buttons[7].setMinSize(150, 150);
        buttons[7].setMaxSize(150, 150);
        buttons[7].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[7], 3, 2);
        posizioni[7] = new Position(3,2);
        
        buttons[8] = new Button("8");
        buttons[8].setMinSize(150, 150);
        buttons[8].setMaxSize(150, 150);
        buttons[8].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[8], 0, 1);
        posizioni[8] = new Position(0, 1);
        
        buttons[9] = new Button("9");
        buttons[9].setMinSize(150, 150);
        buttons[9].setMaxSize(150, 150);
        buttons[9].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[9], 1, 2);
        posizioni[9] = new Position(1,2);
        
        
        buttons[10] = new Button("10");
        buttons[10].setMinSize(150, 150);
        buttons[10].setMaxSize(150, 150);
        buttons[10].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[10], 2, 2);
        posizioni[10] = new Position(2,2);
        
        buttons[11] = new Button("11");
        buttons[11].setMinSize(150, 150);
        buttons[11].setMaxSize(150, 150);
        buttons[11].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[11], 3, 1);
        posizioni[11] = new Position(3,1);
        
        buttons[12] = new Button("12");
        buttons[12].setMinSize(150, 150);
        buttons[12].setMaxSize(150, 150);
        buttons[12].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[12], 3, 0);
        posizioni[12] = new Position(3,0);
        
        buttons[13] = new Button("13");
        buttons[13].setMinSize(150, 150);
        buttons[13].setMaxSize(150, 150);
        buttons[13].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[13], 1, 3);
        posizioni[13] = new Position(1,3);
        
        buttons[14] = new Button("14");
        buttons[14].setMinSize(150, 150);
        buttons[14].setMaxSize(150, 150);
        buttons[14].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[14], 2, 3);
        posizioni[14] = new Position(2,3);
        
        buttons[15] = new Button("15");
        buttons[15].setMinSize(150, 150);
        buttons[15].setMaxSize(150, 150);
        buttons[15].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[15], 0, 0);
        posizioni[15] = new Position(0,0);
        
        Scene scene = new Scene(root, 600, 600);
        
        
         EventHandler<KeyEvent> gestoreTastiera = new EventHandler<KeyEvent>() {
            
               public void handle(KeyEvent keyEvent) {
                   int re = posizioni[0].getR();
                   int ce = posizioni[0].getC();
                   System.out.println("Position empty = " + ce + ", " + re);
                   System.out.println("Premuto qualcosa");
                   switch(keyEvent.getCode()){
                        
                       case RIGHT:
                           if(ce>0){
                                int indexT = getIndexButtonByPosition(posizioni, ce-1, re);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexT]);
                                root.add(buttons[0],ce-1,re);
                                posizioni[0].setAll(ce-1,re);
                                root.add(buttons[indexT], ce, re);
                                posizioni[indexT].setAll(ce,re);
                           }
                            
                           break;
                           
                        case LEFT:
                           if(ce<3){
                                int indexT = getIndexButtonByPosition(posizioni, ce+1, re);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexT]);
                                root.add(buttons[0],ce+1,re);
                                posizioni[0].setAll(ce+1,re);
                                root.add(buttons[indexT], ce, re);
                                posizioni[indexT].setAll(ce,re);
                           }
                           
                           break;
                        
                        case UP:
                            if(re<3){
                                int indexT = getIndexButtonByPosition(posizioni, ce, re+1);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexT]);
                                root.add(buttons[0],ce,re+1);
                                posizioni[0].setAll(ce,re+1);
                                root.add(buttons[indexT], ce, re);
                                posizioni[indexT].setAll(ce,re);
                           }
                           break;
                           
                       case DOWN:
                          if(re>0){
                                int indexT = getIndexButtonByPosition(posizioni, ce, re-1);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexT]);
                                root.add(buttons[0],ce,re-1);
                                posizioni[0].setAll(ce,re-1);
                                root.add(buttons[indexT], ce, re);
                                posizioni[indexT].setAll(ce,re);
                           }
                           break;
                        
                        default:
                            System.out.println(keyEvent.getCode());
                   }
               }
               
           };
        root.addEventHandler(KeyEvent.KEY_PRESSED, gestoreTastiera);
        primaryStage.setTitle("Puzzle15");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
