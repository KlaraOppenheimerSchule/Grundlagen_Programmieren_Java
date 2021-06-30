
using ObserverPatternInCsharp;
using System;

public class Program
{
    public static void Main()
    {
        WeatherSubscriber subscriber = new WeatherSubscriber();
        WeatherProvider NDTVProvider = new WeatherProvider("NDTV");
        NDTVProvider.Subscribe(subscriber);
        WeatherProvider TimesProvider = new WeatherProvider("Times");
        TimesProvider.Subscribe(subscriber);
        WeatherProvider HeadLineProvider = new WeatherProvider("HeadLine");
        HeadLineProvider.Subscribe(subscriber);
        subscriber.SetMeasurements(new WeatherData(10, 7, 14));
        HeadLineProvider.Unsubscribe();
        subscriber.SetMeasurements(new WeatherData(28, 26, 14));
        subscriber.SetMeasurements(null);

        Console.Read();

    }
}