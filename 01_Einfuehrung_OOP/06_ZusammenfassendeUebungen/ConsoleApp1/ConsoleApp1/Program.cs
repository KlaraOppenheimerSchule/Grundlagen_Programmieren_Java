using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp1
{
    class Program
    {
        static void Main(string[] args)
        {
            ConcreteSubject sub = new ConcreteSubject();
            ConcretObserver1 ob1 = new ConcretObserver1();
            sub.Register(ob1);
            //sub.Register(new ConcretObserver2());
            sub.NotifyObservers();
        }
    }
}
