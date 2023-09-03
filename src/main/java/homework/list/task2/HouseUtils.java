package homework.list.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HouseUtils {
    public static House randomHouseGenerator(int id) {
        String[] places = {"City", "Settlement", "Town", "Village"};
        String[] countries = {"USA", "Canada"};
        String[] placenames = {"Washington", "Franklin", "Clinton", "Arlington", "Centerville", "Lebanon", "Georgetown", "Springfield", "Chester", "Fairview"};
        String[] streets = {"Main", "Park", "Oak", "Elm", "Maple", "River", "Church", "North", "West", "East", "South", "Hill", "Madison"};
        Address address = new Address(places[(int) (Math.random() * places.length)], countries[(int) (Math.random() * countries.length)], placenames[
                (int) (Math.random() * placenames.length)], streets[(int) (Math.random() * streets.length)], (int) (Math.random() * 100) + 1,
                (int) (Math.random() * 900000) + 100000);
        String[] types = {"Townhouse", "Bungalow", "Cottage", "Mansion", "Villa", "Chalet", "Cabin", "Hut", "Single-family detached"};
        String[] walls = {"Brick", "Concrete", "Wood", "Sandwich panels", "Dressed stone", "Aerated blocks"};
        String[] foundations = {"Basement", "Stem Walls", "Concrete Slab", "Wood", "Pier and Beam"};
        List<String> communications = new ArrayList<>();
        String[] comms = {"Running water", "Heating", "Gas", "Electricity", "Telephone", "Cable TV", "Internet connection"};
        for (int i = 0; i < (int) (Math.random() * 10)+3; i++) {
            String comm = comms[(int) (Math.random() * comms.length)];
            if (!(communications.contains(comm))) {
                communications.add(comm);
            }
        }
        Collections.sort(communications);
        House house = new House(id,(int) (Math.random() * 900) + 100, (int) (Math.random() * 5) + 1, types[(int) (Math.random() * types.length)], (int) (Math.random() * 900),
                walls[(int) (Math.random() * walls.length)], foundations[(int) (Math.random() * foundations.length)], (long) (Math.random() * 1000000) + 100000, address, communications);
        return house;
    }

    public static void printAllHouses(List<House> houses) {
        for (House house : houses) {
            System.out.println(house);
            System.out.println();
        }
    }

    public static void printAllPlaceNameHouses(List<House> houses, String placename) {
        for (House house : houses) {
            if (house.getAddress().getPopulatedPlaceName().equals(placename)) {
                System.out.println(house);
                System.out.println();
            }
        }
    }
    public static void printMinAreaHouses(List<House> houses, int minArea) {
        for (House house : houses) {
            if (house.getArea() >= minArea) {
                System.out.println(house);
                System.out.println();
            }
        }
    }

    public static void printMinFloorsHouses(List<House> houses, int minFloors) {
        for (House house : houses) {
            if (house.getNumberOfFloors() >= minFloors) {
                System.out.println(house);
                System.out.println();
            }
        }
    }

    public static void printWallMaterialHouses(List<House> houses, String wall) {
        for (House house : houses) {
            if (house.getWallMaterial().equals(wall)) {
                System.out.println(house);
                System.out.println();
            }
        }
    }

    public static void printFoundationHouses(List<House> houses, String found) {
        for (House house : houses) {
            if (house.getFoundationType().equals(found)) {
                System.out.println(house);
                System.out.println();
            }
        }
    }

    //написать метод который ищет дома с указанной коммуникацией. Например, где есть электричество.
    public static void printCommsHouses(List<House> houses, String comm) {
        for (House house : houses) {
            if (house.getCommunications().contains(comm)) {
                System.out.println(house);
                System.out.println();
            }
        }
    }
}

