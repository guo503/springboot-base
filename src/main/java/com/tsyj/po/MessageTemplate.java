package com.tsyj.po;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString(callSuper = true)
public class MessageTemplate implements Serializable {

    private static final long serialVersionUID = 5219075982491658147L;

    /**
     * 消息头部
     */
    private String first;

    /**
     * 关键字1
     */
    private String keyword1;

    /**
     * 关键字2
     */
    private String keyword2;

    /**
     * 关键字3
     */
    private String keyword3;

    /**
     * 关键字4
     */
    private String keyword4;

    /**
     * 关键字5
     */
    private String keyword5;

    /**
     * 消息备注
     */
    private String remark;

    /**
     * 用户openId
     */
    private String touser;

    /**
     * 模板id
     */
    private String template_id;

    /**
     * 点击跳转页面
     */
    private String page;

    /**
     * 服务号中需要跳转的页面
     */
    private String url;

    /**
     * 模板数据
     */
    private Object data;

    /**
     * 关键字显示
     */
    private String emphasis_keyword;

    /**
     * 表单id
     */
    private String form_id;

    /**
     * 业务id
     */
    private Integer id;

}
