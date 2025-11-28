package hu.gamf.javalabproject.services;

public class FrequencyBinderService {
    public static String getRange(double f) {
        if (f >= 85.0 && f <= 88.9)  return "85.0–88.9 Mhz";
        if (f >= 89.0 && f <= 92.9)  return "89.0–92.9 Mhz";
        if (f >= 93.0 && f <= 96.9)  return "93.0–96.9 Mhz";
        if (f >= 97.0 && f <= 100.9) return "97.0–100.9 Mhz";
        if (f >= 101.0 && f <= 104.9) return "101.0–104.9 Mhz";
        if (f >= 105.0 && f <= 107.9) return "105.0–107.9 Mhz";
        return "Egyéb";
    }
}
