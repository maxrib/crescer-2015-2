public class IrishDwarf extends Dwarf {

    public IrishDwarf() {
        super();
    }

    public IrishDwarf(String nome) {
        super(nome);
    }

    public IrishDwarf(String nome, DataTerceiraEra dataNascimento) {
        super(nome, dataNascimento);
    }
    
    public void tentarSorte() {
        double numero = gerarNumero();
        
        if (numero == -3333.0) {
            this.inventario.aumentarUnidadesComSomatorio();
        }
    }
}