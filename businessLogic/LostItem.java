package businessLogic;

public class LostItem {
    private String reporterName;
    private String itemDescription;
    private String location;

    public LostItem(String reporterName, String itemDescription, String location) {
        this.reporterName = reporterName;
        this.itemDescription = itemDescription;
        this.location = location;
    }

    public String getReporterName() {
        return reporterName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Reporter: " + reporterName +
                ", Item Description: " + itemDescription +
                ", Location: " + location;
    }
}