using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Jomial_Final.Models
{
    public class Hotel
    {
        public String Id { get; set; }
        public String izena { get; set; }
        public int postaKodea { get; set; }
        public String distantzia { get; set; }
        public String kokalekua { get; set; }
        public String herrialdea { get; set; }
        public String helbidea { get; set; }
        public int izarrak { get; set; }
        public double kalifikazioa { get; set; }
        public List<Argazkia> argazkiak { get; set; }
        public String info { get; set; }
        public String infoGenerala { get; set; }    
        public List<Gelak> gelak { get; set; }
        public List<String> zerbitzuak { get; set; }

    }
}