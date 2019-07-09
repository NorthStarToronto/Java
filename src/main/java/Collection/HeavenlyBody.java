package Collection;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {

    private final String name;
    private final double orbitnalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitnalPeriod) {
        this.name = name;
        this.orbitnalPeriod = orbitnalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitnalPeriod() {
        return orbitnalPeriod;
    }

    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    /* Creating a new HashSet with the current contents */
    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }


    /* Must Override both equals method and hascode method */
    // Without the @Override & equals(HeavenlyBody obj) => Overload
    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }
        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());

        if((obj==null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return super.hashCode() + 57;
    }
}
