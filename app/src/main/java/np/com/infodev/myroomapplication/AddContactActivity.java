package np.com.infodev.myroomapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddContactActivity extends AppCompatActivity {


    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    private EditText mEditextName, mEdittextEmail, mEditextPhoneNumber;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        mEditextName = findViewById(R.id.activity_add_contact_name);
        mEdittextEmail = findViewById(R.id.activity_add_contact_email);
        mEditextPhoneNumber = findViewById(R.id.activity_add_contact_phone_number);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditextName.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else if (TextUtils.isEmpty(mEdittextEmail.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else if (TextUtils.isEmpty(mEditextPhoneNumber.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    replyIntent.putExtra(EXTRA_REPLY, new ContactDetails(mEditextName.getText().toString(),
                            mEdittextEmail.getText().toString(), Long.parseLong(mEditextPhoneNumber.getText().toString())));
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
