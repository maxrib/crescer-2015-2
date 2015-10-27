using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    public class Program
    {
        static void Main(string[] args)
        {
            var agenda = new Agenda();
            var option = "0";
            var nome = "0";
            var telefone = "0";

            while (Convert.ToInt32(option) != 4)
            {
                Console.Clear();

                Console.WriteLine("Olá");

                Console.WriteLine("Selecione uma das Opções:\n");
                Console.WriteLine("1. Adicionar contato\n2. Listar contatos\n3. Listar contatos por Nome\n4. Remover contatos por Nome\n5. Remover contatos por Numero\n6. Sair\n");
                option = Console.ReadLine();

                switch (Convert.ToInt32(option))
                {
                    case 1:
                        Console.Clear();
                        Console.WriteLine("Nome do novo contato: ");
                        nome = Console.ReadLine();
                        Console.WriteLine("Telefone do novo contato: ");
                        telefone = Console.ReadLine();
                        agenda.AdicionarContato(new Contato { Nome = nome, Numero = Convert.ToInt32(telefone) });
                        break;
                    case 2:
                        Console.Clear();
                        agenda.ListarContatos();
                        Console.ReadKey();
                        break;
                    case 3:
                        Console.Clear();
                        agenda.ListarContatosOrdenadosPorNome();
                        Console.ReadKey();
                        break;
                    case 4:
                        Console.Clear();
                        Console.Write("Digite o nome do contato a ser excluído: ");
                        nome = Console.ReadLine();
                        agenda.RemoverContato(nome);
                        break;
                    case 5:
                        Console.Clear();
                        Console.Write("Digite o número do contato a ser excluído: ");
                        telefone = Console.ReadLine();
                        agenda.RemoverContatosPorNumero(Convert.ToInt32(telefone));
                        break;
                    case 6:
                        System.Environment.Exit(1);
                        break;
                    default:
                        Console.WriteLine("Esta não é uma opção válida. Tente Novamente.");
                        break;
                }
            }

            /*
            var contato1 = new Contato()
            {
                Nome= "Fabricio",
	            Numero = 122121212
            };
            var contato2 = new Contato()
            {
                Nome = "Fabricio",
	            Numero = 122121212
            };

            var agenda = new Agenda();
            agenda.AdicionarContato(contato1);
            agenda.AdicionarContato(contato2);
            agenda.RemoverContato("Fabricio");
            */
        }
    }
}
