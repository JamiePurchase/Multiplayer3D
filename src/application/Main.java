package application;

import com.jme3.app.SimpleApplication;
import com.jme3.font.BitmapText;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

public class Main extends SimpleApplication
{
    
    /* STILL TO DO: characters, scenery, collision, equipment, abilities, objectives, audio
    ** CONSIDER: more powerful spells require much longer to cast (speed-up by casting with an ally)
    */

    public static void main(String[] args)
    {
        // Custom Settings
        AppSettings settings = new AppSettings(true);
        settings.setResolution(1366, 768);
        settings.setFullscreen(true);
        //settings.setIcons(); <--- do this later
        
        // Launch Application
        Main app = new Main(); 
        app.setSettings(settings);
        app.setShowSettings(false);
        app.start();
    }
    
    private void sceneLoad(String scene)
    {
        // Clear Scene
        rootNode.detachAllChildren();
        guiNode.detachAllChildren();
        
        // Build Scene
        if(scene.equals("LOBBY"))
        {
            // Barracks
            viewPort.setBackgroundColor(new ColorRGBA(0f, 0f, 0f, 1f));
            Geometry lobbyFloor_g = new Geometry("LobbyFloor", new Box(25, 1, 25));
            Material lobbyFloor_m = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
            lobbyFloor_m.setTexture("ColorMap", assetManager.loadTexture("Textures/stone1.png"));
            lobbyFloor_g.setMaterial(lobbyFloor_m);
            lobbyFloor_g.setLocalTranslation(2.0f, -2.5f, 0.0f);
            rootNode.attachChild(lobbyFloor_g);
        }
        // NOTE: specify more IF statements later
        else
        {
            // Battlefield
            // NOTE: we should use a heightmap instead of a large geometry object
            viewPort.setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));
            Geometry earth_g = new Geometry("Earth", new Box(50, 1, 50));
            Material earth_m = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
            earth_m.setTexture("ColorMap", assetManager.loadTexture("Textures/grass2.png"));
            earth_g.setMaterial(earth_m);
            earth_g.setLocalTranslation(2.0f, -2.5f, 0.0f);
            rootNode.attachChild(earth_g);
            
            // Battle Info
            guiFont = assetManager.loadFont("Interface/Fonts/Default.fnt");
            BitmapText hudBattle = new BitmapText(guiFont, false);
            hudBattle.setSize(guiFont.getCharSet().getRenderedSize());
            hudBattle.setText("Battle Info");
            hudBattle.setLocalTranslation(25, hudBattle.getLineHeight() + 25, 0);
            guiNode.attachChild(hudBattle);
            
            // Player Info
            BitmapText hudPlayer = new BitmapText(guiFont, false);
            hudPlayer.setSize(guiFont.getCharSet().getRenderedSize());
            hudPlayer.setText("Player Info");
            hudPlayer.setLocalTranslation(1366 - (hudPlayer.getLineWidth() + 25), hudPlayer.getLineHeight() + 25, 0);
            guiNode.attachChild(hudPlayer);
        }
    }

    @Override
    public void simpleInitApp()
    {
        // Clear HUD
        setDisplayFps(false);
        setDisplayStatView(false);
        
        // Load Scene (NOTE: look at actual scene files later)
        //sceneLoad("LOBBY");
        sceneLoad("x");
    }

    @Override
    public void simpleUpdate(float tpf)
    {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm)
    {
        //TODO: add render code
    }
}