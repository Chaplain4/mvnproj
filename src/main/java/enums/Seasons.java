package enums;

import java.util.Scanner;
enum Months {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
}

public enum Seasons {
    //0     1       2       3
    WINTER, SPRING, SUMMER, AUTUMN;

    /**
     * Choose 1,2,3 or 4
     * @param number
     * @return
     */
    public static Seasons getSeasonByNum (int number) {
        switch (number) {
            case 1:
                return WINTER;
            case 2:
                return SPRING;
            case 3:
                return SUMMER;
            case 4:
                return AUTUMN;
            default:
                return null;
        }
    }

    public static Seasons getSeasonByMonth (Months month) {
      switch (month) {
          case DECEMBER:
          case JANUARY:
          case FEBRUARY:
              return WINTER;
          case MARCH:
          case APRIL:
          case MAY:
              return SPRING;
          case JUNE:
          case JULY:
          case AUGUST:
              return SUMMER;
          case SEPTEMBER:
          case OCTOBER:
          case NOVEMBER:
              return AUTUMN;
      }
      throw new IllegalArgumentException("Incorrect month " + month.name());
    }
}

class SeasonsTester {
    public static void main(String[] args) {
        Seasons s1 = Seasons.SUMMER;
        Scanner sc = new Scanner(System.in);
        System.out.println("Input season");
        String SeasonName = sc.next();
        Seasons s2 = Seasons.valueOf(SeasonName.toUpperCase());
        switch (s2) {
            case WINTER:
                System.out.println("It's winter");
                break;
            case AUTUMN:
                System.out.println("It's autumn");
                break;
            case SPRING:
                System.out.println("It's spring");
                break;
            default:
                System.out.println("It's summer");
                break;
        }
        System.out.println(Seasons.valueOf("AUTUMN").ordinal());
        System.out.println("Input month");
        System.out.println(Seasons.getSeasonByMonth(Months.valueOf(sc.next().toUpperCase())));
    }
}