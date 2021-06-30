using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


abstract class Subject
    {
  
    protected List<Observer> observers;
    public Subject() {
        observers = new List<Observer>();
    }

        public abstract void Register(Observer _observer);
        public abstract void Unregister(Observer _observer);
    public abstract void NotifyObservers();

}
