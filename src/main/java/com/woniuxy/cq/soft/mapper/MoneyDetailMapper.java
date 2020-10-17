package com.woniuxy.cq.soft.mapper;

import com.woniuxy.cq.soft.entity.MoneyDetail;
import com.woniuxy.cq.soft.entity.MoneyDetailExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MoneyDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money_detail
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    long countByExample(MoneyDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money_detail
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    int deleteByExample(MoneyDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money_detail
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money_detail
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    int insert(MoneyDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money_detail
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    int insertSelective(MoneyDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money_detail
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    List<MoneyDetail> selectByExample(MoneyDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money_detail
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    MoneyDetail selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money_detail
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    int updateByExampleSelective(@Param("record") MoneyDetail record, @Param("example") MoneyDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money_detail
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    int updateByExample(@Param("record") MoneyDetail record, @Param("example") MoneyDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money_detail
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    int updateByPrimaryKeySelective(MoneyDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table money_detail
     *
     * @mbg.generated Fri Oct 16 11:11:27 CST 2020
     */
    int updateByPrimaryKey(MoneyDetail record);
    List<Map<String,Object>> selectOutMonry(Integer paid);

    List<MoneyDetail> selectByTime(Integer patId);
}