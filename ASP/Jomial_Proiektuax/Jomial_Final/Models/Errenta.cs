using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Jomial_Final.Models
{
    public class Errenta
    {    
        public String id { get; set; }
        public String hasiera_data { get; set; }
        public String amaiera_data { get; set; }
        public String hotel_izena { get; set; }
        public int gela { get; set; }
        public double prezio_total { get; set; }
        public String emaila { get; set; }
        public int txartel_zenbakia { get; set; }
        public String txartel_titularra { get; set; }
        public String txartel_iraunginpena { get; set; }
        public int txartel_cvv { get; set; }

        public Errenta( string hasiera_data, string amaiera_data, string hotel_izena, double prezio_total, string erabiltzailea_emaila, int txartel_zenbakia, string txartel_titularra, string txartel_iraunginpena, int txartel_cvv)
        {
            this.id = id;
            this.hasiera_data = hasiera_data;
            this.amaiera_data = amaiera_data;
            this.hotel_izena = hotel_izena;
            this.gela = gela;
            this.prezio_total = prezio_total;
            this.emaila = erabiltzailea_emaila;
            this.txartel_zenbakia = txartel_zenbakia;
            this.txartel_titularra = txartel_titularra;
            this.txartel_iraunginpena = txartel_iraunginpena;
            this.txartel_cvv = txartel_cvv;
        }
    }
}