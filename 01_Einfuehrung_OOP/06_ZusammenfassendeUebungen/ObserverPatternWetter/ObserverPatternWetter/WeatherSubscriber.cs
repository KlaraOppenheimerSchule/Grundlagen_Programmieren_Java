using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ObserverPatternInCsharp
{
    public class WeatherSubscriber : IObservable<WeatherData>
    {
        private List<IObserver<WeatherData>> observers;
        public WeatherSubscriber()
        {
            observers = new List<IObserver<WeatherData>>();
        }

        public IDisposable Subscribe(IObserver<WeatherData> observer)
        {
            if (!observers.Contains(observer))
                observers.Add(observer);
            return new Unsubscriber(observers, observer);
        }

        private class Unsubscriber : IDisposable
        {
            private List<IObserver<WeatherData>> _observers;
            private IObserver<WeatherData> _observer;

            public Unsubscriber(List<IObserver<WeatherData>> observers, IObserver<WeatherData> observer)
            {
                this._observers = observers;
                this._observer = observer;
            }

            public void Dispose()
            {
                if (_observer != null && _observers.Contains(_observer))
                    _observers.Remove(_observer);
            }
        }

        public void SetMeasurements(WeatherData weather)
        {
            foreach (var observer in observers)
            {
                if (weather == null)
                    observer.OnError(new WeatherUnKnnowException());
                else
                    observer.OnNext(weather);
            }
        }

    }
}