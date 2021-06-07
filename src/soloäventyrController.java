import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class soloäventyrController {
    model model;
    design view;

    public soloäventyrController() {
        JFrame frame = new JFrame("Design");
        view = new design();
        model = new model();
        frame.add(view.soloview);
        frame.setVisible(true);

        view.startFörsättButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                        try {
                            ArrayList<links> links = model.getLinks(model.currentRoom);
                            System.out.println(links.size());
                            links linl1=links.get(0);
                            view.backButton.setText(linl1.getDescription());
                            view.backButton.setName(String.valueOf(linl1.getTarget_id()));

                            links linl2 = null;
                            if (links.size() > 1) {
                                linl2 = links.get(1);
                                view.nextButton.setText(linl2.getDescription());
                                view.nextButton.setName(String.valueOf(linl2.getTarget_id()));
                            } else{
                                view.nextButton.setText("-");
                            }

                            view.story.setText(model.getStory(model.currentRoom));

                            model.currentRoom++;
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                });

        view.nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.currentRoom = Integer.parseInt(view.nextButton.getName());
                ArrayList<links>links = null;
                try {
                    links = model.getLinks(model.currentRoom);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                try {
                    view.story.setText(model.getStory(model.currentRoom));
                } catch (SQLException eex) {
                    eex.printStackTrace();
                }
                if (links.size() == 0) {
                    System.out.println("end");

                    return;
                }

                links linl1=links.get(0);
                view.nextButton.setText(linl1.getDescription());
                view.nextButton.setName(String.valueOf(linl1.getTarget_id()));

                links linl2 = null;
                if (links.size() > 1) {
                    linl2 = links.get(1);
                    view.backButton.setText(linl2.getDescription());
                    view.backButton.setName(String.valueOf(linl2.getTarget_id()));
                } else{
                    view.backButton.setText("-");
                }


            }
        });

        view.backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.currentRoom = Integer.parseInt(view.backButton.getName());
                ArrayList<links>links = null;
                try {
                    links = model.getLinks(model.currentRoom);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }

                links linl2 = null;
                if (links.size() > 1) {
                    linl2 = links.get(0);
                    view.backButton.setText(linl2.getDescription());
                    view.backButton.setName(String.valueOf(linl2.getTarget_id()));
                } else{
                    view.backButton.setText("-");
                }

                if (links.size() == 2) {
                    links linl1 = links.get(1);
                    view.nextButton.setText(linl1.getDescription());
                    view.nextButton.setName(String.valueOf(linl1.getTarget_id()));
                }

                try {
                    view.story.setText(model.getStory(model.currentRoom));
                } catch (SQLException e2) {
                    e2.printStackTrace();
                }

            }
        });

    }

    public static void main(String[] args){
        soloäventyrController game = new soloäventyrController();
        game.CharStreamExample();
    }
    private void CharStreamExample() {
    }
}