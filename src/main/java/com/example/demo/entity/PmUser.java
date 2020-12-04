package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Something
 * @since 2020-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PmUser implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "ID")
    private String id;

    /**
     * 用户名
     */
    @TableField("NAME")
    private String name;

    /**
     * 密码
     */
    @TableField("PASS_WORD")
    private String passWord;

    /**
     * 手机号
     */
    @TableField("PHONE")
    private String phone;

    /**
     * 头像
     */
    @TableField("IMG")
    private String img;

    /**
     * 性别
     *  0:女，1：男
     */
    @TableField("SEX")
    private int sex;

    /**
     * 创建时间
     */
    @TableField("CREAT_TIME")
    private LocalDateTime creatTime;

    /**
     * 更新时间
     */
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    /**
     * 删除标志
     */
    @TableField("DEL")
    private Integer del;

}
