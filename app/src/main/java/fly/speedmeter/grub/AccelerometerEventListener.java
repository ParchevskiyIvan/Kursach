package fly.speedmeter.grub;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;
import android.widget.TextView;

public class AccelerometerEventListener implements SensorEventListener {

	TextView output;
	LineGraphView graph;
	float[] record = new float[3];

	public AccelerometerEventListener (TextView outputView, LineGraphView graph){
		output = outputView;
		this.graph = graph;
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		if(event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			max(event.values);
			output.setText(String.format("Proper acceleration on x, y, z axis:\n(%,5.2f, %,5.2f, %,5.2f) in m/s^2 "
							+ "\nMaximum record value:\n(%,6.2f, %,6.2f, %,6.2f) in m/s^2\n\n",
					event.values[0], event.values[1], event.values[2], record[0], record[1], record[2]));
			Log.e("AccelEventListener", event.values[0] + " " + event.values[1] + "");
			graph.addPoint(event.values);
		}
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

	private void max(float[] current){
		if (record[0]*record[0] + record[1]*record[1] + record[2]*record[2] <
				current[0]*current[0] + current[1]*current[1] + current[2]*current[2]){
			record[0] = current[0];
			record[1] = current[1];
			record[2] = current[2];
		}
	}
}
