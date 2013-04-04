/**
 * User: APetrashkevich
 * Date: 04.04.13
 * Time: 16:16
 */
public class RoamingRef {
    private String countryCode;
    private String prefix;
    private String roamingPartner;

    public RoamingRef(String countryCode, String prefix, String roamingPartner) {
        this.countryCode = countryCode;
        this.prefix = prefix;
        this.roamingPartner = roamingPartner;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getRoamingPartner() {
        return roamingPartner;
    }

    public void setRoamingPartner(String roamingPartner) {
        this.roamingPartner = roamingPartner;
    }

    public String sqlRepresentation() {
        return "('" + getCountryCode() + "', '" + getPrefix() + "', '" + getRoamingPartner() + "')";
    }
}
