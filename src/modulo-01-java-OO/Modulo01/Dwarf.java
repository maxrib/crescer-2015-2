public class Dwarf {
    private String nome;
    private int vida, experiencia;
    private Status status;
    private DataTerceiraEra dataNascimento;
    
    protected String nome;
    protected int vida, experiencia;
    protected Status status;
    protected DataTerceiraEra dataNascimento;
    protected Inventario inventario;

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
    
    public Dwarf(String n, int dia, int mes, int ano) {
        nome = n;
        dataNascimento = new DataTerceiraEra(dia,mes,ano);
    }
    
    public void receberFlechada() {
        
        int dano = 10, vidaAposFlechada = this.vida-dano;
        
        if (vidaAposFlechada == 0) {
            this.status = Status.MORTO;
        } 
        
        if (vida > 0) {
            this.vida = vidaAposFlechada;
        }
    }
    
<<<<<<< HEAD
    public void receberAtaqueDoOrc(Orc orc){
        int danoCausado = orc.getDanoDeAtaque();
        this.vida -= danoCausado;
    }
    
    public void atacarOrc(Orc orc){
        orc.levarAtaqueDeAnao();
    }

=======
>>>>>>> f35c690e738777726243a049a998c692e6f5203d
    public int getVida() {
        return this.vida;
    }
    
    public Status getStatus() {
        return this.status;
    }
    
    public int getExperiencia() {
        return this.experiencia;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public DataTerceiraEra getDataNascimento() {
        return this.dataNascimento;
    }
}