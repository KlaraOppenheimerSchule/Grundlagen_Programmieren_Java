using System;


class ConcreteSubject : Subject
{
    public override void Register(Observer _observer) {
        this.Register(_observer);
    }
    public override void Unregister(Observer _observer) { 
    }
    public override void NotifyObservers() {
        foreach (Observer obv in this.observers) {
            obv.Update();
        }
    }

  
}
