
using ObserverPatternInCsharp;
using System;

public class Program
{
    public static void Main()
    {
        //subject
        WeatherSubscriber DeutscherWetterdienst = new WeatherSubscriber();
        //observers
        WeatherProvider WebDienst = new WeatherProvider("WebDienst");
        WebDienst.Subscribe(DeutscherWetterdienst);
        WeatherProvider WetterApp = new WeatherProvider("WetterApp");
        WetterApp.Subscribe(DeutscherWetterdienst);
        WeatherProvider Tagesschau = new WeatherProvider("Tagesschau");
        Tagesschau.Subscribe(DeutscherWetterdienst);

        Console.WriteLine("Achtung! Der deutscher Wetterdienst hat neue Wetterdaten:");
        DeutscherWetterdienst.SetMeasurements(new WeatherData(10, 7, 14));
        Console.Read();

        Console.WriteLine("Achtung! Die Tagesschau sucht sich ein anderen Wetterdienst.");
        Tagesschau.Unsubscribe();
        Console.Read();

        Console.WriteLine("Achtung! Der deutscher Wetterdienst hat neue Wetterdaten:");
        DeutscherWetterdienst.SetMeasurements(new WeatherData(28, 26, 14));
        Console.Read();

        Console.WriteLine("Fehler! Der deutscher Wetterdienst hat keine Wetterdaten");
        DeutscherWetterdienst.SetMeasurements(null);
        Console.Read();

    }
}