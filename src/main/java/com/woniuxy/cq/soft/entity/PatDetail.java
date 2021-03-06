package com.woniuxy.cq.soft.entity;

import java.util.Date;

public class PatDetail {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pat_detail.id
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pat_detail.pid
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    private Integer pid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pat_detail.detail
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    private String detail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pat_detail.eid
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    private Integer eid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pat_detail.e_name
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    private String eName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pat_detail.time
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    private Date time;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pat_detail.pat_detail
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    private String patDetail;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column pat_detail.p_name
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    private String pName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pat_detail.id
     *
     * @return the value of pat_detail.id
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pat_detail.id
     *
     * @param id the value for pat_detail.id
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pat_detail.pid
     *
     * @return the value of pat_detail.pid
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pat_detail.pid
     *
     * @param pid the value for pat_detail.pid
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pat_detail.detail
     *
     * @return the value of pat_detail.detail
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public String getDetail() {
        return detail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pat_detail.detail
     *
     * @param detail the value for pat_detail.detail
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pat_detail.eid
     *
     * @return the value of pat_detail.eid
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public Integer getEid() {
        return eid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pat_detail.eid
     *
     * @param eid the value for pat_detail.eid
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public void setEid(Integer eid) {
        this.eid = eid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pat_detail.e_name
     *
     * @return the value of pat_detail.e_name
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public String geteName() {
        return eName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pat_detail.e_name
     *
     * @param eName the value for pat_detail.e_name
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public void seteName(String eName) {
        this.eName = eName == null ? null : eName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pat_detail.time
     *
     * @return the value of pat_detail.time
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pat_detail.time
     *
     * @param time the value for pat_detail.time
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pat_detail.pat_detail
     *
     * @return the value of pat_detail.pat_detail
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public String getPatDetail() {
        return patDetail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pat_detail.pat_detail
     *
     * @param patDetail the value for pat_detail.pat_detail
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public void setPatDetail(String patDetail) {
        this.patDetail = patDetail == null ? null : patDetail.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column pat_detail.p_name
     *
     * @return the value of pat_detail.p_name
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public String getpName() {
        return pName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column pat_detail.p_name
     *
     * @param pName the value for pat_detail.p_name
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public void setpName(String pName) {
        this.pName = pName == null ? null : pName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table pat_detail
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
        sb.append(", pid=").append(pid);
        sb.append(", detail=").append(detail);
        sb.append(", eid=").append(eid);
        sb.append(", eName=").append(eName);
        sb.append(", time=").append(time);
        sb.append(", patDetail=").append(patDetail);
        sb.append(", pName=").append(pName);
        sb.append("]");
        return sb.toString();
    }
}