package fly.speedmeter.grub;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DataFromDB extends AppCompatActivity {

    private TextView time, maxSpeed, averageSpeed, distance;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_from_db);

        time = (TextView)findViewById(R.id.timeDB);
        maxSpeed = (TextView)findViewById(R.id.maxSpeedDB);
        averageSpeed = (TextView)findViewById(R.id.averageSpeedDB);
        distance = (TextView)findViewById(R.id.distanceDB);

        myRef = FirebaseDatabase.getInstance().getReference("Data");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnap : dataSnapshot.getChildren())
                {
                    MyGPSData data = dataSnap.getValue(MyGPSData.class);
                    if(data != null) {
                        time.setText(data.m_myTime);
                        maxSpeed.setText(data.m_myMaxSpeed);
                        averageSpeed.setText(data.m_myAvgSpeed);
                        distance.setText(data.m_myDistance);
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
