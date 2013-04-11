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

    @Override
    public String toString() {
        return "RoamingRef{" +
                "countryCode='" + countryCode + '\'' +
                ", prefix='" + prefix + '\'' +
                ", roamingPartner='" + roamingPartner + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoamingRef that = (RoamingRef) o;

        if (!countryCode.equals(that.countryCode)) return false;
        if (!prefix.equals(that.prefix)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryCode.hashCode();
        result = 31 * result + prefix.hashCode();
        return result;
    }
}
