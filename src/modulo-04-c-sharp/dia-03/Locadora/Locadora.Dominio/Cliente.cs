using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Cliente : EntidadeBase
    {
        public string Nome { get; set; }

        public Cliente(int id, string nome)
        {
            this.Id = id;
            this.Nome = nome;
        }
    }
}
