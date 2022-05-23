import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextArea;

public class Controlador {

    @FXML
    private TextArea asciiCap;

    @FXML
    private ButtonBar escolhasBar;

    @FXML
    private Button startBTN;

    @FXML
    private TextArea textoCap;

    public void mostrarTextoCapitulo(String texto){
        textoCap.setText(texto);
    }
    
    public void mostrarImagemAscii(String imagem){
    asciiCap.setText(imagem);
    }

    public void mostrarEscolhas(ArrayList<Escolha> escolhas){
        escolhasBar.setPadding(new Insets(10));

        for(int i = 0; i < escolhas.size(); i++) {

            escolhasBar.getButtons().add(new Button(escolhas.get(i).getTextoMostrado()));
            // System.out.println();
        }
        
    }
}
