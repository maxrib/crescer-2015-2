using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class Dominio
    {
        private const string caminho = @"C:\Users\Ale\Google Drive\git\crescer-2015-2\src\tarefas-modulo-04\Locadora\game_store.xml";

        public static void CadastrarJogo(string nome,float preco, string categoria)
        {
            XElement locadoraXML = XElement.Load(caminho);
            
            int ultimoId = Convert.ToInt32(locadoraXML.Elements("jogo").Last().Attribute("id").Value);

            XElement cadastro = new XElement("jogo",
                new XElement("nome", nome),
                new XElement("preco", preco),
                new XElement("categoria", categoria));

            cadastro.SetAttributeValue("id", ultimoId + 1);

            locadoraXML.Add(cadastro);

            locadoraXML.Save(caminho);
        }

        public static void PesquisarJogos(string nomeJogo)
        {
            XElement locadoraXML = XElement.Load(caminho);

            IEnumerable<XElement> buscaJogo =
                from el in locadoraXML.Elements("jogo")
                where ((string)el.Element("nome")).ToUpper().Contains(nomeJogo.ToUpper())
                select el;

            if (buscaJogo.Count() >= 1 && nomeJogo != "")
            {
                foreach (XElement el in buscaJogo)
                {
                    XElement jogo = el.Element("nome");
                    Console.WriteLine(string.Format("{0} - {1}\n", jogo.Value, el.Attribute("id")));
                }
            }
            else
            {
                Console.WriteLine("Jogo não encontrado!");
            }
        }

        public static void EditarJogo(int idJogo)
        {
            XElement locadoraXML = XElement.Load(caminho);

            IEnumerable<XElement> buscaJogo =
                from el in locadoraXML.Elements("jogo")
                where (int)el.Attribute("id") == idJogo
                select el;

            if (buscaJogo.Count() >= 1)
            {
                foreach (XElement el in buscaJogo)
                {
                    Console.SetCursorPosition(3, 3);
                    Console.WriteLine("Nome     : "+ el.Element("nome").Value);
                    Console.SetCursorPosition(3, 5);
                    Console.WriteLine("Preço    : " + el.Element("preco").Value);
                    Console.SetCursorPosition(3, 7);
                    Console.WriteLine("Categoria: " + el.Element("categoria").Value);

                    Console.SetCursorPosition(40, 3);
                    Console.Write("Novo nome     : ");
                    var novoNome = Console.ReadLine();
                    Console.SetCursorPosition(40, 5);
                    Console.Write("Novo preço    : ");
                    var novoPreco = Console.ReadLine();
                    Console.SetCursorPosition(40, 7);
                    Console.Write("Nova categoria: ");
                    var novaCategoria = Console.ReadLine();

                    el.Element("nome").Value = novoNome;
                    el.Element("preco").Value = novoPreco;
                    el.Element("categoria").Value = novaCategoria;

                    locadoraXML.Save(caminho);
                }
            }
            else
            {
                Console.Write("ID não existe!");
            }
        }

        public static void ExportarRelatorio()
        {
            Console.WriteLine("Exportando relatório...");
        }
    }
}
