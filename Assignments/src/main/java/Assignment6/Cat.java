package Assignment6;

public class Cat extends Pet implements Boardable {

    private int[] startDate;
    private int[] endDate;

    private  String hairLength;

    public Cat(String petName, String ownerName, String color, String hairLength) {
        super(petName, ownerName, color);
        this.hairLength = hairLength;
        initDates();
    }

    public void initDates(){
        startDate = new int[3];
        endDate = new int[3];
    }

    public String getHairLength() {
        return hairLength;
    }

    @Override
    public void setBoardStart(int month, int day, int year) {
        startDate[0] = month;
        startDate[1] = day;
        startDate[2] = year;
    }

    @Override
    public void setBoardEnd(int month, int day, int year) {
        endDate[0] = month;
        endDate[1] = day;
        endDate[2] = year;
    }

    @Override
    public boolean boarding(int month, int day, int year) {
        //if date is invalid
        if(month<1 || month>12 || day<1 || day>31 || year<1000 || year>9999) {
            System.out.println("Invalid date");
            return false;
        }
        //case 1
        if(year>startDate[2] && year<endDate[2]) return true;

        //case 2
        if(year==startDate[2] && year<endDate[2]){
            //check month
            if(month>startDate[0]) return true;
            if(month == startDate[0]){
                //check day
                if(day>=startDate[1]) return true;
            }
        }

        //case 3
        if(year>startDate[2] && year==endDate[2]){
            //check month
            if(month<endDate[0]) return true;
            if(month == endDate[0]){
                //check day
                if(day<=startDate[1]) return true;
            }
        }

        //case 4
        if(year== startDate[2] && year==endDate[2]){
            if(month>startDate[0] && month<endDate[0])
                return true;
            if(month==startDate[0] && month<endDate[0]){
                //check day
                if(day>=startDate[1])
                    return true;
            }
            if(month>startDate[0] && month==endDate[0]){
                if (day<=endDate[1])
                    return true;
            }
            if(month==startDate[0] && month==endDate[0]){
                if(day>=startDate[1] && day<=endDate[1])
                    return true;
            }
        }
        return false;
    }

    public String toString(){
        return "CAT: " +
                "\n" + super.toString() +
                "\n" + "Hair: " + getHairLength();
    }
}
