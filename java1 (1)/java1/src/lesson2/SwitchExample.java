package lesson2;

public class SwitchExample {

    public static void main(String[] args) {

    }

    static String convertSeason(int seasonNumber) {
        if (seasonNumber == 1) return "Winter";
        if (seasonNumber == 2) return "Spring";
        if (seasonNumber == 3) return "Summer";
        if (seasonNumber == 4) return "Fall";
        return "Unknown season";
    }


    static String convertSwitchSeason(int seasonNumber) {

        return switch (seasonNumber) {
            case 1 -> "Winter";
            case 2 -> "Spring";
            case 3 -> "Summer";
            case 4 -> "Fall";
            default -> "Unknown season";
        };
    }

    static void printSwitchSeason(int seasonNumber) {

        switch (seasonNumber) {
            case 1:
                System.out.println("Winter");
                break;
            case 2:
                System.out.println("Spring");
                break;
            case 3:
                System.out.println("Summer");
                break;
            case 4:
                System.out.println("Fall");
                break;
            default:
                System.out.println("Unknown season");
        }
    }

}
