package com.poly.midware.entity;

/**
 * 员工实体
 */
public class StuffEntity {
    /**数据库流水ID*/
    private int ids;

    /**平台主账户 工号*/
    private String userName;
    /**用户显示的名称（名字）*/
    private String displayName;
    /**名字全拼*/
    private String namePingyin;
    /**用户ID*/
    private String id;
    /**平台主账户密码*/
    private String password;
    /**邮箱*/
    private String emails;
    /**手机号*/
    private String phoneNumber;
    /**所属组织机构的uuid*/
    private String organizationUuid;
    /**上级领导工号*/
    private String leader;
    /**身份证号*/
    private String idCard;
    /**岗位ID*/
    private String jobId;
    /**岗位名称*/
    private String jobName;
    /**试用，正常数字*/
    private String status;
    /**组织机构名称*/
    private String organizaitonName;
    /**和OA关联的Code*/
    private String linkingCode;


    /**同步失败，原因*/
    private String errorInfo;
    /**创建时间*/
    private String createTime;
    /**最后操作时间*/
    private String ts;
    /**删除标记*/
    private String archived;
    /**是否已同步*/
    private String handleFlag;
    /**是否同步成功*/
    private String success;
    /**推送次数记录*/
    private int pushNumber;

    @Override
    public String toString() {
        return "StuffEntity{" +
                "ids=" + ids +
                ", userName='" + userName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", namePingyin='" + namePingyin + '\'' +
                ", id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", emails='" + emails + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", organizationUuid='" + organizationUuid + '\'' +
                ", leader='" + leader + '\'' +
                ", idCard='" + idCard + '\'' +
                ", jobId='" + jobId + '\'' +
                ", jobName='" + jobName + '\'' +
                ", status='" + status + '\'' +
                ", organizaitonName='" + organizaitonName + '\'' +
                ", linkingCode='" + linkingCode + '\'' +
                ", errorInfo='" + errorInfo + '\'' +
                ", createTime='" + createTime + '\'' +
                ", ts='" + ts + '\'' +
                ", archived='" + archived + '\'' +
                ", handleFlag='" + handleFlag + '\'' +
                ", success='" + success + '\'' +
                ", pushNumber=" + pushNumber +
                '}';
    }

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getNamePingyin() {
        return namePingyin;
    }

    public void setNamePingyin(String namePingyin) {
        this.namePingyin = namePingyin;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOrganizationUuid() {
        return organizationUuid;
    }

    public void setOrganizationUuid(String organizationUuid) {
        this.organizationUuid = organizationUuid;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrganizaitonName() {
        return organizaitonName;
    }

    public void setOrganizaitonName(String organizaitonName) {
        this.organizaitonName = organizaitonName;
    }

    public String getLinkingCode() {
        return linkingCode;
    }

    public void setLinkingCode(String linkingCode) {
        this.linkingCode = linkingCode;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getArchived() {
        return archived;
    }

    public void setArchived(String archived) {
        this.archived = archived;
    }

    public String getHandleFlag() {
        return handleFlag;
    }

    public void setHandleFlag(String handleFlag) {
        this.handleFlag = handleFlag;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public int getPushNumber() {
        return pushNumber;
    }

    public void setPushNumber(int pushNumber) {
        this.pushNumber = pushNumber;
    }
}
