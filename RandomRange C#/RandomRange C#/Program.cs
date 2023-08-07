using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Threading.Tasks;

namespace KOira
{
    internal class Program
    {
        static void Main(string[] args)
        {

            while (true)
            {

                Console.WriteLine("Kirjoita Luvusi: ");
                var arvaus = Console.ReadLine();
                var rand = new Random();
                var luku = new decimal(rand.NextDouble());
                Console.WriteLine(luku);

                var etaisyys1 = 1 - luku;
                var etaisyys0 = luku;
                var lahempi = -1;
                if (etaisyys1 < etaisyys0)
                {
                    lahempi = 1;
                }
                else
                {
                    lahempi = 0;
                }
                Console.WriteLine(lahempi);

                if (lahempi == Int32.Parse(arvaus))

                {
                    Console.WriteLine("Voitit!");
                }
                else
                {
                    Console.WriteLine("Hävisit:(");
                }
            }
        }
    }
}
