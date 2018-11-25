package com.dhhe.blog.persistent.dao;

import com.dhhe.blog.persistent.dto.Directory;
import com.dhhe.blog.persistent.dto.DirectoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DirectoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table directory
     *
     * @mbg.generated
     */
    long countByExample(DirectoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table directory
     *
     * @mbg.generated
     */
    int deleteByExample(DirectoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table directory
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table directory
     *
     * @mbg.generated
     */
    int insert(Directory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table directory
     *
     * @mbg.generated
     */
    int insertSelective(Directory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table directory
     *
     * @mbg.generated
     */
    List<Directory> selectByExample(DirectoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table directory
     *
     * @mbg.generated
     */
    Directory selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table directory
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Directory record, @Param("example") DirectoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table directory
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Directory record, @Param("example") DirectoryExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table directory
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Directory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table directory
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Directory record);
}