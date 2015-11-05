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
        private IJogoRepositorio jogoRepositorio = new Repositorio.ADO.JogoRepositorio();

        public ActionResult JogosDisponiveis()
        {

            var model = new List<JogoModel>()
            {
                               

            };

            return View(model);
        }
    }
}