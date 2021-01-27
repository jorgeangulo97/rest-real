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
