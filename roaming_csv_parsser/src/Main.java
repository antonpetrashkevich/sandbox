import au.com.bytecode.opencsv.CSVReader;

import java.io.*;
import java.util.*;

/**
 * User: APetrashkevich
 * Date: 04.04.13
 * Time: 14:12
 */
public class Main {

    public static final int INSERTS_PER_BATCH = 300;

    public static void main(String[] args) {
        try {
            CSVReader reader = new CSVReader(new FileReader(Main.class.getClassLoader().getResource("roaming.csv").getFile()), ';');
            List<String[]> entries = reader.readAll();
            Set<RoamingRef> roamingRefs = parseRoamingRefs(entries);

            printResultSQLInsertString(roamingRefs);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Set<RoamingRef> parseRoamingRefs(List<String[]> entries) {

        Set<RoamingRef> result = new LinkedHashSet<RoamingRef>(5000000);
        List<String> prefixes = new ArrayList<String>();

        for (String[] entry : entries) {
            prefixes.clear();
            prefixes = differentPrefixes(entry[2]);
            for (String prefix : prefixes) {
//                boolean alreadyContainsSuchPrefixAndCountryCodePair = Utils.findByPrefixAndCountryCodePair(result, prefix, entry[1])!=null;
                RoamingRef roamingRef = new RoamingRef(entry[1], prefix, entry[0]);
                if(!result.contains(roamingRef))       {
                result.add(roamingRef);
                }else {
                    System.out.println(roamingRef.toString());
                }
            }

        }
        return result;
    }

    private static List<String> differentPrefixes(String prefixes) {
        List<String> result = new ArrayList<String>();

        if (prefixes.matches("[\\d]+")) {
            result.add(prefixes);
        } else if (prefixes.matches("[\\s]*[\\d]+[\\s]*-[\\s]*[\\d]+[\\s]*")) {
            String[] bounds = prefixes.replaceAll("[\\s]", "").split("[\\s-]");
            long lowerBound = Long.valueOf(bounds[0]);
            long upperBound = Long.valueOf(bounds[1]);
            for (long i = lowerBound; i <= upperBound; i++) {
                result.add(String.valueOf(i));
            }
        } else {
//            System.out.println(prefixes);
        }

        return result;
    }

    private static void printResultSQLInsertString(Set<RoamingRef> roamingRefs) {
        int insertedInBatch=0;

//        PrintStream out = System.out;

        PrintWriter out = null;
        try {
            out = new PrintWriter("filename.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        out.println("INSERT ALL");
        for (RoamingRef roamingRef : roamingRefs) {
            out.println("into CCBO_ROAMING_CALLBACK_TEST (COUNTRY_CODE, PREFIX, ROAMING_PARTNER) VALUES" + roamingRef.sqlRepresentation());
            insertedInBatch++;
            if(insertedInBatch== INSERTS_PER_BATCH){
                insertedInBatch=0;
                out.println("SELECT * FROM dual;");
                out.println("INSERT ALL");
            }
        }
        out.println("SELECT * FROM dual;");
        out.close();
    }
}
