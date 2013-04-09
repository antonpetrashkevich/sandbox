import java.util.List;

/**
 * User: APetrashkevich
 * Date: 09.04.13
 * Time: 15:20
 */
public class Utils {
    static RoamingRef findByPrefixAndCountryCodePair(List<RoamingRef> result, String prefix, String countryCode) {
        for(RoamingRef roamingRef: result){
            if(roamingRef.getPrefix().equals(prefix)&& roamingRef.getCountryCode().equals(countryCode)){
                return roamingRef;
            }
        }
        return null;
    }
}
