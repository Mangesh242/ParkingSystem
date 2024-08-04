package org.example.dtos;

public class BillRequestDTO {
    Integer ticketId;
    String exitGateNo;

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getExitGateNo() {
        return exitGateNo;
    }

    public void setExitGateNo(String exitGateNo) {
        this.exitGateNo = exitGateNo;
    }
}
