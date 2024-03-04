import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        List<City> cityList = new ArrayList<>();
        try {
            File file = new File("C:\\Users\\Admin\\Desktop\\cities.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] tokens = line.split(",");

                StringBuffer foundation = new StringBuffer();
                for (int i = 5; i < tokens.length; i++) {
                    foundation.append(tokens[i]);
                    if (i < tokens.length - 1) {
                        foundation.append(",");
                    }
                }

                City city = new City(tokens[1], tokens[2], tokens[3], Integer.parseInt(tokens[4]), foundation.toString());
                cityList.add(city);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // Сортировка по наименованию города
        Collections.sort(cityList, City.NameComparator);

        for (City city : cityList) {
            System.out.println(city);
        }

        // Сортировка по федеральному округу и наименованию города
        Collections.sort(cityList, City.DistrictNameComparator);

        for (City city : cityList) {
            System.out.println(city);
        }
    }
}
