/**
 * Representa objetos do tipo Elfo.
 */
public class Elfo extends Personagem {
    private int flechas;

    /* Type initializer
     * Executa antes de cada construtor
    {
    flechas = 42;
    }
     */
    public Elfo(String nome, int flechas) {
        this.nome = nome;
        this.flechas = flechas;
        this.status = Status.VIVO;
        this.vida = 100;
    }

    /* Apenas para elucidar as diferenças entre int X Integer, esta duplicação não faz sentido.
    public Elfo(String nome, Integer flechas) {
    this(nome);
    if (flechas != null) {
    this.flechas = flechas;
    }
    }
     */

    public Elfo(String nome) {
        this(nome, 42);
    }

    /* PascalCase (C#, VB.NET)
     *      public void AtirarFlechaDeFogo
     * camelCase (Java, JavaScript)
     *      public void atirarFlechaDeFogo
     */

    public void atirarFlecha(Dwarf dwarf) {
        flechas--;
        experiencia++;
        dwarf.receberFlechada();
        //experiencia += 1;
        //experiencia = experiencia + 1;
    }

    public void atacarOrc(Orc orc){
        orc.levarAtaque();
    }

    /*
     * ANTES:
     * public atirarFlechaRefactory(this.flechas, this.experiencia){
     *     if(boolean acertar == true){
     *         flechas--;
     *         experiencia++;
     *      }else{
     *          flechas--;
     *      }
     *  }

     *  DEPOIS:

    public void atirarFlechaRefactory(){
    boolean acertar = true;
    if (acertar) {
    experiencia++;
    }
    flechas--;
    }

     */

    public int getFlechas() {
        return this.flechas;
    }

    /* 
    public void setFlechas(int flechas) {
    if (flechas > this.flechas)
    this.flechas = flechas;
    }
     */

    public String toString() {

        boolean flechaNoSingular = Math.abs(this.flechas) == 1;
        boolean nivelNoSingular = Math.abs(this.experiencia) == 1;

        // Ruby ou CoffeeScript:
        //"#{nome} possui #{flechas} #{textoFlechas} e #{experiencia} #{textoNiveis} de experiência."

        // C# 6:
        //"\{nome} possui \{flechas} \{textoFlechas} e \{experiencia} \{textoNiveis} de experiência."

        return String.format("%s possui %d %s e %d %s de experiência.",
            this.nome,
            this.flechas,
            flechaNoSingular ? "flecha" : "flechas",
            this.experiencia,
            nivelNoSingular ? "nível" : "níveis");
    }
}
