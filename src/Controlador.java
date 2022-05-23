import java.util.ArrayList;
import java.util.Map;
// import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextArea;

public class Controlador {

    private Capitulo raiz;

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

    @FXML
    void iniciarHistoria(ActionEvent event) {
        Leitor leitor = new Leitor();

            //Carrega o dicionário de personagens
            Map<String, Personagem> personagens = leitor.carregarPersonagens("rsc/Personagens.txt");

            Map<String, Capitulo> capitulos = leitor.carregarCapitulos("rsc/Capitulos.txt", personagens);
            //Carrega o dicionário de capitulos

            raiz = capitulos.get("CupHead do Paraguai");


            mostrarCapitulo(raiz);
            startBTN.setVisible(false);
    }



    private void mostrarCapitulo (Capitulo capitulo){
        
        mostrarTextoCapitulo(capitulo.getTexto());
        mostrarEscolhas(capitulo.getEscolhas());
    }



    public void mostrarEscolhas(ArrayList<Escolha> escolhas){
        escolhasBar.setPadding(new Insets(10));

        for(int i = 0; i < escolhas.size(); i++) {

            escolhasBar.getButtons().add(new Button(escolhas.get(i).getTextoMostrado()));
        
        }
        
    }
}
