package View;

import Handler.ConnectURI;
import Model.Medicine;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class MainUI {
    private JPanel panel;
    private JPanel customHeader;
    private JPanel form;
    private JPanel exiting;
    private JButton submitButton;
    private JTextField totalValue;
    private JButton exitButton;
    private JButton minimize;
    private JTextField higherPriceValue;
    public JPanel getPanel() {
        return panel;
    }

    public MainUI() {
        // Style
        customHeader.setBackground(Color.decode("#008080"));

        // Exit button action listener
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
        });

        // Submit button action listener
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reset input text
                totalValue.setText("");
                higherPriceValue.setText("");

                try {
                    // Connect to API and retrieve Data
                    ConnectURI connectURI = new ConnectURI();
                    URL address = connectURI.buildURL(
                            "https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
                    String jsonStr = connectURI.getResponseFromHttpUrl(address);

                    // Parse to JSONArray and throw an error if data not exists
                    JSONArray jsonArray = new JSONArray(jsonStr);
                    if (jsonArray.length() == 0) {
                        throw new Exception("No Data Found");
                    }

                    ArrayList<Medicine> medicines = new ArrayList<>();
                    Integer medicineHigherPrice = 0;
                    for(int i =0; i < jsonArray.length(); i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Medicine medicineModel = new Medicine();
                        medicineModel.fromJSON(jsonObject);
                        medicines.add(medicineModel);

                        // If any new medicine with higher price replace the old medicineHigherPrice value
                        if ((medicineModel.getSell() != null) && (medicineModel.getSell() > medicineHigherPrice)) {
                            medicineHigherPrice = medicineModel.getSell();
                        }
                    }

                    totalValue.setText( String.valueOf(medicines.size()) );
                    higherPriceValue.setText( String.valueOf(medicineHigherPrice) );

                } catch (Exception err) {
                    System.out.println("Error: " + err);
                }
            }
        });

    }
    public JButton getMinimize(){
        return minimize;
    }
}
