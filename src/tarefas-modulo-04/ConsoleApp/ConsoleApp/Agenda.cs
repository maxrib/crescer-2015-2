using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    public class Agenda
    {
        private List<Contato> contatos = new List<Contato>();

        public int QuantidadeContatos { get { return contatos.Count; } }

        public void AdicionarContato(Contato contato)
        {
            contatos.Add(contato);
        }

        public void RemoverContato(string nomeContato)
        {

            var indicesASeremRemovidos = new List<int>();
            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Nome == nomeContato)
                {
                    indicesASeremRemovidos.Add(i);
                }
            };
            foreach (var indice in indicesASeremRemovidos)
            {
                contatos.RemoveAt(indice);
            };

            foreach (var contato in contatos)
            {
                if (contato.Nome == nomeContato)
                {
                    contatos.Remove(contato);
                    break;
                }
            }
        }

        public void RemoverContatosPorNumero(int numeroContato ){
            var indicesASeremRemovidos = new List<int>();
            for (int i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Numero == numeroContato)
                {
                    indicesASeremRemovidos.Add(i);
                }
            };
            foreach (var indice in indicesASeremRemovidos)
            {
                contatos.RemoveAt(indice);
            };

            foreach (var contato in contatos)
            {
                if (contato.Numero == numeroContato)
                {
                    contatos.Remove(contato);
                    break;
                }
            }
        }

        public void ListarContatosOrdenadosPorNome()
        {
            contatos.OrderBy(x => x.Nome).ToList();
        }

        public void ListarContatos()
        {
            foreach (var contato in contatos)
            {
                Console.WriteLine(contato.Nome + "-" + contato.Numero);
            }
        }
    }
}
