using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class JogoTest
    {
        [TestMethod]
        public void JogoADeveSerIgualJogoB()
        {
            Jogo jogoA = new Jogo(1, "Jogo A", 10, Categoria.RPG, 1);
            Jogo jogoB = new Jogo(1, "Jogo A", 10, Categoria.RPG, 1);

            Assert.AreEqual(jogoA, jogoB);
        }

        [TestMethod]
        public void LocacaoParaClienteTemIdCorreto()
        {
            Jogo jogo = new Jogo();

            jogo.LocarPara(new Cliente(1, "Cliente A"));

            Assert.AreEqual(1, jogo.IdClienteLocacao);
        }
    }
}
