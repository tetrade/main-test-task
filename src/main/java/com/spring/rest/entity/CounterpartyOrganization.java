package entitys;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "counterparty_organizations")
@Entity
public class CounterpartyOrganization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;


    @Column(name="inn")
    private String inn;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    private List<ContractCounterparties> contracts;

    public CounterpartyOrganization() {
    }

    public CounterpartyOrganization(String name, String address, String inn) {
        this.address = address;
        this.name = name;
        this.inn = inn;
    }

    @Override
    public String toString() {
        return "entitys.CounterpartyOrganization{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", inn=" + inn +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ContractCounterparties> getContracts() {
        return contracts;
    }

    public void addContract(ContractCounterparties contract){
        if (contracts == null) {
            contracts = new ArrayList<>();
        }
        contracts.add(contract);
    }
    public void setContracts(List<ContractCounterparties> organizations) {
        this.contracts = organizations;
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

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }
}
