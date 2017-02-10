package com.realmexample.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.realmexample.R;
import br.com.infoterras.realmmodule.model.Person;

import br.com.infoterras.realmmodule.DataManager;
import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

/**
 * Created by Gustavo on 31/01/2017.
 */

public class PersonAdapter extends RealmRecyclerViewAdapter<Person, PersonAdapter.PersonViewHolder> {

    public PersonAdapter(@NonNull Context context, @Nullable OrderedRealmCollection<Person> data, boolean autoUpdate) {
        super(context, data, autoUpdate);
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_person_list, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        final Person person = getItem(position);

        holder.id.setText(String.valueOf(person.getId()));
        holder.name.setText(person.getName());
        holder.age.setText(String.valueOf(person.getAge()));
        holder.dogName.setText(person.getDogs().get(0).getName());
        holder.dogColor.setText(person.getDogs().get(0).getColor());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person p = DataManager.selectById(person.getId(), Person.class);

                Toast.makeText(context, String.format("id:%s name:%s age:%s", p.getId(), p.getName(), p.getAge()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    class PersonViewHolder extends RecyclerView.ViewHolder {

        TextView id;
        TextView name;
        TextView age;
        TextView dogName;
        TextView dogColor;

        PersonViewHolder(View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.id);
            name = (TextView) itemView.findViewById(R.id.name);
            age = (TextView) itemView.findViewById(R.id.age);
            dogName = (TextView) itemView.findViewById(R.id.dog_name);
            dogColor = (TextView) itemView.findViewById(R.id.dog_color);
        }
    }
}
