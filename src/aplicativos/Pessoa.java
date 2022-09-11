package aplicativos;

public class Pessoa {
    
    private static String nome;
    private String cpf;

    public Pessoa(String nome) {
        this.nome = nome;
        this.cpf = cpf;

    }
    
    public Pessoa(String nome2, int qtdCadastrados) {
    }

    public static String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

     public String BuscarNomeCpf(){
        if( cpf == cpf){
            return getCpf();
        }
        return cpf;

     }

    }



