package fly.speedmeter.grub;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
class MyGPSData {

    public String m_myTime;
    public String m_myMaxSpeed;
    public String m_myAvgSpeed;
    public String m_myDistance;
    public String m_accelByX;
    public String m_accelByY;

    public MyGPSData() {

    }

    public MyGPSData(String time, String maxSpeed, String avgSpeed, String distance, String accelByX, String accelByY) {
        this.m_myTime = time;
        this.m_myMaxSpeed = maxSpeed;
        this.m_myAvgSpeed = avgSpeed;
        this.m_myDistance = distance;
        this.m_accelByX = accelByX;
        this.m_accelByY = accelByY;
    }
}
