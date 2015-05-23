package world;

import com.jme3.app.state.AbstractAppState;
import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import java.util.ArrayList;

public class SceneLoader extends AbstractAppState
{
    private static AssetManager assetManager;
    
    public static Spatial[] loadScene(String reference)
    {
        Spatial[] spatialArray = new Spatial[2];
        
        // Earth (NOTE: we should use a heightmap instead of a large geometry object)
        Geometry earth_g = new Geometry("Earth", new Box(50, 1, 50));
        Material earth_m = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        earth_m.setTexture("ColorMap", assetManager.loadTexture("Textures/grass2.png"));
        earth_g.setMaterial(earth_m);
        earth_g.setLocalTranslation(2.0f, -2.5f, 0.0f);
        spatialArray[0] = earth_g;
            
        // Scene: Wall 01
        Geometry wall_g01 = new Geometry("Wall01", new Box(5, 3, 1));
        Material wall_m = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        wall_m.setTexture("ColorMap", assetManager.loadTexture("Textures/stone2.png"));
        wall_g01.setMaterial(wall_m);
        wall_g01.setLocalTranslation(4.0f, -2.5f, 0.0f);
        spatialArray[1] = wall_g01;
        
        /*Spatial[] spatialArray = new Spatial[spatialList.size()];
        spatialArray = spatialList.toArray(spatialArray);*/
        return spatialArray;
    }
}