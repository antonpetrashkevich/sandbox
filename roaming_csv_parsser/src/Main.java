import au.com.bytecode.opencsv.CSVReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: APetrashkevich
 * Date: 04.04.13
 * Time: 14:12
 */
public class Main {
    public static void main(String[] args) {
        try {
            CSVReader reader = new CSVReader(new FileReader(Main.class.getClassLoader().getResource("roaming.csv").getFile()), ';');
            List<String[]> entries = reader.readAll();
            List<RoamingRef> roamingRefs = parseRoamingRefs(entries);

            String resultInsertString = formResultSQLInsertString(roamingRefs);
            System.out.println(resultInsertString);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<RoamingRef> parseRoamingRefs(List<String[]> entries) {
        List<RoamingRef> result = new ArrayList<RoamingRef>();

        for (String[] entry : entries) {
            List<String> prefixes = differentPrefixes(entry[2]);
            for (String prefix : prefixes) {
                boolean alreadyContainsSuchPrefixAndCountryCodePair = Utils.findByPrefixAndCountryCodePair(result, prefix, entry[1])!=null;
                if(!alreadyContainsSuchPrefixAndCountryCodePair)       {
                result.add(new RoamingRef(entry[1], prefix, entry[0]));
                }else {
                    System.out.println(new RoamingRef(entry[1], prefix, entry[0]).toString());
                }
            }

        }
        return result;
    }

    private static List<String> differentPrefixes(String prefixes) {
        List<String> result = new ArrayList<String>();

        if (prefixes.matches("[\\d]+")) {
            result.add(prefixes);
        }/* else if (prefixes.matches("[\\s]*[\\d]+[\\s]*-[\\s]*[\\d]+[\\s]*")) {
            String[] bounds = prefixes.replaceAll("[\\s]", "").split("[\\s-]");
            int lowerBound = Integer.valueOf(bounds[0]);
            int upperBound = Integer.valueOf(bounds[1]);
            for (int i = lowerBound; i <= upperBound; i++) {
                result.add(String.valueOf(i));
            }
        }*/ else {
//            System.out.println(prefixes);
        }

        return result;
    }

    private static String formResultSQLInsertString(List<RoamingRef> roamingRefs) {
        StringBuilder result = new StringBuilder("INSERT ALL\n");
        for (RoamingRef roamingRef : roamingRefs) {
            result.append("into CCBO_ROAMING_CALLBACK_TEST (COUNTRY_CODE, PREFIX, ROAMING_PARTNER) VALUES" + roamingRef.sqlRepresentation() + "\n");
        }
        result.append("SELECT * FROM dual;");
        return result.toString();
    }
}
