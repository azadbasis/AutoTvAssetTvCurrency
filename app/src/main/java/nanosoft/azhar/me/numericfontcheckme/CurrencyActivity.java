package nanosoft.azhar.me.numericfontcheckme;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class CurrencyActivity extends AppCompatActivity {
    ListView listCurrency;
    Set<Currency> availableCurrenciesSet;
    List<Currency> availableCurrenciesList;
    ArrayAdapter<Currency> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);
        listCurrency = (ListView)findViewById(R.id.currencylist);

        //available from API Level 19
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            availableCurrenciesSet =
                    Currency.getAvailableCurrencies();
        }

        availableCurrenciesList = new ArrayList<Currency>(availableCurrenciesSet);
        adapter = new ArrayAdapter<Currency>(
                this,
                android.R.layout.simple_list_item_1,
                availableCurrenciesList);
        listCurrency.setAdapter(adapter);

        listCurrency.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Currency currency = (Currency) parent.getItemAtPosition(position);
                String currencyCode = currency.getCurrencyCode();


                String displayName = null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
                    displayName = currency.getDisplayName();
                }
                String symbol = currency.getSymbol();
String symbols= currency.getSymbol(Locale.ROOT);
                Toast.makeText(CurrencyActivity.this,
                        displayName + "\n" +
                                currencyCode + "\n" +
                                symbol+"\n"+symbols,
                        Toast.LENGTH_LONG).show();
            }});
    }


}
