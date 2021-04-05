package lab04;
import java.util.Map;

public class Game{
    //private static final String[] valid_input = {"rock","paper","scissors"};
    public static Map<String,Integer > valid_input=Map.of("rock",0,"paper",1,"scissors",2);
    private static final int[][] map={{0,-1,1},
                                    {1,0,-1},
                                    {-1,1,0}};
    public static void  validate_input(String p1) throws IllegalArgumentException{
        if(p1==null  || !valid_input.containsKey(p1) )
            throw new IllegalArgumentException();

    }

    public static int game(String p1,String p2){
        if(p1==p2)
            return 0;
        return map[valid_input.get(p1)][valid_input.get(p2)];
    }
}