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
    public class LoginController : Controller
    {
        string Baseurl = "http://192.168.72.4:8080/api/";
        // GET: Login

        [HttpPost]
        public async Task<ActionResult> insertatu(FormCollection collection)
        {
            try
            {

          
            String izena = collection["nombre"];

            String abizena = collection["apellido"];

            String emaila = collection["email"];

            String erabiltzailea = collection["usuario"];
           

            String pasahitza = collection["password1"];
           

            Erabiltzaileak erabil = new Erabiltzaileak(izena, abizena, emaila, erabiltzailea, pasahitza);

            using (var client = new HttpClient())
            {
                //Passing service base url
                client.BaseAddress = new Uri(Baseurl);

                client.DefaultRequestHeaders.Clear();
                //Define request data format
                client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

                var postTask = client.PostAsJsonAsync<Erabiltzaileak>("erabiltzailea/", erabil);
                postTask.Wait();
                var res = postTask.Result;
                var result = postTask.Result;


                return RedirectToAction("IndexLog", "Home", new {erabiltzaile = erabiltzailea });

            }
            }
            catch
            {
                return null;
            }
        }
        public ActionResult Login()
        {
            return View();
        }
        public  async Task<ActionResult> LoginComprobatu(FormCollection collection)
        {
            try
            {


                String usuario = collection["Usuario"];

                String contraseña = collection["password1"];



                using (var client = new HttpClient())
                {
                    client.BaseAddress = new Uri(Baseurl);

                    client.DefaultRequestHeaders.Clear();

                    client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));


                    HttpResponseMessage Res = await client.GetAsync("erabiltzailea/erabiltzailea/pasahitza?erabiltzailea=" + usuario + "&pasahitza=" + contraseña);


                    if (Res.IsSuccessStatusCode)
                    {

                        return RedirectToAction("IndexLog", "Home", new { erabiltzaile = usuario });

                    }
                    else
                    {
                        return RedirectToAction("Login", "Login");
                    }


                }
            }
            catch
            {
                return null;
            }
        }
        public ActionResult Register()
        {
            return View();
        }

        // GET: Login/Details/5
        public ActionResult Details(int id)
        {
            return View();
        }

        // GET: Login/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Login/Create
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

        // GET: Login/Edit/5
        public ActionResult Edit(int id)
        {
            return View();
        }

        // POST: Login/Edit/5
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

        // GET: Login/Delete/5
        public ActionResult Delete(int id)
        {
            return View();
        }

        // POST: Login/Delete/5
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
