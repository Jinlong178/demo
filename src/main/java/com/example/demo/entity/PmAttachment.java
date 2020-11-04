package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
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
 * @author JinLong
 * @since 2020-11-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PmAttachment implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId("ID")
    private String id;

    /**
     * 文件真实名称，没有后缀
     */
    @TableField("SIMPLE_NAME")
    private String simpleName;

    /**
     * 文件名称，有后缀
     */
    @TableField("NAME")
    private String name;

    /**
     * 文件在服务器中的逻辑名称，有后缀
     */
    @TableField("LOGIC_NAME")
    private String logicName;

    /**
     * 后缀
     */
    @TableField("SUFFIX")
    private String suffix;

    /**
     * 文件在服务器中的绝对路径
     */
    @TableField("ABSOLUTE_PATH")
    private String absolutePath;

    /**
     * 文件在服务器中的目录
     */
    @TableField("CATALOG_PATH")
    private String catalogPath;

    /**
     * 文件在服务器中的目录，相对地址
     */
    @TableField("PATH")
    private String path;

    /**
     * 文件大小
     */
    @TableField("FILE_SIZE")
    private Long fileSize;


}
