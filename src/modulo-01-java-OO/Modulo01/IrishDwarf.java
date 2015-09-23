public class IrishDwarf extends Dwarf {

    public IrishDwarf() {
        // vai chamar o super(); implícitamente
    }

    public IrishDwarf(String nome) {
        super(nome);
    }

    public IrishDwarf(String nome, DataTerceiraEra dataNascimento) {
        super(nome, dataNascimento);
    }
    
    @Override
    public void tentarSorte() {
        
        // poderia chamar método da super classe
        //super.tentarSorte();
        
        double numero = gerarNumero();
        
        if (numero == -3333.0) {
            this.inventario.aumentarUnidadesComSomatorio();
        }
    }
}