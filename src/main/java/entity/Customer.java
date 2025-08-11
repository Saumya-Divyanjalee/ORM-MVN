package entity;

import jakarta.persistence.*;

//@ annotation - meta data - codeing krnn one na, dila tiye already use krnn withri tiyenne(define krla tiye ona that gnn tiyenne)
@Entity//ER entity eke class ekk arn ,@Entity dala next @Table dala table name eka denn
@Table(name = "customer_table")
public class Customer {

    @Id//database table eke specialma de primary key eka eka define krnn @Id use krnn - manualy denn primary key


    @GeneratedValue(strategy = GenerationType.IDENTITY)//IDENTITY dapu gmn auto increment feature eka labe - data type eka consider krnn aniwa
    //AUTO dammoth data base eka auto mokk hari id ekk create krla dnwa(JPA eka thama database eka blala eka genarate krnne) JPA picks best strategy based on database dialect
    //SEQUENCE - using database SEQUENCE

    //data type eka defin krnn - number nm int/double , varchar nm String , price walt use BigDecimal gnn
    // variable name eka database row name ekt gnnwa eka change krnn puluwn @Column use krma
    @Column(name = "Customer_name", nullable = false)//nullable ? null wenn puluwnd baid , ba nm false , puluwnnm - true

    private int id;
    private String name;


    public Customer(){}

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}
