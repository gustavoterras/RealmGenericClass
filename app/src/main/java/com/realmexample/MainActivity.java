package com.realmexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.realmexample.adapter.PersonAdapter;
import com.realmexample.dao.DataManager;
import com.realmexample.model.Dog;
import com.realmexample.model.Filter;
import com.realmexample.model.Person;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(this);

        populateList(null);
    }

    @Override
    public void onClick(View view) {
        EditText name = (EditText) findViewById(R.id.name);
        EditText age = (EditText) findViewById(R.id.age);

        EditText dogName = (EditText) findViewById(R.id.dog_name);
        EditText dogColor = (EditText) findViewById(R.id.dog_color);

        Person p = new Person();
        p.setId(DataManager.getNextId(Person.class));
        p.setName(name.getText().toString());
        p.setAge(Integer.parseInt(age.getText().toString()));

        Dog dog = new Dog();
        dog.setName(dogName.getText().toString());
        dog.setColor(dogColor.getText().toString());

        p.setDogs(new RealmList<>(dog));

        DataManager.save(p);

        populateList(null);
    }

    public void populateList(Filter filter){

        PersonAdapter adapter;
        if(filter == null)
            adapter = new PersonAdapter(this, DataManager.selectAll(Person.class), true);
        else {
            switch (filter.getType()) {
                case 1:
                    adapter = new PersonAdapter(this, DataManager.selectEqualsTo(Person.class, filter.getArgs1(), filter.getArgs2()), true);
                    break;
                case 2:
                    adapter = new PersonAdapter(this, DataManager.selectLessThan(Person.class, filter.getArgs1(), Integer.parseInt(filter.getArgs2())), true);
                    break;
                default:
                    adapter = new PersonAdapter(this, DataManager.selectAll(Person.class), true);
            }
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        int selectedId = radioGroup.getCheckedRadioButtonId();

        switch (selectedId) {
            case R.id.filterAge:
                populateList(new Filter(2, "age", "18"));
                break;
            case R.id.filterColor:
                populateList(new Filter(1, "dogs.color", "preto"));
                break;
            default:
                populateList(null);
                break;
        }
    }
}
