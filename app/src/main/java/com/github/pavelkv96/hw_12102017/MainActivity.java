package com.github.pavelkv96.hw_12102017;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.pavelkv96.hw_12102017.http.GetPostHttpClient;
import com.github.pavelkv96.hw_12102017.http.IHttpClient;
import com.github.pavelkv96.hw_12102017.http.Response;
import com.github.pavelkv96.hw_12102017.model.PhoneBook;
import com.github.pavelkv96.hw_12102017.parser.GsonPhoneBookParser;
import com.github.pavelkv96.hw_12102017.parser.Parser;

public class MainActivity extends AppCompatActivity {
    //private static final String PHONE_BOOK_POST_URL = "http://10.0.2.2:8080/_ah/api/myPhoneBookApi/v1/myPhoneBook";
    private static final String PHONE_BOOK_POST_URL = "https://lapitchat-2db73.appspot.com/_ah/api/myPhoneBookApi/v1/myPhoneBook";

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText addressEditText;
    private EditText numberEditText;
    private Button sendInPhoneBookButton;
    private IHttpClient httpClient;
    private Parser<PhoneBook> phoneBookParser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        httpClient = new GetPostHttpClient();
        phoneBookParser = new GsonPhoneBookParser();

        firstNameEditText =(EditText)findViewById(R.id.first_name_editText);
        lastNameEditText =(EditText)findViewById(R.id.last_name_editText);
        addressEditText =(EditText)findViewById(R.id.address_editText);
        numberEditText =(EditText)findViewById(R.id.number_editText);

        sendInPhoneBookButton = (Button) findViewById(R.id.send_in_phone_book_button);
        sendInPhoneBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhoneBook phoneBook = new PhoneBook();

                phoneBook.setFirstName(firstNameEditText.getText().toString());
                phoneBook.setLastName(lastNameEditText.getText().toString());
                phoneBook.setAddress(addressEditText.getText().toString());
                phoneBook.setNumber(numberEditText.getText().toString());

                Response response = httpClient.doPost(PHONE_BOOK_POST_URL, phoneBookParser.toJson(phoneBook));

                try {
                    /* parse json message with id set on server */
                    phoneBook = phoneBookParser.parse(response.getText());
                    Toast.makeText(getApplication(), phoneBook.toString(), Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.getMessage();
                }
            }
        });
    }
}
