package org.example.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import org.example.domain.enums.StatePayment;

import java.util.Date;

@Entity
public class TicketPayment extends Payment {

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataPagamento;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataVencimento;

    public TicketPayment() {

    }

    public TicketPayment(Integer id, StatePayment statePayment, PurchaseOrder purchaseOrder, Date dataVencimento, Date dataPagamento) {
        super(id, statePayment, purchaseOrder);
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
