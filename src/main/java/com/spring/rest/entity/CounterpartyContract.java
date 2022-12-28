package entitys;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "counterparty_contracts")
@Entity
public class ContractCounterparties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;

    @Override
    public String toString() {
        return "ContractCounterparties{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", organization=" + organization +
                ", amount=" + amount +
                ", actual_start=" + actual_start +
                ", actual_end=" + actual_end +
                ", planned_start=" + planned_start +
                ", planned_end=" + planned_end +
                '}';
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organization_id")
    private CounterpartyOrganization organization;


    @Column(name="amount")
    private int amount;

    @Column(name="actual_start")
    private Date actual_start;

    @Column(name="actual_end")
    private Date actual_end;

    @Column(name="planned_start")
    private Date planned_start;

    @Column(name="planned_end")
    private Date planned_end;

    public ContractCounterparties() {
    }

    public ContractCounterparties(String name, String type, int amount, Date actual_start, Date actual_end, Date planned_start, Date planned_end) {
        this.name = name;
        this.type = type;
        this.amount = amount;
        this.actual_start = actual_start;
        this.actual_end = actual_end;
        this.planned_start = planned_start;
        this.planned_end = planned_end;
    }

    public void setContractCounterparty(CounterpartyOrganization organization) {
        this.organization = organization;
        organization.addContract(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getActual_start() {
        return actual_start;
    }

    public void setActual_start(Date actual_start) {
        this.actual_start = actual_start;
    }

    public Date getActual_end() {
        return actual_end;
    }

    public void setActual_end(Date actual_end) {
        this.actual_end = actual_end;
    }

    public Date getPlanned_start() {
        return planned_start;
    }

    public void setPlanned_start(Date planned_start) {
        this.planned_start = planned_start;
    }

    public CounterpartyOrganization getOrganization() {
        return organization;
    }

    public void setOrganization(CounterpartyOrganization organization) {
        this.organization = organization;
    }

    public Date getPlanned_end() {
        return planned_end;
    }

    public void setPlanned_end(Date planned_end) {
        this.planned_end = planned_end;
    }
}
