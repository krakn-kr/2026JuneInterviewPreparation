package enume.usecase1;

public enum Day {
    SUNDAY,MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY


}
class Main{
    public static void main(String[] args) {
        Day today = Day.SATURDAY;
        switch (today){
            case WEDNESDAY -> System.out.println("Halfway through the work week!");
            case SUNDAY,MONDAY,TUESDAY,THURSDAY,FRIDAY,SATURDAY -> System.out.println("Hi");
        }
    }

}

