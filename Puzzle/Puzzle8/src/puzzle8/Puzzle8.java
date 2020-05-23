/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzle8;

import java.io.File;
import javafx.application.Application;
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
public class Puzzle8 extends Application {
    
    public static int getIndexButtonByPosition(Position[] positions, int c, int r){
        for(int i=0; i<positions.length; i++){
            if(positions[i].getC() == c && positions[i].getR() == r)
                return i;
        }
        return -1;
    }
    
    @Override
    public void start(Stage primaryStage){
        
        Button[] buttons = new Button[9];
        Position[] posizioni = new Position[9];
        
        GridPane root = new GridPane();
        root.setStyle("-fx-background: red");
        
        buttons[0] = new Button("");
        buttons[0].setStyle("-fx-color: black");
        buttons[0].setMinSize(150, 150);
        buttons[0].setMaxSize(150, 150);
        root.add(buttons[0],0,1);
        posizioni[0] = new Position(0,1);
        
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
        root.add(buttons[2], 0, 0);
        posizioni[2] = new Position(0,0);
        
        
        buttons[3] = new Button("3");
        buttons[3].setMinSize(150, 150);
        buttons[3].setMaxSize(150, 150);
        buttons[3].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[3], 0, 2);
        posizioni[3] = new Position(0,2);
        
        buttons[4] = new Button("4");
        buttons[4].setMinSize(150, 150);
        buttons[4].setMaxSize(150, 150);
        buttons[4].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[4], 2, 2);
        posizioni[4] = new Position(2,2);
        
        buttons[5] = new Button("5");
        buttons[5].setMinSize(150, 150);
        buttons[5].setMaxSize(150, 150);
        buttons[5].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[5], 1, 2);
        posizioni[5] = new Position(1,2);
        
        buttons[6] = new Button("6");
        buttons[6].setMinSize(150, 150);
        buttons[6].setMaxSize(150, 150);
        buttons[6].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[6], 1, 0);
        posizioni[6] = new Position(1,0);
        
        buttons[7] = new Button("7");
        buttons[7].setMinSize(150, 150);
        buttons[7].setMaxSize(150, 150);
        buttons[7].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[7], 1, 1);
        posizioni[7] = new Position(1,1);
        
        buttons[8] = new Button("8");
        buttons[8].setMinSize(150, 150);
        buttons[8].setMaxSize(150, 150);
        buttons[8].setStyle("-fx-font-size:24px; -fx-font-weight: bold");
        root.add(buttons[8], 2, 1);
        posizioni[8] = new Position(2,1);
        
        Scene scene = new Scene(root, 450, 450);
        
        
        
         EventHandler<KeyEvent> gestoreTastiera = new EventHandler<KeyEvent>() {
            
               public void handle(KeyEvent keyEvent) {
                   int re = posizioni[0].getR();
                   int ce = posizioni[0].getC();
                   System.out.println("Position empty = " + ce + ", " + re);
                   System.out.println("Premuto qualcosa");
                   switch(keyEvent.getCode()){
                        
                       case RIGHT:
                           if(ce == 2 && re == 2){
                                int indexbIn12 = getIndexButtonByPosition(posizioni, 1, 2);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn12]);
                                root.add(buttons[0],1,2);
                                posizioni[0].setAll(1,2);
                                root.add(buttons[indexbIn12], 2, 2);
                                posizioni[indexbIn12].setAll(2,2);
                            
                           }else if(ce == 2 && re == 1){
                                int indexbIn11 = getIndexButtonByPosition(posizioni, 1, 1);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn11]);
                                root.add(buttons[0],1,1);
                                posizioni[0].setAll(1,1);
                                root.add(buttons[indexbIn11], 2, 1);
                                posizioni[indexbIn11].setAll(2,1);
                            }else if(ce == 2 && re == 0){
                                int indexbIn11 = getIndexButtonByPosition(posizioni, 1, 0);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn11]);
                                root.add(buttons[0],1,0);
                                posizioni[0].setAll(1,0);
                                root.add(buttons[indexbIn11], 2, 0);
                                posizioni[indexbIn11].setAll(2,0);
                           
                           
                           }else if(ce == 1 && re == 2){
                                int indexbIn11 = getIndexButtonByPosition(posizioni, 0, 2);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn11]);
                                root.add(buttons[0],0,2);
                                posizioni[0].setAll(0,2);
                                root.add(buttons[indexbIn11], 1, 2);
                                posizioni[indexbIn11].setAll(1,2);
                           
           
                                
                           }else if(ce == 1 && re == 1){
                                int indexbIn01 = getIndexButtonByPosition(posizioni, 0, 1);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn01]);
                                root.add(buttons[0],0,1);
                                posizioni[0].setAll(0,1);
                                root.add(buttons[indexbIn01], 1, 1);
                                posizioni[indexbIn01].setAll(1,1);
                                
                           }else if(ce == 1 && re == 0){
                                int indexbIn11 = getIndexButtonByPosition(posizioni, 0, 0);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn11]);
                                root.add(buttons[0],0,0);
                                posizioni[0].setAll(0,0);
                                root.add(buttons[indexbIn11], 1, 0);
                                posizioni[indexbIn11].setAll(1,0);
                           }
                           break;
                           
                        case LEFT:
                           if(ce == 2 && re == 2){
                               System.out.println("Error!");
                           
                           }else if(ce == 1 && re == 2){
                                int indexbIn22 = getIndexButtonByPosition(posizioni, 2, 2);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn22]);
                                root.add(buttons[0],2,2);
                                posizioni[0].setAll(2,2);
                                root.add(buttons[indexbIn22], 1, 2);
                                posizioni[indexbIn22].setAll(1,2);
                           }else if(ce == 1 && re == 1){
                                int indexbIn22 = getIndexButtonByPosition(posizioni, 2, 1);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn22]);
                                root.add(buttons[0],2,1);
                                posizioni[0].setAll(2,1);
                                root.add(buttons[indexbIn22], 1, 1);
                                posizioni[indexbIn22].setAll(1,1);
                           }else if(ce == 1 && re == 0){
                                int indexbIn22 = getIndexButtonByPosition(posizioni, 2, 0);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn22]);
                                root.add(buttons[0],2,0);
                                posizioni[0].setAll(2,0);
                                root.add(buttons[indexbIn22], 1, 0);
                                posizioni[indexbIn22].setAll(1,0);
                           }else if(ce == 0 && re == 2){
                                int indexbIn22 = getIndexButtonByPosition(posizioni, 1, 2);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn22]);
                                root.add(buttons[0],1,2);
                                posizioni[0].setAll(1,2);
                                root.add(buttons[indexbIn22], 0, 2);
                                posizioni[indexbIn22].setAll(0,2);
                           }else if(ce == 0 && re == 1){
                                int indexbIn22 = getIndexButtonByPosition(posizioni, 1, 1);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn22]);
                                root.add(buttons[0],1,1);
                                posizioni[0].setAll(1,1);
                                root.add(buttons[indexbIn22], 0, 1);
                                posizioni[indexbIn22].setAll(0,1);
                           }else if(ce == 0 && re == 0){
                                int indexbIn22 = getIndexButtonByPosition(posizioni, 1, 0);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn22]);
                                root.add(buttons[0],1,0);
                                posizioni[0].setAll(1,0);
                                root.add(buttons[indexbIn22], 0, 0);
                                posizioni[indexbIn22].setAll(0,0);
                           }
                           
                           break;
                        
                        case UP:
                            if(ce == 2 && re == 2){
                               System.out.println("Error!");
                            }else if(ce == 1 && re == 2){
                                System.out.println("Error!");
                            }else if(ce == 2 && re == 1){
                                int indexbIn11 = getIndexButtonByPosition(posizioni, 2, 2);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn11]);
                                root.add(buttons[0],2,2);
                                posizioni[0].setAll(2,2);
                                root.add(buttons[indexbIn11], 2, 1);
                                posizioni[indexbIn11].setAll(2,1);
                            }else if(ce == 2 && re == 0){
                                int indexbIn11 = getIndexButtonByPosition(posizioni, 2, 1);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn11]);
                                root.add(buttons[0],2,1);
                                posizioni[0].setAll(2,1);
                                root.add(buttons[indexbIn11], 2, 0);
                                posizioni[indexbIn11].setAll(2,0);
                            }else if(ce == 1 && re == 1){
                                int indexbIn11 = getIndexButtonByPosition(posizioni, 1, 2);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn11]);
                                root.add(buttons[0],1,2);
                                posizioni[0].setAll(1,2);
                                root.add(buttons[indexbIn11], 1, 1);
                                posizioni[indexbIn11].setAll(1,1);
                            }else if(ce == 1 && re == 0){
                                int indexbIn11 = getIndexButtonByPosition(posizioni, 1, 1);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn11]);
                                root.add(buttons[0],1,1);
                                posizioni[0].setAll(1,1);
                                root.add(buttons[indexbIn11], 1, 0);
                                posizioni[indexbIn11].setAll(1,0);
                            }else if(ce == 0 && re == 1){
                                int indexbIn11 = getIndexButtonByPosition(posizioni, 0, 2);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn11]);
                                root.add(buttons[0],0,2);
                                posizioni[0].setAll(0,2);
                                root.add(buttons[indexbIn11], 0, 1);
                                posizioni[indexbIn11].setAll(0,1);
                            }else if(ce == 0 && re == 0){
                                int indexbIn11 = getIndexButtonByPosition(posizioni, 0, 1);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn11]);
                                root.add(buttons[0],0,1);
                                posizioni[0].setAll(0,1);
                                root.add(buttons[indexbIn11], 0, 0);
                                posizioni[indexbIn11].setAll(0,0);
                            }
                           break;
                           
                       case DOWN:
                           if(ce == 2 && re == 2){
                                int indexbIn21 = getIndexButtonByPosition(posizioni, 2, 1);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn21]);
                                root.add(buttons[0],2,1);
                                posizioni[0].setAll(2,1);
                                root.add(buttons[indexbIn21], 2, 2);
                                posizioni[indexbIn21].setAll(2,2);
                            
                           }else if(ce == 2 && re == 1){
                                int indexbIn11 = getIndexButtonByPosition(posizioni, 2, 0);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn11]);
                                root.add(buttons[0],2,0);
                                posizioni[0].setAll(2,0);
                                root.add(buttons[indexbIn11], 2, 1);
                                posizioni[indexbIn11].setAll(2,1);
                                
                           }else if(ce == 1 && re == 2){
                                int indexbIn11 = getIndexButtonByPosition(posizioni, 1, 1);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn11]);
                                root.add(buttons[0],1,1);
                                posizioni[0].setAll(1,1);
                                root.add(buttons[indexbIn11], 1, 2);
                                posizioni[indexbIn11].setAll(1,2);
                           
                           }else if(ce == 1 && re == 1){
                                int indexbIn11 = getIndexButtonByPosition(posizioni, 1, 0);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn11]);
                                root.add(buttons[0],1,0);
                                posizioni[0].setAll(1,0);
                                root.add(buttons[indexbIn11], 1, 1);
                                posizioni[indexbIn11].setAll(1,1);
                                
                           }else if(ce == 0 && re == 2){
                                int indexbIn11 = getIndexButtonByPosition(posizioni, 0, 1);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn11]);
                                root.add(buttons[0],0,1);
                                posizioni[0].setAll(0,1);
                                root.add(buttons[indexbIn11], 0, 2);
                                posizioni[indexbIn11].setAll(0,2);
                                
                           }else if(ce == 0 && re == 1){
                                int indexbIn11 = getIndexButtonByPosition(posizioni, 0, 0);
                                root.getChildren().remove(buttons[0]);
                                root.getChildren().remove(buttons[indexbIn11]);
                                root.add(buttons[0],0,0);
                                posizioni[0].setAll(0,0);
                                root.add(buttons[indexbIn11], 0, 1);
                                posizioni[indexbIn11].setAll(0,1);
                           }
                           break;
                        
                        default:
                            System.out.println(keyEvent.getCode());
                   }
               }
               
           };
        root.addEventHandler(KeyEvent.KEY_PRESSED, gestoreTastiera);
        primaryStage.setTitle("Puzzle8");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
