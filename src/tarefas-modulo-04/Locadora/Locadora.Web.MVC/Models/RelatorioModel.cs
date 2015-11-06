using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class RelatorioModel
    {
        public List<JogoModel> Jogos { get; set; }

        public int QuantidadeTotalDeJogos { get; set; }
        public decimal ValorMedio { get; set; }
        public string JogoMaisCaro { get; set; }
        public string JogoMaisBarato { get; set; }

        public RelatorioModel()
        {
            Jogos = new List<JogoModel>();
        }     
    }    
}