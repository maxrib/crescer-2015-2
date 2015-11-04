using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Repositorio
{
    public interface IClienteRepositorio : IRepositorioBase<Cliente>
    {
        IList<Cliente> BuscarPorNome(string nome);
    }
}
