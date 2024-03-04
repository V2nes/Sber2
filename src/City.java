import java.util.Comparator;

public class City {
    private String name;
    private String region;
    private String district;
    private int population;
    private String foundation;

    public City(String name, String region, String district, int population, String foundation) {
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }

    public String toString() {
        return "City{name='" + name + "', region='" + region + "', district='" + district + "', population=" + population + ", foundation='" + foundation + "'}";
    }

    public static Comparator<City> NameComparator = new Comparator<City>() {
        @Override
        public int compare(City city1, City city2) {
            return city2.name.compareToIgnoreCase(city1.name);
        }
    };

    public static Comparator<City> DistrictNameComparator = new Comparator<City>() {
        @Override
        public int compare(City city1, City city2) {
            if (city1.district.equals(city2.district)) {
                return city1.name.compareTo(city2.name);
            } else {
                return city2.district.compareTo(city1.district);
            }
        }
    };

}
