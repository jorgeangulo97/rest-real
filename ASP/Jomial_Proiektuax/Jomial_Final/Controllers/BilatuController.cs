using Jomial_Final.Models;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;
using System.Web;
using System.Web.Mvc;

namespace Jomial_Final.Controllers
{
    public class BilatuController : Controller
    {
        // GET: Bilatu
        string Baseurl = "http://192.168.72.4:8080/api/";
        public ActionResult Index()
        {
            return View();
        }
         [HttpPost]
        public async Task<ActionResult> BusquedaHotel(FormCollection collection)
        {
            String hotelIzena=collection["hotelIzena"];
            ViewData["hotelIzena"] = hotelIzena;

            String hotelDataIn = collection["dataIn"];
            ViewData["dataIn"] = hotelDataIn;

            String hotelDataOut = collection["dataOut"];
            ViewData["dataOut"] = hotelDataOut;

            String huespe = collection["huespe"];
            ViewData["huespe"] = huespe;

            List<Hotel> hotel = new List<Hotel>();

            using (var client = new HttpClient())
            {
                //Passing service base url  
                client.BaseAddress = new Uri(Baseurl);

                client.DefaultRequestHeaders.Clear();
                //Define request data format  
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                //Sending request to find web api REST service resource GetAllEmployees using HttpClient  
                HttpResponseMessage Res = await client.GetAsync("hotels/kokalekua?kokalekua="+ hotelIzena);

                //Checking the response is successful or not which is sent using HttpClient  
                if (Res.IsSuccessStatusCode)
                {
               
                    var EmpResponse = Res.Content.ReadAsStringAsync().Result;

                    hotel = JsonConvert.DeserializeObject<List<Hotel>>(EmpResponse);
   

                }
             
                return View(hotel);
                
            }

        }
        public async Task<ActionResult> Hotel(String id)
        {
            Hotel hotel2 = new Hotel();
            List<Hotel> hotela = new List<Hotel>();

            using (var client = new HttpClient())
            {
                //Passing service base url  
                client.BaseAddress = new Uri(Baseurl);

                client.DefaultRequestHeaders.Clear();
                //Define request data format  
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                //Sending request to find web api REST service resource GetAllEmployees using HttpClient  
                HttpResponseMessage Res = await client.GetAsync("hotel/"+id);

                //Checking the response is successful or not which is sent using HttpClient  
                if (Res.IsSuccessStatusCode)
                {
                    //Storing the response details recieved from web api   
                    var EmpResponse = Res.Content.ReadAsStringAsync().Result;

                    hotel2 = JsonConvert.DeserializeObject<Hotel>(EmpResponse);
                    hotela.Add(hotel2);
                  
                }
                return View(hotela);
            }

        }
        [HttpPost]
        public ActionResult Txartela(FormCollection collection)
        {

            String hotelDataIn = collection["dataIn"];
            ViewData["dataIn"] = hotelDataIn;

            String hotelDataOut = collection["dataOut"];
            ViewData["dataOut"] = hotelDataOut;

            String huespe = collection["huespe"];
            ViewData["huespe"] = huespe;

            String price = collection["price"];
            String[] x = price.Split('-');


            ViewData["hotel_izena"] = x[0];

            ViewData["price"] = x[1];
            return View();

        }

        [HttpPost]
        public async Task<ActionResult> Book(FormCollection collection)
        {
    
        List<Errenta> errenta = new List<Errenta>();

            String hasiera_data = collection["hasiera_data"];
            String amaiera_data = collection["amaiera_data"];
            String hotel_izena = collection["hotel_izena"];
           // double prezioTotala =Double.Parse(collection["prezioTotala"]);

            String erabiltzailea_emaila = collection["erabiltzailea_emaila"];

            int txartel_zenbakia = Int32.Parse(collection["txartel_zenbakia"]);

            String txartel_titularra = collection["txartel_titularra"];

            String txartel_iraunginpena = collection["txartel_iraunginpena"];

            int txartel_cvv = Int32.Parse(collection["txartel_cvv"]);

            Errenta errent = new Errenta(hasiera_data, amaiera_data, hotel_izena, 22.2, erabiltzailea_emaila, txartel_zenbakia, txartel_titularra, txartel_iraunginpena, txartel_cvv);
            
            using (var client = new HttpClient())
            {
                //Passing service base url  
                client.BaseAddress = new Uri(Baseurl);

                client.DefaultRequestHeaders.Clear();
                //Define request data format  
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                var postTask = client.PostAsJsonAsync<Errenta>("errenta/", errent);
                postTask.Wait();
                var res = postTask.Result;
                var result = postTask.Result;
          
                HttpResponseMessage Res = await client.GetAsync("errenta/emaila?emaila=" + erabiltzailea_emaila);
        
    

                if (Res.IsSuccessStatusCode && res.IsSuccessStatusCode)
                {
                      
                    var EmpResponse = Res.Content.ReadAsStringAsync().Result;

                    errenta = JsonConvert.DeserializeObject<List<Errenta>>(EmpResponse);
                    return View(errenta);

                }
                return View();

            }

        }

        // GET: Bilatu/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Bilatu/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Bilatu/Create
        [HttpPost]
        public ActionResult Create(FormCollection collection)
        {
            try
            {
                // TODO: Add insert logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Bilatu/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Bilatu/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add update logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        // GET: Bilatu/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Bilatu/Delete/5
        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
    }
}
