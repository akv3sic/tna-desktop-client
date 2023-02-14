package app.model;

public class Record {
    private String card_id;
    private int event;

    public Record(String card_id, int event) {
        this.card_id = card_id;
        this.event = event;
    }

    public Record() {
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }
}
