package com.company.G2;

public class Pyramid {
    private double height;
    private String modern_name;
    private String pharaoh;
    private String site;

    public Pyramid(String modern_name
            ,String pharaoh,String site,double height){
        try {
            this.height = height;
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            this.modern_name = modern_name;
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            this.pharaoh = pharaoh;
        } catch (Exception e) {
            e.printStackTrace();
        }try {
            this.site = site;
        } catch (Exception e) {
            e.printStackTrace();
        }

            }



    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getModern_name() {
        return modern_name;
    }

    public void setModern_name(String modern_name) {
        this.modern_name = modern_name;
    }

    public String getPharaoh() {
        return pharaoh;
    }

    public void setPharaoh(String pharaoh) {
        this.pharaoh = pharaoh;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @Override
    public String toString() {
        return "Pyramid{" +
                "height='" + height + '\'' +
                ", modern_name='" + modern_name + '\'' +
                ", pharaoh='" + pharaoh + '\'' +
                ", site='" + site + '\'' +
                '}';
    }
}
