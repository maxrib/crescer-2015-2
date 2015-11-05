using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace Locadora.UI
{
    class Program
    {
        public static void Main(string[] args)
        {
            ushort option = 0;
            while (option != 5)
            {
                Console.Clear();
                Console.WriteLine("Locadora Nunes Games");
                Console.WriteLine("====================");
                Console.WriteLine("Selecione uma das Opções:");
                Console.WriteLine("1. Cadastrar um novo Jogo\n2. Pesquisar Jogos\n3. Editar um jogo\n4. Exportar relatório de jogos\n5. Sair");
                option = ushort.Parse(Console.ReadLine());

                switch (option)
                {
                    case 1:
                        Console.Clear();
                        Console.WriteLine("Digite o nome do jogo:");
                        var nome = Console.ReadLine();
                        Console.WriteLine("Digite o preço do jogo: ");
                        var preco = float.Parse(Console.ReadLine());
                        Console.WriteLine("Digite a categoria do jogo: ");
                        var categoria = Console.ReadLine();
                        Dominio.Dominio.CadastrarJogo(nome,preco,categoria);
                        break;
                    case 2:
                        Console.Clear();
                        Console.WriteLine("Digite o nome do jogo:");
                        var nomeBusca = Console.ReadLine();
                        Dominio.Dominio.PesquisarJogos(nomeBusca);
                        Console.ReadLine();
                        break;
                    case 3:
                        Console.Clear();
                        Console.WriteLine("Digite o id do jogo:");
                        int idJogo = int.Parse(Console.ReadLine());
                        Dominio.Dominio.EditarJogo(idJogo);
                        Console.ReadLine();
                        break;
                    case 4:
                        Console.Clear();
                        Dominio.Dominio.ExportarRelatorio();
                        Console.ReadLine();
                        break;
                    case 5:
                        Environment.Exit(1);
                        break;
                    default:
                        Console.Clear();
                        Console.WriteLine("Esta não é uma opção válida. Tente Novamente.");
                        Console.ReadLine();
                        break;
                }
            }
            Console.Read();
        }
    }
}
