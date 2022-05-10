public class Personagem {
    private String nome;// Mudei aqui
    private int energia;// Mudei aqui

//==================================================================================================================
//Construtor Personagem
//==================================================================================================================
    
    // Mudei aqui
    public Personagem(String nome, int energia)
    {
        this.nome = nome;
        this.energia = energia;
    }

//==================================================================================================================
//Construtor Personagem
//==================================================================================================================
    
    // Mudei aqui
    public Personagem(String nome)
    {        
        this.nome = nome;
        this.energia = 100;
    }

//==================================================================================================================
//Imprime a energia do personagem se ela for diferente de zero
//==================================================================================================================
    
    // Mudei aqui
    public void ajustarEnergia(int variacao)
    {
        if(variacao != 0)
        {
            setEnergia(this.energia  += variacao);
            System.out.println("Energia de " + this.nome + ": " + this.energia);
        }        
    }

    // Mudei aqui
    private void setEnergia(int energia)
    {
        this.energia = energia;
        if(this.energia < 0)
        {
            this.energia = 0;
        }
    }

//==================================================================================================================
// Criando métodos para usar os atributos, configurados como 'private', em outros lugares
//==================================================================================================================

    String getNome()
    {
        return this.nome;
    }

    int getEnergia()
    {
        return this.energia;
    }
}