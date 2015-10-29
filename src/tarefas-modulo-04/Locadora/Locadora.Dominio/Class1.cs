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

        public static void PesquisarJogos()
        {
            Console.WriteLine("Pesquisando jogos...");
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
