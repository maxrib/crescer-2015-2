using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Repositorio
{
    public interface IRepositorioBase<T>
    {
        T BuscarPorId(int id);
        IList<T> BuscarTodos();
        int Criar(T entidade);
        int Atualizar(T entidade);
        int Excluir(int id);
    }
}
