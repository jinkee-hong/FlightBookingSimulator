public enum SearchTagList {

    DESTINATION("Destination",1),
    DEPARTURE("Departure",2),
    DEPARTURE_DAY("Departure Day",3),
    DESTINATION_DAY("Destination Day",4),
    FLIGHT_NUMBER("Flight Number",5);

    private int order;
    private String str;

    SearchTagList(String str,int order)
    {
        this.str = str;
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public String getStr() {
        return str;
    }
}
