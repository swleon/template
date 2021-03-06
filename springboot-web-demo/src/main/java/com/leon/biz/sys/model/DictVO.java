package com.leon.biz.sys.model;

import com.leon.base.model.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 字典数据表
 * </p>
 *
 * @author minglei.chen
 * @since 2020-12-14
 */
@ApiModel(value="字典数据",description="字典数据" )
@Data
@EqualsAndHashCode(callSuper=true)
public class DictVO extends BaseVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 字典名称
     */
    @ApiModelProperty(value="字典名称")
    private String dictName;

    /**
     * 字典排序
     */
    @ApiModelProperty(value="字典排序")
    private Integer dictSort;

    /**
     * 字典标签
     */
    @ApiModelProperty(value="字典标签")
    private String dictLabel;

    /**
     * 字典键值
     */
    @ApiModelProperty(value="字典键值")
    private String dictValue;

    /**
     * 字典类型
     */
    @ApiModelProperty(value="字典类型",example="biz_company_group")
    private String dictType;

    /**
     * 样式属性（其他样式扩展）
     */
    private String cssClass;

    /**
     * 表格回显样式
     */
    private String listClass;

    /**
     * 是否默认（Y是 N否）
     */
    @ApiModelProperty(value="是否默认（Y是 N否）")
    private String isDefault;

    /**
     * 状态（0正常 1停用）
     */
    @ApiModelProperty(value="状态（0正常 1停用）")
    private String status;

    /**
     * 备注
     */
    private String remark;


}
