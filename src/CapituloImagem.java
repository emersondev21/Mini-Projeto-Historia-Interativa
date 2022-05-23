import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class CapituloImagem extends Capitulo{

    private String img;

    /**
     * Adição do parâmetro "Controlador controlador"
     */
    
    public CapituloImagem(
        Map<String, Personagem>personagens,
        Scanner escaneadorDoArquivo) {
            super();
            this.lerCapitulo(personagens, escaneadorDoArquivo);
            this.escolhas = new ArrayList<Escolha>();
        }

        protected void lerCapitulo(
            Map<String, Personagem> personagens,
            Scanner escaneadorDoArquivo)

        {
            super.lerCapitulo(personagens, escaneadorDoArquivo);


            escaneadorDoArquivo.nextLine();//IMAGEM
            String linha = escaneadorDoArquivo.nextLine();

            this.img = "";

            while(!linha.equals("IMAGEM_FIM"))
            {
                this.img = img + "\n" + linha;
                linha = escaneadorDoArquivo.nextLine();
            }
        }

    protected void mostrar()
    {
        System.out.println("_______________________________________________________________________________________");
        System.out.println(this.img);
        System.out.println("_______________________________________________________________________________________");
        System.out.println();
        super.mostrar();
    }
}
