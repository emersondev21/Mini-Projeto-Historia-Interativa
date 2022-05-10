public class Escolha 
{
    private String textoDigitado;
    private String textoMostrado;
    private Capitulo proximo;

//==================================================================================================================
//Construtor Escolha
//==================================================================================================================

    public Escolha(String textoDigitado, 
            String textoMostrado,
            Capitulo proximo)
    {
        this.textoDigitado = textoDigitado;
        this.textoMostrado = textoMostrado;
        this.proximo = proximo;
    }

//==================================================================================================================
// Criando métodos para usar os atributos, configurados como 'private', em outros lugares
//==================================================================================================================

    public String getTextoDigitado()
    {
        return this.textoDigitado;
    }

    public String getTextoMostrado()
    {
        return this.textoMostrado;
    }

    public Capitulo getProximo()
    {
       return this.proximo;
    }

}