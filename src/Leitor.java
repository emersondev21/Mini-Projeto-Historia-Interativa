import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Leitor 
{

    // Mudei aqui
    public HashMap<String, Personagem> carregarPersonagens(String caminho)
    {
        // Criando 'mapa'/dicionário de itens. neste caso, se chamará 'personagens'.
        HashMap<String, Personagem> personagensMap = new HashMap<String, Personagem>();
        
        //Criação de arquivo de texto. 'rsc/' indica a pasta que o arquivo ficará
        File arquivo = new File(caminho);
        try
        {
            //Criando e configurando o scanner para ler o arquivo 'Personagens.txt'
            Scanner escaneador = new Scanner(arquivo, "UTF-8");
            

            System.out.println("Carregando personagens...");
            // int i = 0;
            
            //Enquanto o arquinvo tiver linha para ler, ele funcionará
            while (escaneador.hasNextLine())
            {
                // i++;  
                
                String id = escaneador.nextLine();// Lendo 'Protagonista' / Antagonista e gravando
                
                String nome = escaneador.nextLine();// Lendo 'Xicrinha' e gravando
                
                int energia = Integer.parseInt(escaneador.nextLine());//Lendo a energia (Convertendo String para int)


                escaneador.nextLine();//Espaço vazio
                // System.out.println("Personagem " + i);


                personagensMap.put(id, new Personagem(nome, energia));
            }
            escaneador.close();
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return personagensMap;
    }
 
    /**
     * Adição dos parâmetros "Controlador controlador" em
     * "carregarcapitulos()"
     * @param escaneador
     */
    public HashMap<String, Capitulo> carregarCapitulos(String caminho, 
                                                       Map<String, Personagem> personagens)
    {
        HashMap<String, Capitulo> capitulos = new HashMap<String, Capitulo>();
        
        File arquivo = new File(caminho);
        try
        {
            Scanner escaneadorDoArquivo = new Scanner(arquivo, "UTF-8");
            
            System.out.println("Carregando capitulos...");
            
            String linha = escaneadorDoArquivo.nextLine();

            while (escaneadorDoArquivo.hasNextLine())
            {
                
                if (linha.equals("CAPITULO") || 
                (linha.equals("CAPITULO_COM_IMAGEM"))){    

                    escaneadorDoArquivo.nextLine();//ID
                    String idCap = escaneadorDoArquivo.nextLine();

                    /**
                     * Adição do controlador nas condicionais
                     * Altera também nos construtores das classes raízes
                     * "Capitulo" e "Capitulo imagem"
                     */

                    if (linha.equals("CAPITULO")){
                        capitulos.put(idCap, new Capitulo(personagens, escaneadorDoArquivo));
                    }
                    else if(linha.equals("CAPITULO_COM_IMAGEM")){
                        capitulos.put(idCap, new CapituloImagem(personagens, escaneadorDoArquivo));
                    }

                    escaneadorDoArquivo.nextLine();
                }
                else if(linha.equals("ESCOLHA")){
                    lerEscolha(capitulos, escaneadorDoArquivo);
                }
                linha = escaneadorDoArquivo.nextLine();
            }
            escaneadorDoArquivo.close();
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
    return capitulos;
    }

        private void lerEscolha(HashMap<String, Capitulo> capitulos, 
                                Scanner escaneadorArquivo) {
        escaneadorArquivo.nextLine();// 'DE'
        String idCapituloDe = escaneadorArquivo.nextLine();
        
        
        escaneadorArquivo.nextLine(); //'PARA'
        String idCapituloPara = escaneadorArquivo.nextLine();
        
        
        escaneadorArquivo.nextLine(); //'TEXTO DIGITADO'
        String textoDigitado = escaneadorArquivo.nextLine();
        
        escaneadorArquivo.nextLine();//'TEXTO MOSTRADO'
        String textoMostrado = escaneadorArquivo.nextLine();
        
        capitulos.get(idCapituloDe).getEscolhas().add(new Escolha(textoDigitado, textoMostrado, capitulos.get(idCapituloPara)));

    }
}