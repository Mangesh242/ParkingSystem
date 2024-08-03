package org.example.dtos;

import org.example.models.Ticket;

public class IssueTicketResponseDTO {
    private int ticketId;
    private ResponseStatus responseStatus;
    private String failureMessage;

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getFailureMessage() {
        return failureMessage;
    }
    public void setFailureMessage(String failureMessage) {
        this.failureMessage = failureMessage;
    }
    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }
    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
