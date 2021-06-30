using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ObserverPatternInCsharp
{
    public class WeatherData
    {
        private float temperature;
        private float humidity;
        private float presssure;

        public WeatherData(float temp, float hum, float press)
        {
            temperature = temp;
            humidity = hum;
            presssure = press;
        }

        public float Temperature
        {
            get { return this.temperature; }
        }
        public float Humidity
        {
            get { return this.humidity; }
        }
        public float Presssure
        {
            get { return this.presssure; }
        }
    }
}