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

        public static void EditarJogo()
        {
            Console.WriteLine("Editando jogo...");
        }
        public static void ExportarRelatorio()
        {
            Console.WriteLine("Exportando relatório...");
        }
    }
}
