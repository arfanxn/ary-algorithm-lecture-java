import Model.FootballClub;
import Model.FootballClubContainer;
import View.MainUI;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

public class Main {
    public static int posX=0,posY=0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // read file as buffer string
        StringBuffer footballClubStrBuff = Utilities.File.readAsStrBuffer("src/Assets/brazil_club.json");
         // String to JsonObject
        JSONObject footballClubJsonObj = new JSONObject(footballClubStrBuff.toString());

        FootballClubContainer footballClubContainer = new FootballClubContainer();
        footballClubContainer.setFromJsonObject(footballClubJsonObj);
        footballClubContainer.printWithDescription();

        System.out.println("\nSearch clubs by name, enter the club name below here");
        String searchKeyword = scanner.nextLine();
        if ((searchKeyword != null) && (searchKeyword != "")) {
            FootballClubContainer filteredFootballClubContainer = footballClubContainer;
            filteredFootballClubContainer.setClubs(footballClubContainer.getClubsByName(searchKeyword));
            filteredFootballClubContainer.printWithDescription();
        }



        //Checking whether the JSON array has some value or not
//        if (footballClubsJsonArr != null) {
//
//            //Iterating JSON array
//            for (int i=0;i<footballClubsJsonArr.length();i++){
//
//                //Adding each element of JSON array into ArrayList
//                listdata.add(footballClubsJsonArr.get(i));
//            }
//        }
//        //Iterating ArrayList to print each element
//
//        System.out.println("Each element of ArrayList");
//        for(int i=0; i<listdata.size(); i++) {
//            //Printing each element of ArrayList
//            System.out.println(listdata.get(i));
//        }

        /*
        String[] mahasiswas = {"Winda", "Edu", "Ary", "Oki", "Arie"};
        StrSelectionSort _mySS = new StrSelectionSort();
        _mySS.setData(mahasiswas);
        _mySS.sortData();
        _mySS.printData();
        */

        /*
        // Pertama siapkan data bertipe String[] lalu masukan ke variable modelTrain
        String[] modelTrain = new String[]{"Jika", "Kota", "Apabila", "Pergi", "Malam", "Kamu"};
        // Instantiate class StrBubbleSort (class untuk melakukan string bubble sorting)
        StrBubbleSort strBubbleSort = new StrBubbleSort();
        // Set data pada strBubbleSort dengan data yang tadi telah di siapkan
        strBubbleSort.setData(modelTrain);
        // Setelah data di set pada strBubbleSort call method sortData() untuk melakukan sorting
        strBubbleSort.sortData();
        // Lalu ambil data yang telah di sort oleh strBubbleSort lalu store data pada variable sortedStrings
        String[] sortedStrings = strBubbleSort.getData();
        */
    }

    public static void renderView () {
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(400, 300);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setUndecorated(true);
        MainUI content = new MainUI();
        mainFrame.setContentPane(content.getPanel());
        mainFrame.setVisible(true);
        mainFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.decode("#9E9E9E")));

        content.getPanel().addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                posX=e.getX();
                posY=e.getY();
            }
        });

        content.getPanel().addMouseMotionListener(new MouseAdapter()
        {
            public void mouseDragged(MouseEvent evt)
            {
                mainFrame.setLocation(evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
            }
        });

        content.getMinimize().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setExtendedState(mainFrame.getExtendedState() | mainFrame.ICONIFIED);
            }
        });
    }
}
