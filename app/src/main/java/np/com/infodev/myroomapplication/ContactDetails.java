package np.com.infodev.myroomapplication;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by sanjay on 4/27/2018.
 */

@Entity(tableName = "Contact_Details")
public class ContactDetails implements Serializable{

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    protected int id;


    @ColumnInfo(name = "word")
    private String Name;


    @ColumnInfo(name = "Email")
    private String Email;

    @ColumnInfo(name = "Phone_number")
    private Long PhoneNumber;

    @Ignore
    public ContactDetails( @NonNull String Name, @NonNull String Email, @NonNull Long PhoneNumber) {
        this.Name = Name;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
    }

    public ContactDetails() {

    }

    public ContactDetails(String name) {
        this.Name = name;
    }


    public int getId() {
        return id;
    }


    public String getName() {
        return Name;
    }


    public String getEmail() {
        return Email;
    }

    public Long getPhoneNumber() {
        return PhoneNumber;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setEmail(String email) {
        this.Email = email;
    }


    public void setPhoneNumber(Long PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }
}
