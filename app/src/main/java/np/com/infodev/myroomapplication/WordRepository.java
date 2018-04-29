package np.com.infodev.myroomapplication;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by sanjay on 4/27/2018.
 */

public class WordRepository {

    private WordDao mWordDao;
    private LiveData<List<ContactDetails>> mAllWords;

    WordRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    LiveData<List<ContactDetails>> getAllWords() {
        return mAllWords;
    }


    public void insert(ContactDetails contactDetails) {
        new insertAsyncTask(mWordDao).execute(contactDetails);
    }

    public void deleteAllWords() {
        new deletAllAsyncTask(mWordDao).execute();
    }

    private static class insertAsyncTask extends AsyncTask<ContactDetails, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final ContactDetails... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class deletAllAsyncTask extends AsyncTask<Void, Void, Void> {
        private WordDao mAsyncTaskDao;

        public deletAllAsyncTask(WordDao mWordDao) {
            this.mAsyncTaskDao = mWordDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }


}
