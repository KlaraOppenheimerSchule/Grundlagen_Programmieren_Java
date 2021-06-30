using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ObserverPatternInCsharp
{
    public class WeatherProvider : IObserver<WeatherData>
    {
        private IDisposable unsubscriber;
        private string instName;

        public WeatherProvider(string name)
        {
            this.instName = name;
        }
        public string Name
        {
            get { return this.instName; }
        }
        public virtual void Subscribe(IObservable<WeatherData> provider)
        {
            if (provider != null)
                unsubscriber = provider.Subscribe(this);
        }
        void IObserver<WeatherData>.OnCompleted()
        {
            Console.WriteLine("The Provider has completed transmitting data to {0}.", this.Name);
            this.Unsubscribe();
        }
        public virtual void Unsubscribe()
        {
            unsubscriber.Dispose();
        }
        void IObserver<WeatherData>.OnError(Exception error)
        {
            Console.WriteLine("{0}: The provider cannot be read data.", this.Name);
        }

        void IObserver<WeatherData>.OnNext(WeatherData value)
        {

            Console.WriteLine("{3}: The current Weather is Temperature: {0}, Pressure {1}, Humidty {2}", value.Temperature, value.Presssure, value.Humidity, this.Name);
        }
    }
}