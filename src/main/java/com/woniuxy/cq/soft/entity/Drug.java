package com.woniuxy.cq.soft.entity;

public class Drug {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column drug.id
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column drug.drug_name
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    private String drugName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column drug.price
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    private Double price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column drug.number
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    private Integer number;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column drug.id
     *
     * @return the value of drug.id
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column drug.id
     *
     * @param id the value for drug.id
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column drug.drug_name
     *
     * @return the value of drug.drug_name
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public String getDrugName() {
        return drugName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column drug.drug_name
     *
     * @param drugName the value for drug.drug_name
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public void setDrugName(String drugName) {
        this.drugName = drugName == null ? null : drugName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column drug.price
     *
     * @return the value of drug.price
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column drug.price
     *
     * @param price the value for drug.price
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column drug.number
     *
     * @return the value of drug.number
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column drug.number
     *
     * @param number the value for drug.number
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public void setNumber(Integer number) {
        this.number = number;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table drug
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", drugName=").append(drugName);
        sb.append(", price=").append(price);
        sb.append(", number=").append(number);
        sb.append("]");
        return sb.toString();
    }
}