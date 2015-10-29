using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;
using System.Xml;
using System.IO;

namespace ClassLibrary1
{
    public class Class1
    {
       public void cadastrarJogo(string nome,int preco, string categoria)
        {
            

            string caminhoArquivo = @"C:\Users\Ale\Google Drive\git\crescer-2015-2\src\tarefas-modulo-04\Locadora\game_store.xml";

            XElement xmlJogos = XElement.Load(caminhoArquivo);

            if (System.IO.File.Exists(caminhoArquivo))
            {
                XDocument file = XDocument.Load(caminhoArquivo);
                XElement nomeAdd = new XElement(nome, playerWin);
                XElement precoAdd = new XElement("playerLoss", playerLoss);
                XElement tieTemp = new XElement("playerTie", playerTie);


                Console.WriteLine("\nYour Record Is:\n");
                Console.WriteLine("Wins:     " + (int)winTemp);
                Console.WriteLine("Losses:   " + (int)lossTemp);
                Console.WriteLine("Ties:     " + (int)tieTemp);
            }
            else
            {
                Console.WriteLine("\nYou don't have any stats to show yet.  Get playing!!!");
            }

            
            
        }

        public static void pesquisarJogos()
        {

        }

        public static void editarJogo()
        {

        }

        public static void exportarRelatorio()
        {

        }
    }
}
