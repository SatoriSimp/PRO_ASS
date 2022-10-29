package hrs.main;
import hrs.service.Functional;
import hrs.utils.Input;
/**
 *
 * @author Dell
 */
public class Main {
    public static void main(String[] args) {
        program:
        while (true) {
            Menu.display();
            switch (Input.Shrt((short)1, (short)8)) {
                case 1:
                    Functional.addEmployee();
                    break;
                case 2:
                    Functional.displaySorted();
                    break;
                case 3:
                    Functional.classifyEmp();
                    break;
                case 4:
                    Functional.searchEmp();
                    break;
                case 5:
                    Functional.updateEmp();
                    break;
                case 6:
                    Functional.deleteEmployee();
                    break;
                case 7:
                    Functional.report();
                    break;
                case 8:
                    break program;
            }
            System.out.println();
        }
    }
}
