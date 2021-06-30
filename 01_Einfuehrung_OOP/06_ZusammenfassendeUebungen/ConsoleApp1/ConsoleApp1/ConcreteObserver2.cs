using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class ConcretObserver2 : Observer
    { 
        void Observer.Update()
        {
            Console.WriteLine("ConcretObserver2 Updating...");
        }
    }
}
