import javax.swing.*;

public class soloäventyr {
    model model;
    design view;

    public soloäventyr(AbstractButton editButton, AbstractButton Database, AbstractButton startButton) {
        JFrame frame = new JFrame("Design");
        view = new design();
        model = new model();
        frame.add(view.soloview);
    }
}
