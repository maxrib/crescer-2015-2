using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using DbFuncionarios;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

namespace UnitTestProject1
{
    [TestClass]
    public class FuncionarioTest
    {
        [TestMethod]
        public void FuncionariosOrdenadosPorCargo()
        {
            var db = new BaseDeDados();

            IList<Funcionario> funcionariosOrdenadosPorCargo = db.OrdenadosPorCargo();
            string tituloCargoAnalista = "Analista";
            string tituloCargoDesenvolvedor = "Desenvolvedor";
            string tituloCargoGerente = "Gerente";

            int nrAnalistas = funcionariosOrdenadosPorCargo.Count(f => f.Cargo.Titulo.Equals(tituloCargoAnalista));
            int nrDev = funcionariosOrdenadosPorCargo.Count(f => f.Cargo.Titulo.Equals(tituloCargoDesenvolvedor));
            int nrGerentes = funcionariosOrdenadosPorCargo.Count(f => f.Cargo.Titulo.Equals(tituloCargoGerente));
            
            int indiceDev = nrAnalistas;
            int indiceGerente = nrAnalistas + nrDev;

            int totalFunc = nrAnalistas + nrDev + nrGerentes;    

            for (int i = 0; i < totalFunc; i++)
            {
                if(i < indiceDev)
                {
                    Assert.AreEqual(tituloCargoAnalista, funcionariosOrdenadosPorCargo[i].Cargo.Titulo);
                }
                else if(i < indiceGerente)
                {
                    Assert.AreEqual(tituloCargoDesenvolvedor, funcionariosOrdenadosPorCargo[i].Cargo.Titulo);
                }
                else
                {
                    Assert.AreEqual(tituloCargoGerente, funcionariosOrdenadosPorCargo[i].Cargo.Titulo);
                }
            }
            
        }

        [TestMethod]
        public void BuscouFuncionarioPorNome()
        {
            var db = new BaseDeDados();

            IList<Funcionario> funcionarios = db.BuscarPorNome("Pinz");

            Assert.AreEqual(1, funcionarios.Count);
            Assert.AreEqual("Jean Pinzon", funcionarios[0].Nome);
        }

        [TestMethod]
        public void BuscaRapidaRetorna10Resultados()
        {
            var db = new BaseDeDados();
            IList<dynamic> buscaRapida = db.BuscaRapida();

            Assert.AreEqual(11, buscaRapida.Count);
            Assert.AreEqual("Lucas Leal", buscaRapida[0].NomeFuncionario);
            Assert.AreEqual("Desenvolvedor", buscaRapida[0].TituloCargo);
        }

        [TestMethod]
        public void BuscaPorTurnoManhaRetorna5Registros()
        {
            var db = new BaseDeDados();
            IList<Funcionario> funcionariosManha = db.BuscarPorTurno(TurnoTrabalho.Manha);

            Assert.AreEqual(5, funcionariosManha.Count);
        }

        [TestMethod]
        public void BuscaPorTurnoManhaETardeRetorna9Registros()
        {
            var db = new BaseDeDados();
            IList<Funcionario> funcionariosManha = db.BuscarPorTurno(TurnoTrabalho.Manha, TurnoTrabalho.Tarde);

            Assert.AreEqual(9, funcionariosManha.Count);
        }

        [TestMethod]
        public void BuscaQuantidadePorCargo()
        {
            var db = new BaseDeDados();
            IList<dynamic> qtdFuncPorTurno = db.QtdFuncionariosPorTurno();

            Assert.AreEqual(TurnoTrabalho.Manha, qtdFuncPorTurno[0].Turno);
            Assert.AreEqual(5, qtdFuncPorTurno[0].Qtd);

            Assert.AreEqual(TurnoTrabalho.Tarde, qtdFuncPorTurno[1].Turno);
            Assert.AreEqual(4, qtdFuncPorTurno[1].Qtd);

            Assert.AreEqual(TurnoTrabalho.Noite, qtdFuncPorTurno[2].Turno);
            Assert.AreEqual(2, qtdFuncPorTurno[2].Qtd);
        }

        [TestMethod]
        public void BuscarDesenvolvedoresPorCargo()
        {
            var db = new BaseDeDados();
            IList<Funcionario> funcionariosPorCargo = db.BuscarPorCargo(new Cargo("Desenvolvedor", 190));

            Assert.AreEqual(8, funcionariosPorCargo.Count);
        }

        [TestMethod]
        public void BuscarFuncionariosProximosDe30AnosRetorna4Registros()
        {
            var db = new BaseDeDados();
            IList<Funcionario> funcionariosIdadeAprox = db.FiltrarPorIdadeAproximada(30);

            Assert.AreEqual(4, funcionariosIdadeAprox.Count);
        }

        [TestMethod]
        public void SalarioMedioTurnoManhaEh274_1()
        {
            var db = new BaseDeDados();
            double salarioMedioManha = db.SalarioMedio(TurnoTrabalho.Manha);

            Assert.AreEqual(274.1, salarioMedioManha);
        }

        [TestMethod]
        public void SalarioMedioTodosOsFuncionarioEh233_68181818181819()
        {
            var db = new BaseDeDados();
            double salarioMedioManha = db.SalarioMedio();

            Assert.AreEqual(233.68181818181819, salarioMedioManha);
        }

        [TestMethod]
        public void AniversariantesDoMes()
        {
            var db = new BaseDeDados();

            IList<Funcionario> aniversariantes = db.AniversariantesDoMes();
            int mesAtual = DateTime.Now.Month;

            foreach (Funcionario func in aniversariantes)
            {
                Assert.AreEqual(mesAtual, func.DataNascimento.Month);
            }
        }

        [TestMethod]
        public void FuncionarioMaisComplexoEhLeandroAndreolli()
        {
            var db = new BaseDeDados();

            dynamic funcionarioComplex = db.FuncionarioMaisComplexo();
            Assert.AreEqual("Leandro Andreolli", funcionarioComplex.Nome);
            Assert.AreEqual("R$ 190,00", funcionarioComplex.SalarioRS);
            Assert.AreEqual("$190.00", funcionarioComplex.SalarioUS);
        }
    }
}
