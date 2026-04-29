package mainMorraCinese;
import modelMorraCinese.Model;
/**
 *
 * @author Vittorio Privitera
 */
public class Tester {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Model model=new Model();
        System.out.println(model.toString());
        model.iniziaPartita("Vittorio",3);
        model.gioco(1);
        System.out.println(model.toString());
        model.gioco(2);
        System.out.println(model.toString()); 
        model.gioco(3);
        System.out.println(model.toString());
    } 
}
