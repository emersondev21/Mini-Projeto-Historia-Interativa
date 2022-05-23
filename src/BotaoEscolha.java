import javafx.scene.control.Button;

public class BotaoEscolha extends Button {

  private Escolha escolha;

  public BotaoEscolha (Escolha escolha){
    
    super(escolha.getTextoMostrado());
    this.escolha = escolha;
  }  

  public Escolha getEscolha(){
    return this.escolha;
  }
}
