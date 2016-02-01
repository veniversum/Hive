package hive.effects;

import hive.Universe;

public class PopulationEffect implements EffectInterface {
    String o;
    int c;
    char ch;

    public PopulationEffect(String objName, int count) {
        o = objName;
        c = count;
    }

    public PopulationEffect(String objName, char choice, int count) {
        o = objName;
        c = count;
        ch = choice;
    }

    @Override
    public void runEffect() {
        if (ch == '\u0000') {
            Universe.populationEffect(o, c);
        } else {
            Universe.populationEffect(o, ch, c);
        }
    }
}
