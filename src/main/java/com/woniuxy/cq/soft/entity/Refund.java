package com.woniuxy.cq.soft.entity;

public class Refund {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column refund.id
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column refund.eid
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    private Integer eid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column refund.pid
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    private Integer pid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column refund.status
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column refund.id
     *
     * @return the value of refund.id
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column refund.id
     *
     * @param id the value for refund.id
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column refund.eid
     *
     * @return the value of refund.eid
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public Integer getEid() {
        return eid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column refund.eid
     *
     * @param eid the value for refund.eid
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public void setEid(Integer eid) {
        this.eid = eid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column refund.pid
     *
     * @return the value of refund.pid
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column refund.pid
     *
     * @param pid the value for refund.pid
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column refund.status
     *
     * @return the value of refund.status
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column refund.status
     *
     * @param status the value for refund.status
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table refund
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
        sb.append(", eid=").append(eid);
        sb.append(", pid=").append(pid);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}