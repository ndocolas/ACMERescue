import Manage.ACMERescue;
import Manage.LeituraInicial;
import Manage.TelaPrincipalGUI;

public class Main {
    public static void main(String[] args) {
        //new LeituraInicial(new ACMERescue());
        new TelaPrincipalGUI(new ACMERescue());
    }
}