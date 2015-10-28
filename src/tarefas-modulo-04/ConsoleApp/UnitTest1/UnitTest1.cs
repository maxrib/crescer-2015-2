using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ConsoleApp.Teste
{
    [TestClass]
    public class AgendaTestes
    {
        [TestMethod]
        public void AgendaTemUmContato()
        {
            var agenda = new Agenda();

            var contato = new Contato() { Nome = "Malaquias", Numero = 99999999 };

            agenda.AdicionarContato(contato);

            Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }
    }
}
