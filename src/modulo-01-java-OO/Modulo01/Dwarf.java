public class Dwarf extends Personagem {
    protected DataTerceiraEra dataNascimento;

    public Dwarf() {
        this.vida = 110;
        this.status = Status.VIVO;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
    }

    public Dwarf(String nome) {
        this();
        this.nome = nome;
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento) {
        this(nome);
        this.dataNascimento = dataNascimento;
    }

    public void receberFlechada() {

        double numero = this.gerarNumero();

        if (numero < 0) {
            this.experiencia += 2;
        } else if (numero > 100) {

            int dano = 10;
            double vidaAposFlechada = this.vida-dano;
            if (vidaAposFlechada == 0) {
                this.status = Status.MORTO;
            } 

            if (vida > 0) {
                this.vida = vidaAposFlechada;
            }
        }
    }
    
    public void atacarOrc(Orc orc){
        orc.levarAtaque();
    }

    public DataTerceiraEra getDataNascimento() {
        return this.dataNascimento;
    }

    public double gerarNumero() {
        double resultado = 101.;

        if (dataNascimento.ehBissexto() && this.vida >= 80 && this.vida <= 90) {
            resultado *= -33.0;
        }

        if (!dataNascimento.ehBissexto() &&
        this.nome != null &&
        (this.nome.equals("Seixas") || this.nome.equals("Meireles"))) {
            resultado = resultado * 33 % 100;
        }

        return resultado;
    }
    
    public void tentarSorte() {
        double numero = gerarNumero();
        
        if (numero == -3333.0) {
            this.inventario.aumentar1000UnidadesEmCadaItem();
        }
    }
}