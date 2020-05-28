package com.anfly.a1908a;

public  class Computer {
    private String name;
    private String os;
    private float price;
    private int color;

    public static class Builder {
        Computer computer;

        public Builder(){
            computer = new Computer();
        }

        public Builder setName(String name) {
            computer.setName(name);
            return this;
        }

        public Builder setColor(int color) {
            computer.setColor(color);
            return this;
        }

        public Builder setPrice(float price) {
            computer.setPrice(price);
            return this;
        }

        public Builder setOs(String os) {
            computer.setOs(os);
            return this;
        }

        public Computer build() {
            return computer;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", os='" + os + '\'' +
                ", price=" + price +
                ", color=" + color +
                '}';
    }
}
