using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class Dominio
    {
        private const string caminho = @"C:\Users\Ale\Google Drive\git\crescer-2015-2\src\tarefas-modulo-04\Locadora\game_store.xml";
        private  static readonly XElement locadoraXML = XElement.Load(caminho);

        public static void CadastrarJogo(string nome,float preco, string categoria)
        {
            int ultimoId = Convert.ToInt32(Dominio.locadoraXML.Elements("jogo").Last().Attribute("id").Value);

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

                    Console.SetCursorPosition(3, 10);
                    Console.Write("Novo nome     : ");
                    var novoNome = Console.ReadLine();
                    Console.SetCursorPosition(3, 12);
                    Console.Write("Novo preço    : ");
                    var novoPreco = Console.ReadLine();
                    Console.SetCursorPosition(3, 14);
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
            IEnumerable<XElement> buscaJogo =
                from el in locadoraXML.Elements("jogo")
                select el;

            string reportPath = @"C:\GamesReport.txt";

            var writer = new StreamWriter(reportPath, true);

            writer.WriteLine("                             LOCADORA NUNES GAMES                               ");
            writer.WriteLine("{0:dd/MM/yyyy}                                                              {0:HH:mm:ss}", DateTime.Now);
            writer.WriteLine("                              Relatório de jogos                                \n\n");
            writer.WriteLine("================================================================================");
            writer.WriteLine("ID       Categoria        Nome                          Preço         Disponivel");

            foreach (XElement el in buscaJogo)
            {
                var gameId = el.Attribute("id").Value.ToString();
                var spcCat = string.Join("", Enumerable.Repeat(' ', 9 - gameId.Length));
                var gameCategoria = el.Element("categoria").Value.ToString();
                var spcNome = string.Join("", Enumerable.Repeat(' ', 17 - gameCategoria.Length));
                var gameNome = el.Element("nome").Value.ToString();
                var spcPreco = string.Join("", Enumerable.Repeat(' ', 30 - gameNome.Length));
                var gamePreco = el.Element("preco").Value.ToString();
                var spcDisp = string.Join("", Enumerable.Repeat(' ', 10 - gamePreco.Length));

                writer.WriteLine("{0}{1}{2}{3}{4}{5}R$ {6}{7} Sim", gameId, spcCat, gameCategoria, spcNome, gameNome, spcPreco, gamePreco, spcDisp);
            }

            var qtdJogos = buscaJogo.Count();
            var vlrMedio = buscaJogo.Average(el => float.Parse(el.Element("preco").Value));

            //var maisCaro = buscaJogo.Where(x => x.Element("preco").Value == buscaJogo.Max(b => b.Element("preco").Value)).Elements("jogo");
            //var maisBarato = buscaJogo.Select(el => el.Element("nome")).Min(el => el.Element("preco").Value);

            writer.WriteLine("Quantidade total de jogos: {0}", qtdJogos);
            writer.WriteLine("Quantidade de jogos disponíveis: {0}", qtdJogos);
            //Console.WriteLine("Valor médio por jogo: R$ {0}", vlrMedio);
            //Console.WriteLine("Jogo mais caro: ", maisCaro);
            //Console.WriteLine("Jogo mais barato: ", maisBarato);


            writer.Close();

            Console.Read();

        }
    }
}
