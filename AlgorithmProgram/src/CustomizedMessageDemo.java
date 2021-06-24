/*********************************************************************************************************
 *
 * Purpose : Customize Message Demonstration using String Function and RegEx
 *           a. Desc -> Read in the following message: Hello <<name>>, We have your full
 *              name as <<full name>> in our system. your contact number is 91-xxxxxxxxxx.
 *              Please,let us know in case of any clarification Thank you BridgeLabz 01/01/2016.
 *              Use Regex to replace name, full name, Mobile#, and Date with proper value.
 *           b. I/P -> read in the Message
 *           c. Logic -> Use Regex to do the following
 *              i. Replace <<name>> by first name of the user ( assume you are the user)
 *             ii. replace <<full name>> by user full name.
 *            iii. replace any occurance of mobile number that should be in format
 *                 91-xxxxxxxxxx by your contact number.
 *             iv. replace any date in the format XX/XX/XXXX by current date.
 *
 * @author Krunal Lad
 * @Since 24-06-2021
 *
 *******************************************************************************************************/

import java.io.*;

public class CustomizedMessageDemo {
    public static void main(String[] args) throws IOException {

        CustomizedMessageDemo cm = new CustomizedMessageDemo();
        String filePath = "C:\\Users\\Kunal\\IdeaProjects\\AlgorithmPrograms\\src\\Message";

        String oldLine;
        BufferedReader in = new BufferedReader(new FileReader(filePath));
        System.out.println("Message before modification : ");
        while ((oldLine = in.readLine()) != null) {

            System.out.println(oldLine);

        }
        System.out.println();

        // getting current date using in build functions
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        String currentDate = String.valueOf(date);

        // replaceWords method called
        cm.replaceWords("<<name>>", "Krunal", filePath);
        cm.replaceWords("<<full name>>", "Krunal Kishor Lad", filePath);
        cm.replaceWords("91-xxxxxxxxxx", "8945786589", filePath);
        cm.replaceWords("01/01/2016", currentDate, filePath);

        // Printing modified message
        String newLine;
        BufferedReader read = new BufferedReader(new FileReader(filePath));
        System.out.println("Modified Message : ");
        while ((newLine = read.readLine()) != null) {

            System.out.println(newLine);

        }

    }

    /**
     * Purpose : Initially it is Reading Data from file  and if we want to perform regex operations
     *  we have to store file data in string as regex are used to modify strings and not files.
     *  We need other tools read text from file and convert it to string ,then apply regex,then store
     *  string in file,So it has used Buffer Reader to perform read and write operations.
     *
     * @param regex word which needs to be replaced in file/message
     * @param replacement word with which it will replace old word @regex
     * @param filePath path of the file where data is stored
     */
    public void replaceWords(String regex, String replacement, String filePath) {

        try {

            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = "", oldText = "";

            // reading whole file and converting to string
            while ((line = reader.readLine()) != null) {

                oldText += line + "\r\n";

            }
            reader.close();

            // replacing word from string with new word
            String newText = oldText.replaceAll(regex, replacement);

            // storing new string with replace word again in file
            FileWriter writer = new FileWriter(filePath);
            writer.write(newText);
            writer.close();

        } catch (IOException e) {

            e.printStackTrace();

        }

    }
}
