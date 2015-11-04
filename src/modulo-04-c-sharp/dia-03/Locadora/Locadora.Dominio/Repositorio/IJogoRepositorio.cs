using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Repositorio
{
    public interface IJogoRepositorio : IRepositorioBase<Jogo>
    {
        IList<Jogo> BuscarPorNome(string nome);
    }
}
