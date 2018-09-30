package cn.hello.jay.model.vo;

public class LoginResponse {

    /**
     * 成功code=0
     */
    private String status;

    private String code;

    private String jszh;

    private String resouce;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public void setJszh(String jszh) {
        this.jszh = jszh;
    }

    public String getJszh() {
        return this.jszh;
    }

    public void setResouce(String resouce) {
        this.resouce = resouce;
    }

    public String getResouce() {
        return this.resouce;
    }
}
