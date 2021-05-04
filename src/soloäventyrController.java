import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class soloäventyrController {
    model model;
    design view;

    public soloäventyrController(AbstractButton editButton, AbstractButton Database, AbstractButton startButton) {
        JFrame frame = new JFrame("Design");
        view = new design();
        model = new model();
        frame.add(view.soloview);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.start.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        try {
                            ArrayList<links> links = model.getLinks(model.currentRoom);

                            links linl1=links.get(0);
                            view.back.setText(linl1.getDescription());
                            view.back.setName(String.valueOf(linl1.getTarget_id()));

                            links linl2 = null;
                            if (links.size() > 1) {
                                linl2 = links.get(1);
                                view.next.setText(linl2.getDescription());
                                view.next.setName(String.valueOf(linl2.getTarget_id()));
                            } else{
                                view.next.setText("-");
                            }

                            view.Story.setText(model.getStory(model.currentRoom));

                            model.currentRoom++;
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });
                //System.out.println("hej");
            }
        });
    }

}
