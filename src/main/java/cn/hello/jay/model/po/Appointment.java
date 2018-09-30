package cn.hello.jay.model.po;

import java.util.Date;

/**
 * 预约信息
 */
public class Appointment {
    /**
     * 自增id
     */
    private int id;
    /**
     * 外部用户id
     */
    private String jszh;
    /**
     * 预约开始时间
     */
    private Date startTime;
    /**
     * 预约结束时间
     */
    private Date endTime;
    /**
     * 0：初始状态，1：成功
     */
    private int status;
    /**
     * 备注信息
     */
    private String remark;
    /**
     * 是否删除（0：否，1：是）
     */
    private Boolean isDeleted;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJszh() {
        return jszh;
    }

    public void setJszh(String jszh) {
        this.jszh = jszh;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
