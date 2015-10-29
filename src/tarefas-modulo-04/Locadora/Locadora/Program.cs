using ClassLibrary1;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora
{
    class Program
    {
        public static void Main(string[] args)
        {
            //Console.SetCursorPosition(10, 3);
            int option = 0;

            while (option != 5)
            {
                Console.WriteLine("Locadora Nunes Games");
                Console.WriteLine("====================");
                Console.WriteLine("Selecione uma das Opções:");
                Console.WriteLine("1. Cadastrar um novo Jogo\n2. Pesquisar Jogos\n3. Editar um jogo\n4. Exportar relatório de jogos\n5. Sair");

                switch (option)
                {
                    case 1:
                        Console.Clear();
                        Console.WriteLine("Digite o nome do jogo:");
                        var nome = Console.ReadLine();
                        Console.WriteLine("Digite o preço do jogo: ");
                        var preco = Console.ReadLine();
                        Console.WriteLine("Digite a categoria do jogo: ");
                        var categoria = Console.ReadLine();
                        Class1.cadastrarJogo(nome,Convert.ToInt32(preco),categoria);
                        break;
                    case 2:
                        Console.Clear();
                        pesquisarJogos();
                        break;
                    case 3:
                        Console.Clear();
                        editarJogo();
                        break;
                    case 4:
                        Console.Clear();
                        exportarRelatorio();
                        break;
                    case 5:
                        System.Environment.Exit(1);
                        break;
                    default:
                        Console.WriteLine("Esta não é uma opção válida. Tente Novamente.");
                        break;
                }
            }

            Console.Read();
        }
    }
}
