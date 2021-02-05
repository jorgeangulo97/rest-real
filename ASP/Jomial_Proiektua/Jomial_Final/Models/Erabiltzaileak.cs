using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Jomial_Final.Models
{
    public class Erabiltzaileak
    {
        public string id { get; set; }
        public string izena { get; set; }
        public string abizena { get; set; }
        public string emaila { get; set; }
        public string erabiltzailea { get; set; }
        public string pasahitza { get; set; }

        public Erabiltzaileak( string izen, string abizen, string email, string erabiltzaile, string pasahitz)
        {
        
            izena = izen;
            abizena = abizen;
            emaila = email;
            erabiltzailea = erabiltzaile;
            pasahitza = pasahitz;
        }
    }

}




