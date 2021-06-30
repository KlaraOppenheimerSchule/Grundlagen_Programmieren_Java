using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class ConcretObserver1 : Observer
    {
        public ConcretObserver1() { }
        void Observer.Update()
        {
            Console.WriteLine("ConcretObserver1 Updating...");
        } 
    }
}
