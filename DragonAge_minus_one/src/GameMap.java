import java.util.ArrayList;

public class GameMap {
    static Team Heroes;
    static ArrayList<Level> levels = new ArrayList<Level>();
    static boolean endgame = true;
    static int levelnumber;


    public static void map(){
        while (endgame){
            for(int x = 0; endgame;x++){
                levelnumber++;
                levels.add(new Level(x,Heroes));
                Turn turns = new Turn(levels.get(x).Enemies,Heroes);
                endgame = turns.startturns(levels.get(x));

            }




        }

        //versus method
        //++levelnumber
        //go map method again if all play chars alive



    }

    public static void resetturn(){

    }
}
