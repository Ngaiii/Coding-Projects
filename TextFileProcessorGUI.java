/* Ngai_Thang 
 * COSC 2430
 * Project 6
 * 12/7/23
 * This program creates a GUI interface that allows the user to input in texts. 
 * It then edits that text and sends the output to a file.
 * Which is then printed out on a GUI screen.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class TextFileProcessorGUI extends JFrame implements ActionListener {

    JButton enterButton, clearButton;
    JLabel inputLabel, outputLabel;
    JTextArea text, textDisplay;
    String fileName;

    TextFileProcessorGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Creates the frame.
        this.setTitle("Text-Box");
        this.setLocationRelativeTo(null);

        inputLabel = new JLabel("Input:"); // Creates the input and output labels.
        outputLabel = new JLabel("Output:");

        inputLabel.setFont(new Font("Consola", Font.BOLD, 15)); // Sets the font of the labels
        outputLabel.setFont(new Font("Consola", Font.BOLD, 15));

        JPanel topPanel = new JPanel(new GridLayout(1, 2)); // Creates the top and bottom panels.
        JPanel bottomPanel = new JPanel(new FlowLayout());

        enterButton = new JButton(); // Creates the enter and clear buttons.
        clearButton = new JButton();

        enterButton.setText("Enter"); // Sets the text on the buttons.
        clearButton.setText("Clear");

        text = new JTextArea(); // Creates the text box.
        text.setPreferredSize(new Dimension(500, 200));
        text.setFont(new Font("Consola", Font.BOLD, 28));
        text.setLineWrap(true);
        text.setWrapStyleWord(true); // Method used to keep the text within the borders of the text box.

        textDisplay = new JTextArea(); // Method used to create the output box.
        textDisplay.setPreferredSize(new Dimension(500, 200));
        textDisplay.setEditable(false);
        textDisplay.setFont(new Font("Consola", Font.BOLD, 28));
        textDisplay.setLineWrap(true);
        textDisplay.setWrapStyleWord(true);
        textDisplay.setBackground(Color.cyan);

        bottomPanel.add(enterButton); // Adds the buttons to the bottom panel.
        bottomPanel.add(clearButton);

        JPanel inputPanel = new JPanel(new BorderLayout()); //Creates the input and output panels.
        JPanel outputPanel = new JPanel(new BorderLayout());
       
        inputPanel.add(inputLabel, BorderLayout.NORTH); // Adds the text box to the input panel.
        inputPanel.add(new JScrollPane(text), BorderLayout.CENTER);

        outputPanel.add(outputLabel, BorderLayout.NORTH); // Adds output box to the output panel.
        outputPanel.add(new JScrollPane(textDisplay), BorderLayout.CENTER);

        topPanel.add(inputPanel); //Adds the input and output panels to the top panel.
        topPanel.add(outputPanel);

        this.setLayout(new BorderLayout()); // Sets the layout of the frame.
        this.add(topPanel, BorderLayout.CENTER); // Adds panels to the frame.
        this.add(bottomPanel, BorderLayout.SOUTH);
        this.pack();
        this.setVisible(true); // Sets frame visible.

        clearButton.addActionListener(this); // Allows buttons to have actions.
        enterButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) { // Grabs the action if button is pressed.
        if(e.getSource() == enterButton) {
            String inputText = text.getText(); // If the enter button is pressed the text is then submitted than printed. 
            fileName = "output.txt";
            processor(fileName, inputText);
            printFile(fileName);
        }
        if(e.getSource() == clearButton) { // If the clear button is pressed the text is cleared.
            text.setText("");
            textDisplay.setText("");
        }
    }

    private void processor(String fileName, String content) { // Used to modify the text.
        try {
            PrintWriter writer = new PrintWriter(new FileWriter(fileName));
            String[] sentences = content.split("(?<=[.!?])\\s*");

            for(String sentence : sentences) {
                if(!sentence.trim().isEmpty()) {
                    String correctedSentence = sentence.trim().replaceAll("\\s+", " ");
                    writer.println(upperCaseFirstLetter(correctedSentence));
                }
            }
            writer.close();
        } 
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    private String upperCaseFirstLetter(String line) { // Method to capitalize the first letter.
        if(line == null || line.isEmpty()) {
            return line;
        } 
        else {
            return Character.toUpperCase(line.charAt(0)) + line.substring(1);
        }
    }

    public void printFile(String fileName) { // Method used to print the modify text
        try {
            Scanner inputStream = new Scanner(new File(fileName));

            while(inputStream.hasNextLine()) {
                String content = inputStream.nextLine();
                guiTextDisplay(content);
            }

            inputStream.close();
        } 
        catch(FileNotFoundException e) {
            System.out.println("Error finding the file " + fileName);
            System.exit(0);
        } 
        catch(IOException e) {
            System.out.println("Error opening file " + fileName);
            System.exit(0);
        }
    }

    public void guiTextDisplay(String content) {
        textDisplay.append(content + "\n");
    }

    public static void main(String[] args) { // Creates an instance of the TextFileProcessorGUI and operates the code.
        SwingUtilities.invokeLater(() -> {
            TextFileProcessorGUI GUI = new TextFileProcessorGUI();
            GUI.setSize(800, 500);
            GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            GUI.setVisible(true);
        });
    }
}
