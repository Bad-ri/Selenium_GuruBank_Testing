package Data;

public class DataGenerator {
    public String getStartSpace (String input){
        return input.replaceFirst("."," ") ;
    }
    public String getBlank (String input){
        return input.replaceAll(".*","") ;
    }
    public String getMiddleSpecialCharacter (String input){
        return input.concat("#").repeat(2);
    }
    public String getStartSpecialCharacter (String input){
        return input.replaceFirst(".","#");
    }
    public String getEndSpecialCharacter (String input){
        return input.concat("#");
    }
}
