package dk.sdu.mmmi.cbse.collision;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ColliderTest {

    @Test
    void process() {
        //Create new collider
        Collider col = new Collider();

        //Use mockito to mock GameData and World
        GameData gameData = mock(GameData.class);
        World world = mock(World.class);

        //Create entities
        Entity ent1 = new Entity();
        ent1.setRadius(5);
        ent1.add(new PositionPart(0,0,5));
        ent1.add(new LifePart(1, 69));

        Entity ent2 = new Entity();
        ent2.setRadius(5);
        ent2.add(new PositionPart(0,0,5));
        ent2.add(new LifePart(2, 69));

        //Add entity to world
        world.addEntity(ent1);
        world.addEntity(ent2);

        when(world.getEntities()).thenReturn(Arrays.asList(ent1, ent2));

        //Start process
        col.process(gameData, world);

        verify(world).removeEntity(ent1);

    }

    @Test
    void removeExpired(){
        //Create new collider
        Collider col = new Collider();

        //Use mockito to mock GameData and World
        GameData gameData = mock(GameData.class);
        World world = mock(World.class);

        //Create entities
        Entity ent1 = new Entity();
        ent1.setRadius(5);
        ent1.add(new PositionPart(0,0,5));
        ent1.add(new LifePart(1, -5));

        Entity ent2 = new Entity();
        ent2.setRadius(5);
        ent2.add(new PositionPart(0,0,5));
        ent2.add(new LifePart(2, -5));

        when(world.getEntities()).thenReturn(Arrays.asList(ent1, ent2));
        col.process(gameData, world);
        verify(world, times(3)).removeEntity(ent1);
        verify(world, times(2)).removeEntity(ent2);
    }

    @Test
    void collidesTrue() {
        //Create new collider
        Collider col = new Collider();

        //Create entities
        Entity ent1 = new Entity();
        ent1.setRadius(5);
        ent1.add(new PositionPart(0,0,5));

        Entity ent2 = new Entity();
        ent2.setRadius(5);
        ent2.add(new PositionPart(0,0,5));

        assertTrue(col.Collides(ent1, ent2));
    }

    @Test
    void collidesFalse(){
        //Create new collider
        Collider col = new Collider();

        //Create entities
        Entity ent1 = new Entity();
        ent1.setRadius(5);
        ent1.add(new PositionPart(50,50,5));

        Entity ent2 = new Entity();
        ent2.setRadius(5);
        ent2.add(new PositionPart(0,0,5));

        assertFalse(col.Collides(ent1, ent2));
    }
}