/**
 * Created by bhan on 1/31/16.
 */
public class PropertyEffect implements EffectInterface {

    String o;
    String p;
    String n;

    public PropertyEffect(String objName, String property, String newValue) {

        o = objName;
        p = property;
        n = newValue;

    }

    @Override
    public void runEffect() {

        Universe.propertyEffect(o, p, n);

    }
}
