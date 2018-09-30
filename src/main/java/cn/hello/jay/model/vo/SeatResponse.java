package cn.hello.jay.model.vo;

public class SeatResponse {

    private String seatId;

    /**
     * 1:无空位
     */
    private String status;

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
