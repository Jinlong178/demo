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
 * 菜单表
 * </p>
 *
 * @author Something
 * @since 2020-10-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PmSecMenu implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 菜单ID，菜单编码
     */
    @TableId("ID_")
    private String id;

    /**
     * 菜单名称
     */
    @TableField("NAME_")
    private String name;

    /**
     * 访问路径
     */
    @TableField("PATH_")
    private String path;

    /**
     * 描述
     */
    @TableField("DESCRIPTION_")
    private String description;

    /**
     * 上级权限Id
     */
    @TableField("PARENT_ID_")
    private String parentId;

    /**
     * 菜单类型
     */
    @TableField("TYPE_")
    private String type;

    /**
     * 排序
     */
    @TableField("SORT_")
    private Integer sort;

    /**
     * 图标
     */
    @TableField("ICON_")
    private String icon;

    /**
     * 所属区域页面
     */
    @TableField("SCOPE_")
    private String scope;

    /**
     * 创建时间
     */
    @TableField("CREATE_TIME_")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("UPDATE_TIME_")
    private LocalDateTime updateTime;

    /**
     * 创建人
     */
    @TableField("CREATOR_")
    private String creator;

    /**
     * 更新人
     */
    @TableField("UPDATER_")
    private String updater;

    /**
     * 逻辑删除标识
     */
    @TableField("DEL_")
    private Integer del;


}
