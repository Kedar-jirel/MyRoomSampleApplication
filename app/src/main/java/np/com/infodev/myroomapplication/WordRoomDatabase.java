package np.com.infodev.myroomapplication;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by sanjay on 4/27/2018.
 */

@Database(entities = {Word.class}, version = 1)
public abstract class WordRoomDatabase extends RoomDatabase{
    public abstract WordDao wordDao();
    private static WordRoomDatabase INSTANCE;

    public static WordRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                            .build();
                    // Create database here
                }
            }
        }
        return INSTANCE;
    }
}
