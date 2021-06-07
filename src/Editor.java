import javax.swing.*;
import javax.swing.text.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;


public class Editor {
    public JPanel EditorView;
    public JTextArea story1;
    public JButton bringButton;
    public JButton edit;
    public JTextField story2;
    model model;
    Editor view;


    public Editor() {
        JFrame frame = new JFrame("EditorView");
        view = new Editor();
        model = new model();
        frame.add(view.EditorView);
        frame.setVisible(true);
        
        view.bringButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList<links> links = model.getLinks(model.currentRoom);
                    System.out.println(links.size());
                    links linl1=links.get(0);
                    view.bringButton.setText(linl1.getDescription());
                    view.bringButton.setName(String.valueOf(linl1.getTarget_id()));
            
                    links linl2 = null;
                    

                    view.story1.setText(model.getStory(model.currentRoom));

                    model.currentRoom++;
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Scanner in = new Scanner(System.in);
               // String nystory = in.nextLine();
                //view.story2.getText();
                //view.edit.setText();


                // UPDATE `Te18`.`Story` SET `body` = 'nystory' WHERE `id` = 1 AND `body` = 'story';


            }
        });
    }

    public static void main(String[] args){
        Editor game = new Editor();
        game.CharStreamExample();
    }

    private void CharStreamExample() {
    }

}



