package main;

public class Pen {

    private String manufacturerName;
    private int price;
    private String color;
    private Type type;

    private enum Type {
        BALLPOINT, ROLLERBAL, FOUNTAIN, MARKER
    }

    public Pen(String ManufacturerName, int price, String color, String penType) {
        this.manufacturerName = ManufacturerName;
        this.price = price;
        this.color = color;
        this.type = Type.valueOf(penType.toUpperCase());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Pen pen = (Pen) obj;
        if (price != pen.price)
            return false;
        else if ((manufacturerName != pen.manufacturerName && manufacturerName == null)
                || !manufacturerName.toLowerCase().equals(pen.manufacturerName.toLowerCase()))
            return false;
        else if ((color != pen.color && color == null) || !color.toLowerCase().equals(pen.color.toLowerCase()))
            return false;
        else if ((type != pen.type && type == null) || !type.equals(pen.type))
            return false;
        else
            return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        return ((manufacturerName != null) || (color != null) || (type != null)) ?
                PRIME * (PRIME * (PRIME * (PRIME * result + price) +
                        manufacturerName.toLowerCase().hashCode()) + color.toLowerCase().hashCode()) + type.hashCode() :
                PRIME * PRIME * PRIME * result;
    }

    @Override
    public String toString() {
        return "ManufacturerName: '" + this.manufacturerName + "', Price: '" + this.price + "', Color: '" + this.color + "', Type: '" + this.type + "'";
    }

}
