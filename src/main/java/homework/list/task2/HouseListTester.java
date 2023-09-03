package homework.list.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HouseListTester {
    public static void main(String[] args) {
        List<House> houses = new ArrayList<>(50);
        for (int i = 0; i < 50; i++) {
            houses.add(HouseUtils.randomHouseGenerator(i));
        }
        HouseUtils.printAllHouses(houses);
        System.out.println("*************************");
        HouseUtils.printAllPlaceNameHouses(houses, "Fairview");
        System.out.println("*************************");
        HouseUtils.printMinAreaHouses(houses, 550);
        System.out.println("*************************");
        HouseUtils.printMinFloorsHouses(houses, 2);
        System.out.println("*************************");
        HouseUtils.printWallMaterialHouses(houses, "Wood");
        System.out.println("*************************");
        HouseUtils.printFoundationHouses(houses, "Basement");
        System.out.println("*************************");
        HouseUtils.printCommsHouses(houses, "Electricity");
        System.out.println("*************************");
        Collections.shuffle(houses);
        Collections.sort(houses);
        HouseUtils.printAllHouses(houses);
        System.out.println("*************************");
        Collections.shuffle(houses);
        //Отсортировать список домов по странам
        Collections.sort(houses, new Comparator<House>() {
            @Override
            public int compare(House o1, House o2) {
                return o1.getAddress().getCountry().compareTo(o2.getAddress().getCountry());
            }
        });
        HouseUtils.printAllHouses(houses);
        System.out.println("*************************");
        Collections.shuffle(houses);
        //Отсортировать список домов по странам и городам.
        Collections.sort(houses, new Comparator<House>() {
            @Override
            public int compare(House o1, House o2) {
                if (o1.getAddress().getCountry().equals(o2.getAddress().getCountry())) {
                    return o1.getAddress().getPopulatedPlaceName().compareTo(o2.getAddress().getPopulatedPlaceName());
                } else {
                    return o1.getAddress().getCountry().compareTo(o2.getAddress().getCountry());
                }
            }
        });
        HouseUtils.printAllHouses(houses);
    }
}
