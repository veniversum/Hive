package hive.effects;

import hive.Universe;

public class CreateEffect implements EffectInterface {

    @Override
    public void runEffect() {

        Universe.creationEffect();

    }
}
