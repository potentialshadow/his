package com.woniuxy.cq.soft.entity;

public class RolePermission {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_permission.id
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_permission.rid
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    private Integer rid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_permission.mid
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    private Integer mid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_permission.id
     *
     * @return the value of role_permission.id
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_permission.id
     *
     * @param id the value for role_permission.id
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_permission.rid
     *
     * @return the value of role_permission.rid
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public Integer getRid() {
        return rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_permission.rid
     *
     * @param rid the value for role_permission.rid
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public void setRid(Integer rid) {
        this.rid = rid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_permission.mid
     *
     * @return the value of role_permission.mid
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public Integer getMid() {
        return mid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_permission.mid
     *
     * @param mid the value for role_permission.mid
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    public void setMid(Integer mid) {
        this.mid = mid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_permission
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
        sb.append(", rid=").append(rid);
        sb.append(", mid=").append(mid);
        sb.append("]");
        return sb.toString();
    }
}