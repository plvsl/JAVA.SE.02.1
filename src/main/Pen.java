package main;

public class Pen {

    private String ManufacturerName;
    private int price;
    private String color;
    private Type type;

    private enum Type {
        BALLPOINT, ROLLERBAL, FOUNTAIN, MARKER
    }

    public Pen(String ManufacturerName, int price, String color, String penType) {
        this.ManufacturerName = ManufacturerName;
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
        return price == pen.price &&
                (ManufacturerName == pen.ManufacturerName || (ManufacturerName != null
                        && ManufacturerName.toLowerCase().equals(pen.ManufacturerName.toLowerCase())))
                && (color == pen.color || (color != null && color.toLowerCase().equals(pen.color.toLowerCase())))
                && (type == pen.type || (type != null && type.equals(pen.type)));
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = 1;
        if ((ManufacturerName != null) || (color != null) || (type != null)) {
            result = PRIME * result + price;
            result = PRIME * result + ManufacturerName.toLowerCase().hashCode();
            result = PRIME * result + color.toLowerCase().hashCode();
            result = PRIME * result + type.hashCode();
            return result;

        } else {
            result = PRIME * result;
            result = PRIME * result;
            result = PRIME * result;
            return result;
        }

    }

    @Override
    public String toString() {
        return "ManufacturerName: '" + this.ManufacturerName + "', Price: '" + this.price + "', Color: '" + this.color + "', Type: '" + this.type + "'";
    }

}
