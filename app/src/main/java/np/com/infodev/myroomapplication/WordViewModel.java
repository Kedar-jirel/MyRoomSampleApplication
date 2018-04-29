package np.com.infodev.myroomapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

/**
 * Created by sanjay on 4/27/2018.
 */

public class WordViewModel  extends AndroidViewModel {
    private WordRepository mRepository;

    private LiveData<List<ContactDetails>> mAllWords;

    public WordViewModel (Application application) {
        super(application);
        mRepository = new WordRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    LiveData<List<ContactDetails>> getAllWords() { return mAllWords; }

    public void insert(ContactDetails contactDetails) { mRepository.insert(contactDetails); }

    public  void deleteAllWords(){
        mRepository.deleteAllWords();
    }
}
