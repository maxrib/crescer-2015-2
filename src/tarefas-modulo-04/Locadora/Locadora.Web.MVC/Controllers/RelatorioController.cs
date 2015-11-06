using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class RelatorioController : Controller
    {
        private IJogoRepositorio repositorio = new Locadora.Repositorio.ADO.JogoRepositorio();
        
        public ActionResult JogosFiltradosPorId(int id)
        {
            return View();
        }

        public ActionResult JogosFiltradosPorNome(string nome)
        {
            return View();
        }

        public ActionResult JogosDisponiveis(string nomeJogo)
        {
            var model = new RelatorioModel();

            foreach (var jogo in repositorio.BuscarTodos())
            {
                var jogoModel = new JogoModel() { Nome = jogo.Nome, Preco = jogo.Preco, Categoria = jogo.Categoria.ToString() };
                model.Jogos.Add(jogoModel);
            }

            model.QuantidadeTotalDeJogos = model.Jogos.Count();

            return View(model);
        }        
    }
}