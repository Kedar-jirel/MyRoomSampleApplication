package np.com.infodev.myroomapplication;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by sanjay on 4/27/2018.
 */

@Dao
public interface WordDao {
    @Insert
    void insert(ContactDetails contactDetails);

    @Query("DELETE FROM Contact_Details")
    void deleteAll();

    @Query("SELECT * from Contact_Details ORDER BY word ASC")
    LiveData<List<ContactDetails>> getAllWords();

}
